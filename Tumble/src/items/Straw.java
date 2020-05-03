package items;

import processing.core.PApplet;
import game.Item;

/**
 * Represents a collectible straw item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Straw extends Item {
	
	/**
	 * Creates a straw item. Has a rectangular hitbox.
	 * @param x  x-coordinate of straw's upper-left corner
	 * @param y  y-coordinate of straw's upper-left corner
	 */
	public Straw(float x, float y) {
		super(x, y, 40, 5);
	}

	/**
	 * Draws this straw.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(255, 90, 110);
		g.rect(x, y, width, height);
	}
	
}