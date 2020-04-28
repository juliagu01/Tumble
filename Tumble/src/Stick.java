
import processing.core.PApplet;

/**
 * Represents a collectible stick item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Stick extends Item {
	
	/**
	 * Creates a stick item. Has a rectangular hitbox.
	 * @param x - x-coordinate of stick's upper-left corner
	 * @param y - y-coordinate of stick's upper-left corner
	 */
	public Stick(float x, float y) {
		super(x, y, 5, 40);
	}

	/**
	 * Draws this stick.
	 */
	public void draw(PApplet g) {
		g.fill(206, 145, 255);
		g.rect(x, y, width, height);
	}
	
}