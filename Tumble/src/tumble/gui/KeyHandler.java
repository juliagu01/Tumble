package tumble.gui;

/**
 * Represents the mechanism for handling key-events.
 * 
 * @author Julia Gu
 * @version May 7, 2020
 */
public interface KeyHandler {

	/**
	 * Key constants.
	 */
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, A = 4, SPACE = 5, ENTER = 6;

	/**
	 * Reacts to this key press.
	 */
	public abstract void keyPressed();
	
	/**
	 * Reacts to this key release.
	 */
	public abstract void keyReleased();
	
}