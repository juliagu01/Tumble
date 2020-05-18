package tumble.gui.buttons;

import processing.core.PApplet;
import tumble.gui.Button;
import tumble.gui.DrawingSurface;

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
		g.strokeWeight(4);
		g.noFill();
		g.arc(x + width * 25/50, y + width * 25/50, width * 24/50, width * 24/50, -PApplet.PI * 95/180, PApplet.PI * 225/180);
		g.line(x + width * 25/50, y + width * 13/50, x + width * 36/50, y + width * 10/50);
		g.line(x + width * 25/50, y + width * 12/50, x + width * 31/50, y + width * 23/50);
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
		surface.switchScreen(DrawingSurface.GAME_SCREEN);
	}

}