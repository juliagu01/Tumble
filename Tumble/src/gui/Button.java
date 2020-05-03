package gui;

import java.awt.geom.Ellipse2D;

import processing.core.PApplet;

/**
 * Represents a circular solid button that can lead to other screens.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Button extends Ellipse2D.Float {

	private int toScreen;
	
	/**
	 * Creates a solid circle that represents a button.
	 * @param x  x-coordinate of button's center
	 * @param y  y-coordinate of button's center
	 * @param w  button's width
	 */
	public Button(float x, float y, float w) {
		super(x - w/2, y - w/2, w, w);
		toScreen = -1;
	}
	
	/**
	 * Creates a solid circle that represents a button. Button can lead to other screens.
	 * @param x  x-coordinate of button's center
	 * @param y  y-coordinate of button's center
	 * @param w  button's width
	 * @param toScreen  screen that button leads to
	 */
	public Button(float x, float y, float w, int toScreen) {
		super(x - w/2, y - w/2, w, w);
		this.toScreen = toScreen;
	}
	
	/**
	 * Determines if mouse intersects with this button.
	 * @param mouseX  mouse's x-coordinate
	 * @param mouseY  mouse's y-coordinate
	 * @return whether this button is pressed
	 */
	public boolean isPressed(float mouseX, float mouseY) {
		 return Math.pow(mouseX - x - width/2, 2) + Math.pow(mouseY - y - width/2, 2) <= Math.pow(width/2, 2);  // resizing will be a problem!
	}
	
	/**
	 * Draws this button. 
	 * @param g  surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.ellipse(x + width/2, y + width/2, width, width);
	}
	
	/**
	 * Returns the screen that this button leads to.
	 * @return screen that this button leads to on click
	 */
	public int getToScreen() {
		return toScreen;
	}
	
}