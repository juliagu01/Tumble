import java.awt.geom.Ellipse2D;

/**
 * Represents a circular button that can lead to other screens.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class Button extends Ellipse2D.Float {

	private int toScreen;
	
	/**
	 * Creates a circle that represents a button.
	 * @param x - x-coordinate of button's center
	 * @param y - y-coordinate of button's center
	 * @param w - button's width
	 */
	public Button(float x, float y, float w) {
		super(x - w/2, y - w/2, w, w);
		toScreen = -1;
	}
	
	/**
	 * Creates a circle that represents a button. Button can lead to other screens.
	 * @param x - x-coordinate of button's center
	 * @param y - y-coordinate of button's center
	 * @param w - button's width
	 * @param screen - screen that button leads to
	 */
	public Button(float x, float y, float w, int toScreen) {
		super(x - w/2, y - w/2, w, w);
		this.toScreen = toScreen;
	}
	
	/**
	 * Determines if mouse's intersects with this button.
	 * @param mouseX - mouse's x-coordinate
	 * @param mouseY - mouse's y-coordinate
	 * @return whether this button is pressed
	 */
	public boolean isPressed(float mouseX, float mouseY) {
		 return Math.pow(mouseX - x - width/2, 2) + Math.pow(mouseY - y - width/2, 2) <= Math.pow(width/2, 2);  // resizing will be a problem!
	}
	
	/**
	 * Returns the screen that this button leads to.
	 * @return screen that this button leads to on click
	 */
	public int getToScreen() {
		return toScreen;
	}
	
}