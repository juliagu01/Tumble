package tumble.items;

import processing.core.PApplet;
import tumble.game.Item;
import tumble.gui.Message;

/**
 * Represents a collectible leaf item with a rectangular hitbox.
 * @author Julia Gu
 * @version May 5, 2020
 */
public class Leaf extends Item {

	/**
	 * Creates a leaf item. Has a rectangular hitbox.
	 * @param x  x-coordinate of leaf's upper-left corner
	 * @param y  y-coordinate of leaf's upper-left corner
	 */
	public Leaf(float x, float y) {
		super(x, y, 30, 30);
		setMessage(new Message("You found a fallen leaf. It’s asking you if it could stay in your pocket to avoid the cold. "
				+ "As thanks, it has given you the ability to roll.", -15755776));
	}

	/**
	 * Draws this leaf.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(117, 224, 105);
		g.ellipse(x + width/2, y + width/2, width, width);
		g.rect(x, y + width/2, width/2, width/2);
		g.rect(x + width/2, y, width/2, width/2);
	}
	
}