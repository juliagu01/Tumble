package tumble.screens;

import tumble.game.Game;
import tumble.gui.*;

/**
 * Represents the game's main screen.
 * @author Amanda Xu, Julia Gu
 * @version May 5, 2020
 */
public class GameScreen extends Screen {
	
	private Game game;
	
	/**
	 * Creates a screen with a game. Has a pause button.
	 * @param surface  drawing surface onto which this screen is drawn
	 */
	public GameScreen(DrawingSurface surface) {
		super(surface);
		game = new Game();
		super.addButton(new Button(Screen.WIDTH - Screen.HEIGHT * 50/600, Screen.HEIGHT * 60/600, Screen.HEIGHT * 50/600, DrawingSurface.PAUSE_SCREEN));
	}
	
	/**
	 * Draw this game screen.
	 */
	public void draw() {
		
		DrawingSurface g = getSurface();
		g.background(212);
		
		// game
		game.draw(g);
		
		g.pushMatrix();
		g.scale(g.width/800f, g.height/600f);
		
		// message
		if (game.getMessage() != null)
			game.getMessage().draw(g);
		
		// pause button
		g.fill(190);
		g.ellipse(750, 60, 50, 50);
		g.fill(240);
		g.rect(741, 48, 5, 24);
		g.rect(754, 48, 5, 24);
		
		g.popMatrix();
		
	}
	
	/**
	 * Updates this game screen.
	 * @param keys  keys that are currently pressed
	 */
	public void update(boolean[] keys) {
		super.update(keys);
		game.update(keys);
	}

}