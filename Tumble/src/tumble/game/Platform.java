package tumble.game;

import java.awt.geom.Rectangle2D;
import processing.core.PApplet;

/**
 * Represents a stationary platform.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Platform extends Rectangle2D.Float {
	
	private boolean hasColor;
	
	/**
	 * Creates a rectangle that represents a platform. 
	 * @param x  x-coordinate of platform's upper-left corner
	 * @param y  y-coordinate of platform's upper-left corner
	 * @param w  platform's width
	 * @param h  platform's height
	 */
	public Platform(float x, float y, float w, float h) {
		super(x, y, w, h);
		hasColor = false;
	}
	
	/**
	 * Adds color to this platform.
	 */
	public void addColor() {
		hasColor = true;
	}
	
	/**
	 * Draws this platform.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		if (!hasColor)
			g.fill(130, 115, 132);
		else
			g.fill(124, 204, 104);

		g.rect(x - 0.5f, y - 0.5f, width + 1, height + 1);
		
	}
	
	/**
	 * Returns this platform's color state.
	 * @return whether platform has color
	 */
	protected boolean hasColor() {
		return hasColor;
	}

}