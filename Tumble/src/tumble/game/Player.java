package tumble.game;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import tumble.game.items.*;
import tumble.gui.Animation;
import tumble.gui.DrawingSurface;
import tumble.gui.Sound;
import processing.core.PApplet;

/**
 * Represents a movable ellipse with basic physics and rectangular collision
 * detection.
 * Credit to soundfile.com and https://themushroomkingdom.net/media/smw/wav
 * for sound files
 * 
 * @author Amanda Xu, Andra Liu, Julia Gu
 * @version May 10, 2020
 */
public class Player extends MovableRectangle {

	/**
	 * Players' shared dimensions.
	 */
	public static final int WIDTH = 40, HEIGHT = 40;
	
	private Game game;
	private ArrayList<Item> items;
	private boolean poweredUp, canJump, canBoost, hasLeaf, hasFeather, hasStick, hasStraw, hasKite;
	private final Sound boing = new Sound("audio/jump.wav");
	private final Sound swoosh = new Sound("audio/boost.wav");
	
	/**
	 * Creates an ellipse that represents a player. Player has a rectangular
	 * hit-box.
	 * 
	 * @param game	game that player belongs to
	 * @param x		x-coordinate of player's upper-left corner
	 * @param y		y-coordinate of player's upper-left corner
	 */
	public Player(Game game, float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		this.game = game;
		items = new ArrayList<Item>();
	}

	/**
	 * Accelerates this player to the left.
	 */
	public void rollLeft() {
		if (hasLeaf)
			accelerate(-2.7f, 0);
		else
			accelerate(-1.9f, 0);
	}

	/**
	 * Accelerates this player to the right.
	 */
	public void rollRight() {
		if (hasLeaf)
			accelerate(2.7f, 0);
		else
			accelerate(1.9f, 0);
	}

	/**
	 * Accelerates this player upwards if grounded.
	 */
	public void tryJump() {
		if (canJump) {
			if (DrawingSurface.hasSound())
				boing.play();
			if (hasFeather)
				accelerate(0, -17);
			else
				accelerate(0, -16f);
			canJump = false;
		}
	}
	
	/**
	 * Gives this player a horizontal boost 3 times the current velocity if in air.
	 */
	public void tryBoost() {
		if (hasStraw && canBoost && !canJump) {
			if (DrawingSurface.hasSound())
				swoosh.play();
			accelerate(getVelocityX() * 3, 0);
			canBoost = false;
		}
	}
	
	/**
	 * Accelerates this player upwards if jumping.
	 */
	public void tryGlide() {
		if (hasKite && !canJump && getVelocityY() > 0) {
			setVelocity(getVelocityX(), 4);
			accelerate(0, -0.8f);
		}
	}
	

	/**
	 * Updates this player's location according to its velocity.
	 * 
	 * @param platforms list containing rectangles to check for collision against
	 * @param items     list containing items to check for collision against
	 */
	public void update(ArrayList<Platform> platforms, ArrayList<Item> items) {
		
		accelerate(-getVelocityX()/4, 0.8f);
		
		// vines only
		for (Platform p : platforms) {
			if (hasStick && p instanceof Vine && intersects(p)) {
				accelerate(-getVelocityX()/8,  -getVelocityY()/32);
				break;
			}
		}
		
		moveByVelocity();

		canJump = false;
		for (Platform p : platforms) {
			if (!(hasStick && p instanceof Vine && intersects(p))) {
				Point2D.Float amount = collidesBy(p);
				moveBy(-amount.x, -amount.y);
				if (amount.y != 0)
					setVelocity(getVelocityX(), 0);
				else if (amount.x != 0)
					setVelocity(0, getVelocityY());
				if (amount.y > 0) {
					canJump = true;
					canBoost = true;
				}
			}
		}

		poweredUp = false;
		for (Item i : items) {
			if (intersects(i) && !this.items.contains(i)) {
				poweredUp = true;
				if (i instanceof Leaf)
					hasLeaf = true;
				else if (i instanceof Feather)
					hasFeather = true;
				else if (i instanceof Stick)
					hasStick = true;
				else if (i instanceof Straw)
					hasStraw = true;
				else if (i instanceof Kite)
					hasKite = true;
				this.items.add(i);
				game.setMessage(i.getMessage());
			}
			
		}

	}

	/**
	 * Returns this player's collected items.
	 * 
	 * @return array containing this player's collected items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Draws this player.
	 * 
	 * @param g		surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(253, 235, 0);
		if (poweredUp) {
//			Animation a = new Animation();
//			a.draw();
		} else
			g.ellipse(x + width/2, y + height/2, width, height);
	}

}