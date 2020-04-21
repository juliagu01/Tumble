import java.awt.*;
import java.util.*;

public class Player extends Sprite {

	public static final int PLAYER_WIDTH = 40;
	public static final int PLAYER_TOP = 0, PLAYER_BOTTOM = 1, PLAYER_LEFT = 2, PLAYER_RIGHT = 3;
	private boolean canJump;

	/**
	 * Creates a sprite that represents a player. See superclass constructor for more information.
	 * @param x - x-coordinate of player's upper-left corner
	 * @param y - y-coordinate of player's upper-left corner
	 * @param c - player's color
	 */
	public Player(int x, int y, int c) {
		super(x, y, PLAYER_WIDTH, PLAYER_WIDTH, c);
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
	public void update(ArrayList<Rectangle> platforms) {
		
		canJump = false;
		accelerate(-getVelocityX()/8, 0.8);
		
		moveByVelocity();
		
		if (platforms != null) {
			for (Rectangle p : platforms) {
				double[] amount = intersectsBy(p);
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


}