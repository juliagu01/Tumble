package tumble.game;

/**
 * Represents the area of the map shown to players at a given moment.
 * @author Julia Gu
 * @version Apr. 27, 2020
 */
public class Camera extends MovableRectangle {
	
	private float tx, ty;

	/**
	 * Creates a rectangle that represents the area of the map shown to players. 
	 * @param x  x-coordinate of camera's center
	 * @param y  y-coordinate of camera's center
	 * @param w  camera's width
	 * @param h  camera's height
	 */
	public Camera(float x, float y, float w, float h) {
		super(x - w/2, y - h/2, w, h);
		tx = this.x;
		ty = this.y;
	}
	
	/**
	 * Sets location that camera moves towards.
	 * @param x  x-coordinate of camera's center after sliding
	 * @param y  y-coordinate of camera's center after sliding
	 */
	public void setTargetLocation(float x, float y) {
		tx = x - width/2;
		ty = y - height/2;
	}
	
	/**
	 * Moves this camera smoothly to target location.
	 */
	public void slide() {
		setVelocity((tx - x) / 20, (ty - y) / 20);
		moveByVelocity();
	}

}