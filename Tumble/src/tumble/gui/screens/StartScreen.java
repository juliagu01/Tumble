package tumble.gui.screens;

import tumble.gui.buttons.MuteButton;
import tumble.gui.buttons.PlayButton;
import tumble.gui.*;

/**
 * Represents the game's start screen. Has a play button.
 * @author Amanda Xu, Julia Gu
 * @version May 5, 2020
 */
public class StartScreen extends Screen {
	
	/**
	 * Creates a screen with the game's title and a play button.
	 * @param surface  drawing surface onto which this screen is drawn
	 */
	public StartScreen(DrawingSurface surface) {
		super(surface);
		super.addButton(new PlayButton(Screen.WIDTH/2, Screen.HEIGHT * 2/3, Screen.HEIGHT/5));
		addButton(new MuteButton(Screen.WIDTH * 510/800, Screen.HEIGHT * 430/600, Screen.HEIGHT * 50/600));
	}

	/**
	 * Draws this start screen.
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
		g.fill(253, 225, 0);
		g.ellipse(100, 300, 500, 500);
		
		// title
		g.fill(80);
		g.textSize(90);
		String title = "TUMBLE";
		float titleW = g.textWidth(title);
		g.text(title, 400 - titleW/2, 250);
		
		// subtitle
		g.textSize(24);
		String subtitle = "game by VanillaChip";
		float subtitleW = g.textWidth(subtitle);
		g.text("game by VanillaChip", 400 - subtitleW/2, 300);
		
		// play button
		drawButtons();
		
		// fade
		super.draw();
		
		g.popMatrix();
		
	}

}