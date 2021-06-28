package tumble.game;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import tumble.gui.DrawingSurface;
import tumble.gui.SoundPlayer;

/**
 * Represents a movable ellipse with basic physics and rectangular collision detection.
 * @author Amanda Xu, Andra Liu, Julia Gu
 * @version May 21, 2020
 */
public class Player extends MovableRectangle {

	/**
	 * Players' shared dimensions.
	 */
	public static final int WIDTH = 40, HEIGHT = 40;
	
	private Game game;
	private ArrayList<Item> items;
	private boolean canJump, canBoost;
	private boolean[] hasItem;
	
	/**
	 * Creates an ellipse that represents a player. Player has a rectangular hit-box.
	 * @param game  game that player belongs to
	 * @param x  x-coordinate of player's upper-left corner
	 * @param y  y-coordinate of player's upper-left corner
	 */
	public Player(Game game, float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		this.game = game;
		items = new ArrayList<Item>();
		hasItem = new boolean[Item.ORB+1];
	}

	/**
	 * Accelerates this player to the left.
	 */
	public void rollLeft() {
		if (hasItem[Item.LEAF])
			accelerate(-2.7f, 0);
		else
			accelerate(-1.9f, 0);
	}

	/**
	 * Accelerates this player to the right.
	 */
	public void rollRight() {
		if (hasItem[Item.LEAF])
			accelerate(2.7f, 0);
		else
			accelerate(1.9f, 0);
	}

	/**
	 * Accelerates this player upwards if grounded.
	 */
	public void tryJump() {
		if (canJump) {
			if (hasItem[Item.FEATHER])
				accelerate(0, -17);
			else
				accelerate(0, -16f);
			canJump = false;
			SoundPlayer.playSound(SoundPlayer.BOING);
		}
	}
	
	/**
	 * Gives this player a horizontal boost 3 times the current velocity if in air.
	 */
	public void tryBoost() {
		if (hasItem[Item.STRAW] && canBoost && !canJump && Math.abs(getVelocityX()) > 0.01) {
			accelerate(getVelocityX() * 3, 0);
			canBoost = false;
			SoundPlayer.playSound(SoundPlayer.SWOOSH);
		}
	}
	
	/**
	 * Accelerates this player upwards if jumping.
	 */
	public void tryGlide() {
		if (hasItem[Item.KITE] && !canJump && getVelocityY() > 0) {
			setVelocityY(4);
			accelerate(0, -0.8f);
		}
	}
	

	/**
	 * Updates this player's location according to its velocity.
	 * @param platforms  list containing rectangles to check for collision against
	 * @param items  list containing items to check for collision against
	 */
	public void update(ArrayList<Platform> platforms, Item[] items) {
		
		// gravity and resistance
		accelerate(-getVelocityX()/4, 0.8f);
		
		// vines only
		for (Platform p : platforms) {
			if (hasItem[Item.STICK] && p instanceof Vine && intersects(p)) {
				accelerate(-getVelocityX()/8, -getVelocityY()/32);
				break;
			}
		}
		
		moveByVelocity();

		canJump = false;
		for (Platform p : platforms) {
			if (!(hasItem[Item.STICK] && p instanceof Vine && intersects(p))) {
				Point2D.Float amount = collidesBy(p);
				if (amount.y != 0)
					setVelocityY(0);
				else if (amount.x != 0)
					setVelocityX(0);
				if (amount.y > 0) {
					canJump = true;
					canBoost = true;
				}
				moveBy(-amount.x, -amount.y);
			}
		}

		for (int i = 0; i < items.length; i++) {
			if (intersects(items[i]) && !this.items.contains(items[i])) {
				hasItem[i] = true;
//				surface.startAnimation();
				this.items.add(items[i]);
				game.setMessage(items[i].getMessage());
			}
		}

	}

	/**
	 * Returns this player's collected items.
	 * @return array containing this player's collected items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Draws this player.
	 * @param g	PApplet surface to be drawn on
	 */
	public void draw(DrawingSurface g) {
		g.fill(253, 235, 0);
		g.ellipse(x + width/2, y + height/2, width, height);
	}


}