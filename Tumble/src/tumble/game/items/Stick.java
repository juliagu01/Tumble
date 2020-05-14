package tumble.game.items;

import processing.core.PApplet;
import tumble.game.Item;
import tumble.gui.Message;

/**
 * Represents a collectible stick item with a rectangular hitbox.
 * @author Julia Gu
 * @version May 5, 2020
 */
public class Stick extends Item {
	
	/**
	 * Creates a stick item. Has a rectangular hitbox.
	 * @param x  x-coordinate of stick's upper-left corner
	 * @param y  y-coordinate of stick's upper-left corner
	 * @param w  stick's width
	 */
	public Stick(float x, float y, float w) {
		super(x + w * 7/16, y, w/8, w);
		setMessage(new Message("You stop at a tree. He's asking if you could take a piece of him to see the world. He offers you a twig. "
				+ "Oh, he almost forgot to tell you, however small it may seem, the twig can part vines.", -10420079));
	}

	/**
	 * Draws this stick.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(178, 104, 215);
		g.rect(x, y, width, height);
	}
	
}