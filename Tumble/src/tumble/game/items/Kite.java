package tumble.game.items;

import processing.core.PApplet;
import tumble.game.Item;
import tumble.gui.Message;

/**
 * Represents a collectible kite item with a rectangular hitbox.
 * @author Julia Gu
 * @version May 5, 2020
 */
public class Kite extends Item {
	
	/**
	 * Creates a kite item. Has a rectangular hitbox.
	 * @param x  x-coordinate of kite's upper-left corner
	 * @param y  y-coordinate of kite's upper-left corner
	 * @param w  kite's width
	 */
	public Kite(float x, float y, float w) {
		super(x, y - w/8, w, w * 5/4);
		setMessage(new Message("You notice something sitting alone on the bench. It's a kite. You sit next to it. It tells you that it misses seeing color in the world. You do too. "
				+ "The kite tells you that it wants to help you finish your quest. It offers to help you glide in air. You accept.  [To use, hold up arrow in air.]", -2060800));
	}

	/**
	 * Draws this kite.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(250, 174, 42);
		g.quad(x, y + height/2, x + width/2, y, x + width, y + height/2, x + width/2, y + height);
	}
	
}