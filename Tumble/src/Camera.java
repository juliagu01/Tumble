import java.awt.geom.Rectangle2D;

/**
 * Represents the area of the map shown to players at a given moment.
 * @author Julia Gu
 * @version Apr. 20, 2020
 */
public class Camera extends Rectangle2D.Double {

	/**
	 * Creates a rectangle that represents the area of the map shown to players.
	 * @param x  x-coordinate of camera's center
	 * @param y  y-coordinate of camera's center
	 * @param w  sprite's width
	 * @param h  sprite's height
	 */
	public Camera(double x, double y, double w, double h) {
		super(x - w/2, y - h/2, w, h);
	}
	
	/**
	 * Moves this camera to given location.
	 * @param x - x-coordinate of camera's center after translation
	 * @param y - y-coordinate of camera's center after translation
	 */
	public void moveTo(double x, double y) {
		super.x = x;
		super.y = y;
	}

}