package tumble.game;

import java.util.ArrayList;
import processing.core.PApplet;
import tumble.items.*;

/**
 * Represents a movable ellipse with basic physics and rectangular collision
 * detection.
 * 
 * @author Amanda Xu, Andra Liu, Julia Gu
 * @version May 7, 2020
 */
public class Player extends MovableRectangle {

	/**
	 * Players' shared dimensions.
	 */
	public static final int WIDTH = 40, HEIGHT = 40;
	private ArrayList<Item> items;
	
	private boolean canJump, powerUp, canGlide, canPass, 
					hasFeather, hasLeaf, hasStick, hasStraw;
	private static final int LEFT = 0, RIGHT = 1;
	private int direction;
	private Game game;

	/**
	 * Creates an ellipse that represents a player. Player has a rectangular
	 * hit-box.
	 * 
	 * @param x x-coordinate of player's upper-left corner
	 * @param y y-coordinate of player's upper-left corner
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
		direction = LEFT;

		if(hasLeaf)
			accelerate(-1.2f, 0);
		else
			accelerate(-1, 0);

	}

	/**
	 * Accelerates this player to the right.
	 */
	public void rollRight() {
		direction = RIGHT;

		if(hasLeaf)
			accelerate(1.2f, 0);
		else
			accelerate(1, 0);

	}

	/**
	 * Accelerates this player upwards.
	 */
	public void jump() {
		if (canJump) {
			canJump = false;
			
			if(hasFeather)
				accelerate(0,-20);
			else
				accelerate(0, -16);
		}
		
	}
	
	/**
	 * Gives this player a horizontal boost 3 times the current velocity.
	 */
	public void boost() {
		if(hasStraw) {
			accelerate(getVelocityX() * 2, 0);
		}
	}
	
	/**
	 * Accelerates this player upwards when jumping.
	 */
	public void glide() {
		if(canGlide && !canJump) {
			canGlide = false;
			accelerate(0, -10);
			
		}
	}
	

	/**
	 * Updates this player's location according to its velocity.
	 * 
	 * @param platforms list containing rectangles to check for collision against
	 * @param items     list containing items to check for collision against
	 */
	public void update(ArrayList<Platform> platforms, ArrayList<Item> items) {
		
		canJump = false;
		accelerate(-getVelocityX() / 8, 0.8f);

		moveByVelocity();

		if (platforms != null) {
			for (Platform p : platforms) {
				if (!(p instanceof Vine && hasStick && canPass)) {
					float[] amount = collidesBy(p);
					moveBy(-amount[0], -amount[1]);
					if (amount[1] != 0)
						setVelocity(getVelocityX(), 0);
					else if (amount[0] != 0)
						setVelocity(0, getVelocityY());
					if (amount[1] > 0) {
						canJump = true;  // canGlide always equals !canJump
					}
				}
			}
		}

		if (items != null) {
			powerUp = false;
			for (Item i : items) {
				if (this.intersects(i) && !this.items.contains(i)) {
					this.items.add(i);
					
					for (Item it : items) {

						if (it instanceof Feather)
							hasFeather = true;
						else if (it instanceof Leaf)
							hasLeaf = true;
						else if (it instanceof Kite)
							canGlide = true;
						else if (it instanceof Stick)
							canPass = true;
						else if (it instanceof Straw)
							hasStraw = true;
						
					}
					
					
					game.setMessage(i.getMessage());
					powerUp = true;
				}
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
	 * @param g the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(253, 235, 0);
		if (powerUp) {
			// power up animation (https://processing.org/examples/animatedsprite.html)
		} else {
			g.ellipse(x + width / 2, y + height / 2, width, height);
		}
	}

}