package tumble.items;

import processing.core.PApplet;
import tumble.game.Item;
import tumble.gui.Message;

/**
 * Represents a collectible orb item with a rectangular hitbox.
 * @author Julia Gu
 * @version May 7, 2020
 */
public class Orb extends Item {
	
	/**
	 * Creates an orb item. Has a rectangular hitbox.
	 * @param x  x-coordinate of orb's upper-left corner
	 * @param y  y-coordinate of orb's upper-left corner
	 */
	public Orb(float x, float y) {
		super(x, y, 30, 30);
		setMessage(new Message("You approach an orb. It glows brighter and brighter...", -6250336));
	}

	/**
	 * Draws this orb.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(255, 255, 245);
		g.ellipse(x + width/2, y + width/2, width, width);
	}
	
}