
import processing.core.PApplet;

/**
 * Represents a collectible feather item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Feather extends Item {
	
	/**
	 * Creates a feather item. Has a rectangular hitbox.
	 * @param x - x-coordinate of feather's upper-left corner
	 * @param y - y-coordinate of feather's upper-left corner
	 */
	public Feather(float x, float y) {
		super(x, y, 30, 30);
	}

	/**
	 * Draws this feather.
	 */
	public void draw(PApplet g) {
		g.fill(76, 191, 245);
		g.ellipse(x + width/2, y + width/2, width, width);
		g.rect(x, y, width/2, width/2);
		g.rect(x + width/2, y + width/2, width/2, width/2);
	}
	
}