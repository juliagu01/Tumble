
import processing.core.PApplet;

/**
 * Represents a collectible item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public abstract class Item extends MovableRectangle {
	
	/**
	 * Creates an item. Has a rectangular hitbox.
	 * @param x - x-coordinate of item's upper-left corner
	 * @param y - y-coordinate of item's upper-left corner
	 */
	public Item(float x, float y, float w, float h) {
		super(x, y, w, h);
	}

	/**
	 * Draws this item. 
	 */
	public abstract void draw(PApplet g);
	
}