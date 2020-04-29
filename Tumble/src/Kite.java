
import processing.core.PApplet;

/**
 * Represents a collectible kite item with a rectangular hitbox.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Kite extends Item {
	
	/**
	 * Creates a kite item. Has a rectangular hitbox.
	 * @param x - x-coordinate of kite's upper-left corner
	 * @param y - y-coordinate of kite's upper-left corner
	 */
	public Kite(float x, float y) {
		super(x, y, 30, 40);
	}

	/**
	 * Draws this kite.
	 */
	public void draw(PApplet g) {
		g.fill(255, 159, 43);
		g.quad(x, y + height/2, x + width/2, y, x + width, y + height/2, x + width/2, y + height);
	}
	
}