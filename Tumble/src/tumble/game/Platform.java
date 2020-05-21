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
		
		if (!hasColor) {
			g.fill(160, 148, 162);
			g.stroke(160, 148, 162);
		} else {
			g.fill(154, 224, 103);
			g.stroke(154, 224, 103);
		}
		
		g.strokeWeight(0.5f);
		g.rect(x, y, width, height);
		g.noStroke();
		
	}
	
	/**
	 * Returns this platform's color state.
	 * @return whether platform has color
	 */
	protected boolean hasColor() {
		return hasColor;
	}

}