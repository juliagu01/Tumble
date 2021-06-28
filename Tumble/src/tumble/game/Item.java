package tumble.game;

import java.awt.geom.Rectangle2D;
import processing.core.PApplet;
import tumble.gui.Message;

/**
 * Represents a collectible item with a rectangular hitbox.
 * @author Julia Gu
 * @version May 5, 2020
 */
public abstract class Item extends Rectangle2D.Float {
	
	/**
	 * Item constants.
	 */
	public static final int LEAF = 0, FEATHER = 1, STICK = 2, STRAW = 3, KITE = 4, ORB = 5;
	
	private Message message;
	
	/**
	 * Creates an item. Has a rectangular hitbox.
	 * @param x  x-coordinate of item's upper-left corner
	 * @param y  y-coordinate of item's upper-left corner
	 * @param w  item's width
	 * @param h  item's height
	 */
	public Item(float x, float y, float w, float h) {
		super(x, y, w, h);
	}

	/**
	 * Defines the message displayed after this item is collected. 
	 * @param message  message to be displayed
	 */
	protected void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * Returns this item's message. 
	 * @return this item's message 
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Draws this item.
	 * @param g  the surface to be drawn on 
	 */
	public abstract void draw(PApplet g);
	
}