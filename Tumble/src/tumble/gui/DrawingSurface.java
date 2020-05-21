package tumble.gui;

import java.awt.event.KeyEvent;

import tumble.gui.screens.*;
import processing.core.PApplet;

/**
 * Represents a canvas onto which a game is drawn. 
 * Credit to Mr. Shelby for basic class structure. 
 * @author Amanda Xu, Andra Liu, Julia Gu
 * @version May 5, 2020
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher, KeyHandler {
	
	private Screen[] screens;
	private Screen activeScreen, toScreen;
	private boolean[] keys;
	private final Sound sound = new Sound("jump.wav");
	
	/**
	 * Creates a canvas that displays a game. 
	 */
	public DrawingSurface() {
		
		super();
		keys = new boolean[6];
		
		screens = new Screen[] {new StartScreen(this), new GameScreen(this), new PauseScreen(this)};
		activeScreen = screens[0];
		
	}

	/**
	 * Sets the size of the drawing surface.
	 */
	public void settings() {
		size((int)Screen.WIDTH, (int)Screen.HEIGHT);
	}

	/**
	 * Sets up the drawing surface.
	 */
	public void setup() {
		noStroke();
		surface.setResizable(true);
	}

	/**
	 * Draws the game.
	 */
	public void draw() {
		activeScreen.update(keys);
		activeScreen.draw();
		if (activeScreen != toScreen && activeScreen.isFadedOut()) {
			if (toScreen != null)
				activeScreen = toScreen;
			activeScreen.fadeIn();
		}
	}
	
	/**
	 * Returns the transformed x-coordinate that corresponds to the actual x-coordinate.
	 * @param actualX  x-coordinate in actual coordinates
	 * @return the x-coordinate in transformed coordinates
	 */
	public float getTransformedCoordinateX(float actualX) {
		return actualX * Screen.WIDTH/width;
	}
	
	/**
	 * Returns the actual y-coordinate that corresponds to the transformed y-coordinate.
	 * @param actualY  y-coordinate in transformed coordinates
	 * @return the y-coordinate in actual coordinates
	 */
	public float getTransformedCoordinateY(float actualY) {
		return actualY * Screen.HEIGHT/height;
	}

	/**
	 * Switches the screen that this drawing surface displays.
	 * @param screen  screen to be switched to
	 */
	public void switchScreen(int screen) {
		activeScreen.fadeOut();
		toScreen = screens[screen];
	}
	
	/**
	 * Resets game screen.
	 */
	public void resetGameScreen() {
		screens[GAME_SCREEN] = new GameScreen(this);
	}
	
	/**
	 * Responds to mouse release.
	 */
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}

	/**
	 * Stores this key press.
	 */
	public void keyPressed() {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				keys[KeyHandler.UP] = true;
				sound.play();
				break;
			case KeyEvent.VK_DOWN:
				keys[KeyHandler.DOWN] = true;
				break;
			case KeyEvent.VK_LEFT:
				keys[KeyHandler.LEFT] = true;
				break;
			case KeyEvent.VK_RIGHT:
				keys[KeyHandler.RIGHT] = true;
				break;
			case KeyEvent.VK_SPACE:
				keys[KeyHandler.SPACE] = true;
				break;
			case KeyEvent.VK_SHIFT:
				keys[KeyHandler.SHIFT] = true;
				break;
		}
	}

	/**
	 * Stores this key release.
	 */
	public void keyReleased() {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				keys[KeyHandler.UP] = false;
				break;
			case KeyEvent.VK_DOWN:
				keys[KeyHandler.DOWN] = false;
				break;
			case KeyEvent.VK_LEFT:
				keys[KeyHandler.LEFT] = false;
				break;
			case KeyEvent.VK_RIGHT:
				keys[KeyHandler.RIGHT] = false;
				break;
			case KeyEvent.VK_SPACE:
				keys[KeyHandler.SPACE] = false;
				break;
			case KeyEvent.VK_SHIFT:
				keys[KeyHandler.SHIFT] = false;
				break;
		}

	}
	
}