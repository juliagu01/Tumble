import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Represents the superclass of all screens.
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 * Credit to ProcessingScreenSwitching from Demos Folder
 */

public abstract class Screen {

	/**
	 * Screens' shared dimensions. 
	 */
	public static final float WIDTH = 800, HEIGHT = 600;
	private ArrayList<Button> buttons;
	
	/**
	 * Creates a general screen.
	 */
	public Screen() {
		buttons = new ArrayList<Button>();
	}

	/**
	 * Adds a button to this screen.
	 * @param b - button to be added
	 */
	public void addButton(Button b) {
		buttons.add(b);
	}
	
	/**
	 * Determines if a button is clicked. 
	 * @param x - mouse's x-coordinate
	 * @param y - mouse's y-coordinate
	 * @return next screen. Returns -1 if not applicable.
	 */
	public int checkClick(float x, float y) {
		for (Button b : buttons)
			if (b.isPressed(x, y))
				return b.getToScreen();
		return -1;
	}
	
	/**
	 * Updates this screen.
	 * @param keys - keys being pressed
	 */
	public void update(ArrayList<Integer> keys) {}
	
	/**
	 * Draws this screen.
	 * @param g - the surface to be drawn on
	 */
	public abstract void draw(PApplet g);
	
}
