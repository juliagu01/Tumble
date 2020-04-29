import java.awt.geom.Rectangle2D;

/**
 * Represents a movable rectangle. 
 * @author Julia Gu
 * @version Apr. 27, 2020
 */
public class MovableRectangle extends Rectangle2D.Float {
	
	public static final float EPSILON = 1e-9f;
	private float vx, vy;
	
	/**
	 * Creates a rectangle with given location and velocity.
	 * @param x - x-coordinate of rectangle's upper-left corner
	 * @param y - y-coordinate of rectangle's upper-left corner
	 * @param w - rectangle's width
	 * @param h - rectangle's height
	 * @param vx - x-component of rectangle's velocity
	 * @param vy - y-component of rectangle's velocity
	 */
	public MovableRectangle(float x, float y, float w, float h, float vx, float vy) {
		super(x, y, w, h);
		this.vx = vx;
		this.vy = vy;
	}
	
	/**
	 * Creates a rectangle with given location and default velocity.
	 * @param x - x-coordinate of rectangle's upper-left corner
	 * @param y - y-coordinate of rectangle's upper-left corner
	 * @param w - rectangle's width
	 * @param h - rectangle's height
	 */
	public MovableRectangle(float x, float y, float w, float h) {
		this(x, y, w, h, 0, 0);
	}

	/**
	 * Moves this rectangle to given location.
	 * @param x - x-coordinate of rectangle's upper-left corner after translation
	 * @param y - y-coordinate of rectangle's upper-left corner after translation
	 */
	public void moveTo(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Moves this rectangle by given amount.
	 * @param x - x-component of rectangle's shift
	 * @param y - y-component of rectangle's shift
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
	 * Assigns this rectangle the given velocity.
	 * @param vx - new x-component of rectangle's velocity
	 * @param vy - new y-component of rectangle's velocity
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
	 * @param ax - x-component of rectangle's acceleration
	 * @param ay - y-component of rectangle's acceleration
	 */
	public void accelerate(float ax, float ay) {
		vx += ax;
		vy += ay;
	}

	/**
	 * Checks for collision between this rectangle and given rectangle.
	 * @param r - rectangle to check for collision against
	 * @return whether rectangles overlap
	 */
	public boolean intersects(Rectangle2D.Float r) {
		return x + width > r.x && x < r.x + r.width && y + height > r.y && y < r.y + r.height;
	}
	
	/**
	 * Calculates amount of collision between this rectangle and given rectangle.
	 * @param r - rectangle to check for collision against
	 * @return array storing the amount of collision
	 */
	public float[] collidesBy(Rectangle2D.Float r) {
		
		float[] amount = new float[] {0, 0};
		
		if (intersects(r)) {
			if (y + height - vy <= r.y)
				amount[1] = y + height - r.y;
			else if (y - vy >= r.y + r.height)
				amount[1] = y - r.y - r.height;
			else if (x + width - vx <= r.x)
				amount[0] = x + width - r.x;
			else if (x - vx >= r.x + r.width)
				amount[0] = x - r.x - r.width;
		}
		
		return amount;
		
	}
	
}