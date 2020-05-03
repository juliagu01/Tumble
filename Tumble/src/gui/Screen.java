package gui;

import java.util.ArrayList;

/**
 * Represents the superclass of all screens.
 * Credit to ProcessingScreenSwitching from Demos Folder
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 */

public abstract class Screen {

	/**
	 * Screens' shared dimensions. 
	 */
	public static final float WIDTH = 800, HEIGHT = 600;
	private ArrayList<Button> buttons;
	private DrawingSurface surface;
	
	/**
	 * Creates a general screen.
	 * @param surface  drawing surface onto which this screen is drawn
	 */
	public Screen(DrawingSurface surface) {
		buttons = new ArrayList<Button>();
		this.surface = surface;
	}

	/**
	 * Adds a button to this screen.
	 * @param b  button to be added
	 */
	public void addButton(Button b) {
		buttons.add(b);
	}

	/**
	 * Returns the drawing surface onto which this screen is drawn.
	 * @return this screen's drawing surface
	 */
	public DrawingSurface getSurface() {
		return surface;
	}
	
	/**
	 * Responds to mouse release. Will change screen accordingly.
	 */
	public void mouseReleased() {
		for (Button b : buttons)
			if (b.isPressed(surface.getTransformedCoordinateX(surface.mouseX), surface.getTransformedCoordinateY(surface.mouseY)) && b.getToScreen() != -1)
				surface.switchScreen(b.getToScreen());
	}
	
	/**
	 * Updates this screen.
	 * @param keys  keys that are currently pressed
	 */
	public void update(ArrayList<Integer> keys) {}
	
	/**
	 * Draws this screen.
	 */
	public abstract void draw();
	
}