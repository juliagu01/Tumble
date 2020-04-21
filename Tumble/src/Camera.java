import java.awt.geom.Rectangle2D;

/**
 * Represents the area of the map shown to players at a given moment.
 * @author Julia Gu
 * @version Apr. 20, 2020
 */
public class Camera extends MovableRectangle {
	
	private Rectangle2D.Double box;
	private double tx, ty;

	/**
	 * Creates a rectangle that represents the area of the map shown to players. 
	 * Creates a smaller rectangle that represents the area of the camera that 
	 * focus should not move past.
	 * @param x  x-coordinate of camera's center
	 * @param y  y-coordinate of camera's center
	 * @param w  camera's width
	 * @param h  camera's height
	 */
	public Camera(double x, double y, double w, double h) {
		super(x - w/2, y - h/2, w, h);
		box = new Rectangle2D.Double(x - w/4, y - h/4, w/2, h/2);
		tx = this.x;
		ty = this.y;
	}
	
	/**
	 * Sets location that camera moves towards.
	 * @param x - x-coordinate of camera's center after sliding
	 * @param y - y-coordinate of camera's center after sliding
	 */
	public void setTargetLocation(double x, double y) {
		tx = x - width/2;
		ty = y - height/2;
	}
	
	/**
	 * Moves this camera smoothly to target location.
	 * @param x - x-coordinate of camera's center after sliding
	 * @param y - y-coordinate of camera's center after sliding
	 */
	public void slide() {
		setVelocity((tx - x) / 20, (ty - y) / 20);  // comment ? (tres francais)
		moveByVelocity();
	}
	
	/**
	 * Returns rectangular area that focus should not move past.
	 * @return area that focus should stay in
	 */
	public Rectangle2D.Double getBox() {
		box.x = x + width/2 - box.width/2;
		box.y = y + height/2 - box.height/2;
		return box;
	}
	
//	public double gettx() {
//		return tx;
//	}
//	public double getty() {
//		return ty;
//	}

}