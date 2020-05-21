package tumble.gui;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Represents the superclass of all screens.
 * Credit to ProcessingScreenSwitching from Demos Folder
 * @author Amanda Xu, Julia Gu
 * @version May 13, 2020
 */
public abstract class Screen {

	/**
	 * Screens' shared dimensions. 
	 */
	public static final float WIDTH = 800, HEIGHT = 600;
	private ArrayList<Button> buttons;
	private DrawingSurface surface;
	private Fade fade;
	
	/**
	 * Creates a general screen.
	 * @param surface  drawing surface onto which this screen is drawn
	 */
	public Screen(DrawingSurface surface) {
		buttons = new ArrayList<Button>();
		this.surface = surface;
		fade = new Fade(1, 0.2f);
	}

	/**
	 * Adds a button to this screen.
	 * @param b  button to be added
	 */
	public void addButton(Button b) {
		buttons.add(b);
	}
	
	/**
	 * Responds to mouse release. Will change screen accordingly.
	 */
	public void mouseReleased() {
		for (Button b : buttons)
			if (b.isHoveredOver(surface.getTransformedCoordinateX(surface.mouseX), surface.getTransformedCoordinateY(surface.mouseY)))
				b.mouseReleased(surface.getTransformedCoordinateX(surface.mouseX), surface.getTransformedCoordinateY(surface.mouseY), surface);
	}
	
	/**
	 * Updates this screen.
	 * @param keys  keys that are currently pressed
	 */
	public void update(boolean[] keys) {
		
		fade.update();
		
		for (Button b : buttons)
			if (b.isHoveredOver(surface.getTransformedCoordinateX(surface.mouseX), surface.getTransformedCoordinateY(surface.mouseY))) {
				surface.cursor(PApplet.HAND);
				return;
			}
		surface.cursor(PApplet.ARROW);
		
	}

	/**
	 * Draws this screen's buttons.
	 */
	public void drawButtons() {
		for (Button b : buttons)
			b.draw(surface);
	}

	/**
	 * Fades this screen in.
	 */
	public void fadeIn() {
		fade.fadeTo(0);
	}

	/**
	 * Fades this screen out to white.
	 */
	public void fadeOut() {
		fade.fadeTo(1);
	}

	/**
	 * Determines whether this screen has completely faded out.
	 * @return whether screen has completely faded out
	 */
	public boolean isFadedOut() {
		return fade.getOpacity() > 0.95;
	}

	/**
	 * Returns the drawing surface onto which this screen is drawn.
	 * @return this screen's drawing surface
	 */
	protected DrawingSurface getSurface() {
		return surface;
	}
	
	/**
	 * Draws this screen.
	 */
	public void draw() {
		fade.draw(surface, 0, 0, WIDTH, HEIGHT);
	}
	
}