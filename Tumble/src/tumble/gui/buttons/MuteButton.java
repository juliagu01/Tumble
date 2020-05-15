package tumble.gui.buttons;

import processing.core.PApplet;
import tumble.gui.Button;
import tumble.gui.DrawingSurface;
import tumble.gui.ScreenSwitcher;

/**
 * Represents a button that toggles the game's sound. 
 * @author Julia Gu
 * @version May 13, 2020
 */
public class MuteButton extends Button {
	
	/**
	 * Creates a button that can mute or unmute the game. 
	 * @param x  x-coordinate of button's center
	 * @param y  y-coordinate of button's center
	 * @param w  button's width
	 */
	public MuteButton(float x, float y, float w) {
		super(x, y, w);
	}
	
	/**
	 * Draws this mute button.
	 * @param g  surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		g.fill(BASE_COLOR);
		super.draw(g);
		
		g.fill(SYMBOL_COLOR);
		g.rect(x + width * 12/50, y + width * 19/50, width * 10/50, width * 12/50);
		g.triangle(x + width * 12/50, y + width * 25/50, 
				x + width * 28/50, y + width * 10/50, 
				x + width * 28/50, y + width * 40/50);
		
//		if game has sound {
			g.stroke(SYMBOL_COLOR);
			g.strokeWeight(3);
			g.noFill();
			g.arc(x + width * 28/50, y + width * 25/50, width * 20/50, width * 20/50, -PApplet.PI/4, PApplet.PI/4);
			g.arc(x + width * 28/50, y + width * 25/50, width * 10/50, width * 10/50, -PApplet.PI/4, PApplet.PI/4);
			g.noStroke();
//		} else {
//			g.stroke(SYMBOL_COLOR);
//			g.strokeWeight(3);
//			g.noFill();
//			g.line(x + width * 33/50, y + width * 22/50, x + width * 40/50, y + width * 28/50);
//			g.line(x + width * 33/50, y + width * 28/50, x + width * 40/50, y + width * 22/50);
//			g.noStroke();
//		}
		
	}

	/**
	 * Toggles this game's sound.
	 * @param mouseX  mouse's current x-coordinate
	 * @param mouseY  mouse's current y-coordinate
	 * @param surface  surface to be changed
	 */
	public void mouseReleased(float mouseX, float mouseY, DrawingSurface surface) {
//		toggle a sound boolean in another class
	}

}