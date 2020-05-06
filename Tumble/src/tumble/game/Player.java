package tumble.game;

import java.util.ArrayList;
import processing.core.PApplet;
import tumble.items.*;

/**
 * Represents a movable ellipse with basic physics and rectangular collision detection.
 * @author Amanda Xu, Andra Liu, Julia Gu
 * @version May 5, 2020
 */
public class Player extends MovableRectangle {

	/**
	 * Players' shared dimensions. 
	 */
	public static final int WIDTH = 40, HEIGHT = 40;
	private ArrayList<Item> items;
	private boolean canJump;
	private boolean canGlide;
	private boolean powerUp;
	private Game game;

	/**
	 * Creates an ellipse that represents a player. Player has a rectangular hit-box.
	 * @param x  x-coordinate of player's upper-left corner
	 * @param y  y-coordinate of player's upper-left corner
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
		for (Item i : items) {
			if (i instanceof Leaf) {
				accelerate(-1.2f, 0);
				return;
			} else if (i instanceof Kite) {
				canGlide = true;
			} else if (i instanceof Stick) {

			} else if (i instanceof Straw) {
				
			} else {
				
			}
		}
		accelerate(-1, 0);
	}

	/**
	 * Accelerates this player to the right.
	 */
	public void rollRight() {
		for (Item i : items) {
			if (i instanceof Leaf) {
				accelerate(1.2f, 0);
				return;
			} else if (i instanceof Kite) {
				canGlide = true;
			} else if (i instanceof Stick) {

			} else if (i instanceof Straw) {
				
			} else {
				
			}
		}
		accelerate(1, 0);
	}

	/**
	 * Accelerates this player upwards.
	 */
	public void jump() {
		if (canJump) {
			canJump = false;
			for (Item i : items) {
				if (i instanceof Feather) {
					accelerate(0, -18);
					return;
				}
			}
			accelerate(0, -16);
		}
	}
	
	/**
	 * Player glides.
	 */
	public void glide() {
		
		if (canGlide) {	
				
			for (Item i : items) {
				if (i instanceof Feather) {
					accelerate(0, -18);
					return;
				}
			}
			
			moveBy(0, -18);
			setVelocity(getVelocityX(), 0);
		}
	}

	/**
	 * Updates this player's location according to its velocity.
	 * @param platforms  list containing rectangles to check for collision against
	 * @param items  list containing items to check for collision against
	 */
	public void update(ArrayList<Platform> platforms, ArrayList<Item> items) {

		canJump = false;
		accelerate(-getVelocityX()/8, 0.8f);
		
		moveByVelocity();
		
		if (platforms != null) {
			for (Platform p : platforms) {
				float[] amount = collidesBy(p);
				moveBy(-amount[0], -amount[1]);
				if (amount[1] != 0)
					setVelocity(getVelocityX(), 0);
				else if (amount[0] != 0)
					setVelocity(0, getVelocityY());
				if (amount[1] > 0)
					canJump = true;
			}
		}
		
		if (items != null) {
			powerUp = false;
			for (Item i : items) {
				if (this.intersects(i) && !this.items.contains(i)) {
					this.items.add(i);
					game.setMessage(i.getMessage());
					powerUp = true;
				}
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
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(253, 235, 0);
		if (powerUp) {
			// power up animation
		} else {
			g.ellipse(x + width/2, y + height/2, width, height);
		}
	}

}