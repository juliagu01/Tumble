package tumble.gui.buttons;

import processing.core.PApplet;
import tumble.gui.Button;
import tumble.gui.DrawingSurface;
import tumble.gui.ScreenSwitcher;

/**
 * Represents a play button that leads to the game's game screen. 
 * @author Julia Gu
 * @version May 13, 2020
 */
public class PlayButton extends Button {
	
	/**
	 * Creates a button that leads to game screen. 
	 * @param x  x-coordinate of button's center
	 * @param y  y-coordinate of button's center
	 * @param w  button's width
	 */
	public PlayButton(float x, float y, float w) {
		super(x, y, w);
	}
	
	/**
	 * Draws this play button.
	 * @param g  surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		g.fill(BASE_COLOR);
		super.draw(g);
		
		g.fill(SYMBOL_COLOR);
		g.triangle(x + width * 43/120, y + width * 30/120, 
				x + width * 43/120, y + width * 90/120, 
				x + width * 90/120, y + width * 60/120);
		
	}

	/**
	 * Switches screen to game screen.
	 * @param mouseX  mouse's current x-coordinate
	 * @param mouseY  mouse's current y-coordinate
	 * @param surface  surface to be changed
	 */
	public void mouseReleased(float mouseX, float mouseY, DrawingSurface surface) {
		surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
	}

}