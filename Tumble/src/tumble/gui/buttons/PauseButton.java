package tumble.gui.buttons;

import processing.core.PApplet;
import tumble.gui.Button;
import tumble.gui.DrawingSurface;
import tumble.gui.ScreenSwitcher;

/**
 * Represents a pause button that leads to the game's pause screen. 
 * @author Julia Gu
 * @version May 13, 2020
 */
public class PauseButton extends Button {
	
	/**
	 * Creates a button that leads to pause screen. 
	 * @param x  x-coordinate of button's center
	 * @param y  y-coordinate of button's center
	 * @param w  button's width
	 */
	public PauseButton(float x, float y, float w) {
		super(x, y, w);
	}
	
	/**
	 * Draws this pause button.
	 * @param g  surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		g.fill(BASE_COLOR);
		super.draw(g);
		
		g.fill(SYMBOL_COLOR);
		g.rect(x + width * 16/50, y + width * 13/50, width * 5/50, width * 24/50);
		g.rect(x + width * 29/50, y + width * 13/50, width * 5/50, width * 24/50);
		
	}

	/**
	 * Switches screen to pause screen.
	 * @param mouseX  mouse's current x-coordinate
	 * @param mouseY  mouse's current y-coordinate
	 * @param surface  surface to be changed
	 */
	public void mouseReleased(float mouseX, float mouseY, DrawingSurface surface) {
		surface.switchScreen(ScreenSwitcher.PAUSE_SCREEN);
	}

}