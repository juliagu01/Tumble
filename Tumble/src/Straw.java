
import processing.core.PApplet;

/**
 * Represents a collectible straw item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Straw extends Item {
	
	/**
	 * Creates a straw item. Has a rectangular hitbox.
	 * @param x - x-coordinate of straw's upper-left corner
	 * @param y - y-coordinate of straw's upper-left corner
	 */
	public Straw(float x, float y) {
		super(x, y, 40, 5);
	}

	/**
	 * Draws this straw.
	 */
	public void draw(PApplet g) {
		g.fill(245, 98, 112);
		g.rect(x, y, width, height);
	}
	
}