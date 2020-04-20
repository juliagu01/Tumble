import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
//import java.awt.geom.Ellipse2D;
import processing.core.PApplet;

 /**
  * Represents a moving ellipse with basic physics and collision detection.
  * @author 
  */
public class Sprite extends Rectangle2D.Double {
	
	private double vx, vy;
	private int color;
	
	/**
	 * Creates an ellipse that represents a sprite. Sprite has a rectangular hit-box.
	 * @param x  x-coordinate of sprite's upper-left corner
	 * @param y  y-coordinate of sprite's upper left corner
	 * @param w  sprite's width
	 * @param h  sprite's height
	 * @param c  sprite's color
	 */
	public Sprite(int x, int y, int w, int h, int c) {
		super(x, y, w, h);
		color = c;
		vx = 0;
		vy = 0;
	}
	
	/**
	 * Moves this sprite to given location.
	 * @param x - x-coordinate of sprite's upper-left corner after translation
	 * @param y - y-coordinate of sprite's upper-left corner after translation
	 */
	public void moveTo(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	/**
	 * Moves this sprite by given amount.
	 * @param x - x-component of sprite's shift
	 * @param y - y-component of sprite's shift
	 */
	public void moveBy(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Updates this sprite's coordinates according to its velocity.
	 */
	public void moveByVelocity() {
		super.x += vx;
		super.y += vy;
	}
	
	/**
	 * Assigns this sprite the given velocity.
	 * @param vx - new x-component of sprite's velocity
	 * @param vy - new y-component of sprite's velocity
	 */
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	/**
	 * Returns this sprite's horizontal velocity.
	 * @return  x-component of sprite's current velocity
	 */
	public double getVelocityX() {
		return vx;
	}
	
	/**
	 * Returns this sprite's vertical velocity.
	 * @return  y-component of sprite's current velocity
	 */
	public double getVelocityY() {
		return vy;
	}
	
	/**
	 * Changes this sprite's velocity by given amount.
	 * @param ax - x-component of sprite's acceleration
	 * @param ay - y-component of sprite's acceleration
	 */
	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}
	
	/**
	 * Checks for collision between this sprite and given rectangle.
	 * @param r - rectangle to check for collision against
	 * @return  array storing the amount of collision
	 */
	public double[] intersects(Rectangle r) {
		
		double[] amount = new double[] {0, 0};
		
		if (x + width > r.x && x < r.x + r.width && y + height > r.y && y < r.y + r.height) {
			if (y + height - vy <= r.y)
				amount[1] = y + height - r.y;
			else if (y - vy >= r.y + r.height)
				amount[1] = y - r.y - r.height;
			if (x + width - vx <= r.x)
				amount[0] = x + width - r.x;
			else if (x - vx >= r.x + r.width)
				amount[0] = x - r.x - r.width;
		}
		
		return amount;
		
	}
	
	/**
	 * Draws this sprite as an ellipse.
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(color);
		g.ellipse(0, 0, (float)width, (float)height);
//		g.ellipse((float)x, (float)y, (float)width, (float)height);
	}
	
}