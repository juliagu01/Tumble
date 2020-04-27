import java.awt.geom.Rectangle2D;
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
	private boolean canJump;

	/**
	 * Creates an ellipse that represents a player. Player has a rectangular hit-box.
	 * @param x - x-coordinate of player's upper-left corner
	 * @param y - y-coordinate of player's upper-left corner
	 */
	public Player(int x, int y) {
		super(x, y, WIDTH, HEIGHT);
	}

	/**
	 * Accelerates this player horizontally.
	 * @param a - amount to accelerate by 
	 */
	public void roll(int a) {
		accelerate(a, 0);
	}

	/**
	 * Accelerates this player vertically.
	 */
	public void jump() {
		if (canJump) {
			accelerate(0, -16);
			canJump = false;
		}
	}

	/**
	 * Updates this player's location according to its velocity.
	 * @param platforms - list containing rectangles to check for collision against
	 */
	public void update(ArrayList<Rectangle2D.Float> platforms) {
		
		canJump = false;
		accelerate(-getVelocityX()/8, 0.8f);
		
		moveByVelocity();
		
		if (platforms != null) {
			for (Rectangle2D.Float p : platforms) {
				float[] amount = collidesBy(p);
				moveBy(-amount[0], -amount[1]);
				if (amount[0] != 0)
					setVelocity(0, getVelocityY());
				if (amount[1] != 0)
					setVelocity(getVelocityX(), 0);
				if (amount[1] > 0)
					canJump = true;
			}
		}
		
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