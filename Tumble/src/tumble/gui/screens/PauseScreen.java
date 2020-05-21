package tumble.gui.screens;

import tumble.gui.buttons.*;
import tumble.gui.*;

/**
 * Represents the game's pause screen. Has a continue button.
 * @author Julia Gu
 * @version May 5, 2020
 */
public class PauseScreen extends Screen {
	
	/**
	 * Creates a screen with a continue button.
	 * @param surface  drawing surface onto which this screen is drawn
	 */
	public PauseScreen(DrawingSurface surface) {
		super(surface);
		addButton(new PlayButton(Screen.WIDTH/2, Screen.HEIGHT * 380/600, Screen.HEIGHT/5));
		addButton(new RestartButton(Screen.WIDTH * 290/800, Screen.HEIGHT * 410/600, Screen.HEIGHT * 50/600));
		addButton(new MuteButton(Screen.WIDTH * 510/800, Screen.HEIGHT * 410/600, Screen.HEIGHT * 50/600));
	}

	/**
	 * Draws this pause screen.
	 */
	public void draw() {
		
		DrawingSurface g = getSurface();
		g.background(222, 220, 224);
		
		g.pushMatrix();
		g.scale(g.width/800f, g.height/600f);
		
		// platform
		g.fill(152, 144, 154);
		g.rect(0, 550, 800, 50);
		
		// player
		g.fill(250, 230, 50);
		g.ellipse(100, 300, 500, 500);
		
		// text
		g.fill(80);
		g.textSize(72);
		String text = "PAUSED";
		float textW = g.textWidth(text);
		g.text(text, 400 - textW/2, 270);
		
		// play button
		drawButtons();
		
		// fade
		super.draw();
		
		g.popMatrix();
		
	}

}