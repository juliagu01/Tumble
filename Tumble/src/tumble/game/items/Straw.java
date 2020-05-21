package tumble.game.items;

import processing.core.PApplet;
import tumble.game.Item;
import tumble.gui.Message;

/**
 * Represents a collectible straw item with a rectangular hitbox.
 * @author Julia Gu
 * @version May 5, 2020
 */
public class Straw extends Item {
	
	/**
	 * Creates a straw item. Has a rectangular hitbox.
	 * @param x  x-coordinate of straw's upper-left corner
	 * @param y  y-coordinate of straw's upper-left corner
	 * @param w  straw's width
	 */
	public Straw(float x, float y, float w) {
		super(x, y + w * 7/16, w, w/8);
		setMessage(new Message("There's an abandoned straw stuck in the bush. You feel bad for it, and you add it to your pocket. "
				+ "The straw thanks you. You have earned the ability to gain boosts.  [To use, press shift in air.]", -4718570));
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