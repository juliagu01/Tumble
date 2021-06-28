package tumble.gui.buttons;

import processing.core.PApplet;
import tumble.gui.Button;
import tumble.gui.DrawingSurface;
import tumble.gui.ScreenManager;

/**
 * Represents a button that restarts the game. 
 * @author Julia Gu
 * @version May 17, 2020
 */
public class RestartButton extends Button {
	
	/**
	 * Creates a button that can restart the game. 
	 * @param x  x-coordinate of button's center
	 * @param y  y-coordinate of button's center
	 * @param w  button's width
	 */
	public RestartButton(float x, float y, float w) {
		super(x, y, w);
	}
	
	/**
	 * Draws this restart button.
	 * @param g  surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		g.fill(BASE_COLOR);
		super.draw(g);
		
		g.stroke(SYMBOL_COLOR);
		g.strokeCap(PApplet.SQUARE);
		g.strokeWeight(3);
		g.noFill();
		g.arc(x + width * 25/50, y + width * 25/50, width * 22/50, width * 22/50, -PApplet.PI * 150/180, PApplet.PI * 150/180);
		g.line(x + width * 15/50, y + width * 20/50, x + width * 16/50, y + width * 11/50);
		g.line(x + width * 14/50, y + width * 20/50, x + width * 24/50, y + width * 19/50);
		g.noStroke();
		
	}

	/**
	 * Clears all progress in game.
	 * @param mouseX  mouse's current x-coordinate
	 * @param mouseY  mouse's current y-coordinate
	 * @param surface  surface to be changed
	 */
	public void mouseReleased(float mouseX, float mouseY, DrawingSurface surface) {
		surface.resetGameScreen();
		surface.switchScreen(ScreenManager.GAME_SCREEN);
	}

}