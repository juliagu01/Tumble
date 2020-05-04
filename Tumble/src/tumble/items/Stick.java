package tumble.items;

import processing.core.PApplet;
import tumble.game.Item;

/**
 * Represents a collectible stick item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Stick extends Item {
	
	/**
	 * Creates a stick item. Has a rectangular hitbox.
	 * @param x  x-coordinate of stick's upper-left corner
	 * @param y  y-coordinate of stick's upper-left corner
	 */
	public Stick(float x, float y) {
		super(x, y, 5, 40);
	}

	/**
	 * Draws this stick.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(178, 104, 215);
		g.rect(x, y, width, height);
	}
	
}