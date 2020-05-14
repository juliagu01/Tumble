package tumble.game.items;

import processing.core.PApplet;
import tumble.game.Item;
import tumble.gui.Message;

/**
 * Represents a collectible feather item with a rectangular hitbox.
 * @author Julia Gu
 * @version May 5, 2020
 */
public class Feather extends Item {
	
	/**
	 * Creates a feather item. Has a rectangular hitbox.
	 * @param x  x-coordinate of feather's upper-left corner
	 * @param y  y-coordinate of feather's upper-left corner
	 * @param w  feather's width
	 */
	public Feather(float x, float y, float w) {
		super(x + w/8, y + w/8, w * 3/4, w * 3/4);
		setMessage(new Message("You notice a feather lying on the ground. It looks lonely. You add it to your pocket. "
				+ "You have gained the ability to reach greater heights.", -16744003));
	}

	/**
	 * Draws this feather.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(76, 195, 250);
		g.ellipse(x + width/2, y + width/2, width, width);
		g.rect(x, y, width/2, width/2);
		g.rect(x + width/2, y + width/2, width/2, width/2);
	}
	
}