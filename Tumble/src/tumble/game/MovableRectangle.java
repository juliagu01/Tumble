package tumble.game;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Represents a movable rectangle. 
 * @author Julia Gu, Andra Liu
 * @version Apr. 27, 2020
 */
public class MovableRectangle extends Rectangle2D.Float {
	
	private float vx, vy;
	private Line2D.Float topLeft, top, topRight, right, bottomRight, bottom, bottomLeft, left;
	private static final float EPSILON = 5e-4f;
	
	/**
	 * Creates a rectangle with given location and velocity.
	 * @param x  x-coordinate of rectangle's upper-left corner
	 * @param y  y-coordinate of rectangle's upper-left corner
	 * @param w  rectangle's width
	 * @param h  rectangle's height
	 * @param vx  x-component of rectangle's velocity
	 * @param vy  y-component of rectangle's velocity
	 */
	public MovableRectangle(float x, float y, float w, float h, float vx, float vy) {
		super(x, y, w, h);
		this.vx = vx;
		this.vy = vy;
		topLeft = new Line2D.Float(x - vx, y - vy, x, y);
		top = new Line2D.Float(x + width/2 - vx, y - vy, x + width/2, y);
		topRight = new Line2D.Float(x + width - vx, y - vy, x + width, y);
		right = new Line2D.Float(x + width - vx, y + height/2 - vy, x + width, y + height/2);
		bottomRight = new Line2D.Float(x + width - vx, y + height - vy, x + width, y + height);
		bottom = new Line2D.Float(x + width/2 - vx, y + height - vy, x + width/2, y + height);
		bottomLeft = new Line2D.Float(x - vx, y + height - vy, x, y + height);
		left = new Line2D.Float(x - vx, y + height/2 - vy, x, y + height/2);
	}
	
	/**
	 * Creates a rectangle with given location and default velocity.
	 * @param x  x-coordinate of rectangle's upper-left corner
	 * @param y  y-coordinate of rectangle's upper-left corner
	 * @param w  rectangle's width
	 * @param h  rectangle's height
	 */
	public MovableRectangle(float x, float y, float w, float h) {
		this(x, y, w, h, 0, 0);
	}
	
	/**
	 * Moves this rectangle by given amount.
	 * @param x  x-component of rectangle's shift
	 * @param y  y-component of rectangle's shift
	 */
	public void moveBy(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	/**
	 * Updates this rectangle's coordinates according to its velocity.
	 */
	public void moveByVelocity() {
		this.x += vx;
		this.y += vy;
	}
	
	/**
	 * Sets the x value of the rectangle with the given value.
	 * @param x  x-coordinate to set to
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Sets the y value of the rectangle with the given value.
	 * @param y  y-coordinate to set to
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Assigns this rectangle the given velocity.
	 * @param vx  new x-component of rectangle's velocity
	 * @param vy  new y-component of rectangle's velocity
	 */
	public void setVelocity(float vx, float vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	/**
	 * Returns this rectangle's horizontal velocity.
	 * @return x-component of rectangle's current velocity
	 */
	public float getVelocityX() {
		return vx;
	}
	
	/**
	 * Returns this rectangle's vertical velocity.
	 * @return y-component of rectangle's current velocity
	 */
	public float getVelocityY() {
		return vy;
	}
	
	/**
	 * Changes this rectangle's velocity by given amount.
	 * @param ax  x-component of rectangle's acceleration
	 * @param ay  y-component of rectangle's acceleration
	 */
	public void accelerate(float ax, float ay) {
		vx += ax;
		vy += ay;
	}

	/**
	 * Checks for overlap between this rectangle and given rectangle.
	 * @param r  rectangle to check for overlap against
	 * @return whether rectangles overlap
	 */
	public boolean intersects(Rectangle2D.Float r) {
		return x + width >= r.x && x <= r.x + r.width && y + height >= r.y && y <= r.y + r.height;
	}
	
	/**
	 * Calculates amount of collision between this rectangle and given rectangle.
	 * @param r  rectangle to check for collision against
	 * @return array storing the amount of collision
	 */
	public Point2D.Float collidesBy(Rectangle2D.Float r) {
		
		Point2D.Float amount = new Point2D.Float(0, 0);
		
		if (collidesWith(r)) {
			if (y + height - vy <= r.y + EPSILON)			// platform's top side
				amount.y = y + height - r.y;
			else if (x + width - vx <= r.x + EPSILON)		// platform's left side
				amount.x = x + width - r.x;
			else if (x - vx >= r.x + r.width - EPSILON)		// platform's right side
				amount.x = x - r.x - r.width;
			else if (y - vy >= r.y + r.height - EPSILON)	// platform's bottom side
				amount.y = y - r.y - r.height;
		}
		
		return amount;
		
	}
	
	/**
	 * Checks for collision between this rectangle and given rectangle.
	 * @param r  rectangle to check for collision against
	 * @return whether rectangles collide
	 */
	public boolean collidesWith(Rectangle2D.Float r) {
		
		topLeft.setLine(x - vx, y - vy, x, y);
		top.setLine(x + width/2 - vx, y - vy, x + width/2, y);
		topRight.setLine(x + width - vx, y - vy, x + width, y);
		right.setLine(x + width - vx, y + height/2 - vy, x + width, y + height/2);
		bottomRight.setLine(x + width - vx, y + height - vy, x + width, y + height);
		bottom.setLine(x + width/2 - vx, y + height - vy, x + width/2, y + height);
		bottomLeft.setLine(x - vx, y + height - vy, x, y + height);
		left.setLine(x - vx, y + height/2 - vy, x, y + height/2);
		Rectangle2D.Float box = new Rectangle2D.Float(r.x + EPSILON, r.y + EPSILON, r.width - 2*EPSILON, r.height - 2*EPSILON);
		
		return topLeft.intersects(box) || top.intersects(box) || topRight.intersects(box) || right.intersects(box) 
				|| bottomRight.intersects(box) || bottom.intersects(box) || bottomLeft.intersects(box) || left.intersects(box);
		
	}
	
}