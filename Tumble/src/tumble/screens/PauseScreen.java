package tumble.screens;

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
		super.addButton(new Button(Screen.WIDTH/2, Screen.HEIGHT * 380/600, Screen.HEIGHT/5, DrawingSurface.GAME_SCREEN));
	}

	/**
	 * Draws this pause screen.
	 */
	public void draw() {
		
		DrawingSurface g = getSurface();
		g.background(212);
		
		g.pushMatrix();
		g.scale(g.width/800f, g.height/600f);
		
		// platform
		g.fill(140);
		g.rect(0, 550, 800, 50);
		
		// player
		g.fill(250, 230, 50);
		g.ellipse(100, 300, 500, 500);
		
		// text
		g.fill(50);
		g.textSize(72);
		String text = "PAUSED";
		float textW = g.textWidth(text);
		g.text(text, 400 - textW/2, 270);
		
		// play button
		g.fill(190);
		g.ellipse(400, 380, 120, 120);
		g.fill(240);
		g.triangle(383, 350, 383, 410, 430, 380);
		
		g.popMatrix();
		
	}

}