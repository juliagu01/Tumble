package tumble.game;

import processing.core.PApplet;

/**
 * Represents a patch of vine.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Vine extends Platform {
	
	/**
	 * Creates a rectangle that represents a patch of vine. 
	 * @param x  x-coordinate of vine's upper-left corner
	 * @param y  y-coordinate of vine's upper-left corner
	 * @param w  vine's width
	 * @param h  vine's height
	 */
	public Vine(float x, float y, float w, float h) {
		super(x, y, w, h);
	}
	
	/**
	 * Draws this patch of vine.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		if (!hasColor())
			g.fill(100, 80, 110);
		else
			g.fill(154, 128, 191);

		g.rect(x - 0.5f, y - 0.5f, width + 1, height + 1);
		
	}

}