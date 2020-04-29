
import processing.core.PApplet;

/**
 * Represents a collectible leaf item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Leaf extends Item {

	/**
	 * Creates a leaf item. Has a rectangular hitbox.
	 * @param x - x-coordinate of leaf's upper-left corner
	 * @param y - y-coordinate of leaf's upper-left corner
	 */
	public Leaf(float x, float y) {
		super(x, y, 30, 30);
	}

	/**
	 * Draws this leaf.
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(117, 224, 105);
		g.ellipse(x + width/2, y + width/2, width, width);
		g.rect(x, y + width/2, width/2, width/2);
		g.rect(x + width/2, y, width/2, width/2);
	}
	
}