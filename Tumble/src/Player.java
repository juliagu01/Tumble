import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Represents a movable ellipse with basic physics and rectangular collision detection.
 * @author Amanda Xu, Andra Liu, Julia Gu
 * @version Apr. 27, 2020
 */
public class Player extends MovableRectangle {

	/**
	 * Players' shared dimensions. 
	 */
	public static final int WIDTH = 40, HEIGHT = 40;
	private static final int COLOR = -4096;
	private ArrayList<Item> items;
	private boolean canJump;

	/**
	 * Creates an ellipse that represents a player. Player has a rectangular hit-box.
	 * @param x - x-coordinate of player's upper-left corner
	 * @param y - y-coordinate of player's upper-left corner
	 */
	public Player(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		items = new ArrayList<Item>();
	}

	/**
	 * Accelerates this player horizontally.
	 * @param a - amount to accelerate by 
	 */
	public void roll(float a) {
		accelerate(a, 0);
	}

	/**
	 * Accelerates this player vertically.
	 */
	public void jump(float a) {
		if (canJump) {
			accelerate(0, -a);
			canJump = false;
		}
	}

	/**
	 * Updates this player's location according to its velocity.
	 * @param platforms - list containing rectangles to check for collision against
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
		
		if (items != null)
			for (Item i : items)
				if (this.intersects(i))
					this.items.add(i);
		
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
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(COLOR);
		g.ellipse(x + width/2, y + height/2, width, height);
	}

}