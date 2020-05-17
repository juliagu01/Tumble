package tumble.gui;

import java.awt.geom.Ellipse2D;
import processing.core.PApplet;

/**
 * Represents a circular solid button that can lead to other screens.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public abstract class Button extends Ellipse2D.Float {

	/**
	 * Buttons' shared color constants.
	 */
	public static final int BASE_COLOR = -4476227, SYMBOL_COLOR = 240;
	
	/**
	 * Creates a solid circle that represents a button.
	 * @param x  x-coordinate of button's center
	 * @param y  y-coordinate of button's center
	 * @param w  button's width
	 */
	public Button(float x, float y, float w) {
		super(x - w/2, y - w/2, w, w);
	}
	
	/**
	 * Determines if mouse intersects with this button.
	 * @param mouseX  mouse's x-coordinate
	 * @param mouseY  mouse's y-coordinate
	 * @return whether this button is pressed
	 */
	public boolean isHoveredOver(float mouseX, float mouseY) {
		 return Math.pow(mouseX - x - width/2, 2) + Math.pow(mouseY - y - width/2, 2) <= Math.pow(width/2, 2);
	}
	
	/**
	 * Draws this button. 
	 * @param g  surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.ellipse(x + width/2, y + width/2, width, width);
	}
	
	/**
	 * Responds to mouse release.
	 * @param mouseX  mouse's current x-coordinate
	 * @param mouseY  mouse's current y-coordinate
	 * @param surface  surface to be changed
	 */
	public abstract void mouseReleased(float mouseX, float mouseY, DrawingSurface surface);
	
}