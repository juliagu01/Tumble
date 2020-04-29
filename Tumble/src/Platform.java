import java.awt.geom.Rectangle2D;
import processing.core.PApplet;

/**
 * Represents a stationary platform.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Platform extends Rectangle2D.Float {
	
	/**
	 * Creates a rectangle that represents a platform. 
	 * @param x - x-coordinate of platform's upper-left corner
	 * @param y - y-coordinate of platform's upper-left corner
	 * @param w - platform's width
	 * @param h - platform's height
	 */
	public Platform(float x, float y, float w, float h) {
		super(x, y, w, h);
	}
	
	/**
	 * Draws this platform.
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(100);
		g.rect(x, y, width, height);
	}

}