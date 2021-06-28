package tumble.gui;

import tumble.gui.screens.*;

/**
 * Represents a mechanism that manages screens.
 * @author Amanda Xu, Julia Gu
 * @version Jun. 27, 2021
 */
public class ScreenManager {
	
	/**
	 * Screen constants.
	 */
	public static final int START_SCREEN = 0, GAME_SCREEN = 1, PAUSE_SCREEN = 2;

	private Screen[] screens;
	private Screen activeScreen, toScreen;
	
	/**
	 * Creates a program that displays a game. 
	 */
	public ScreenManager(DrawingSurface surface) {
		screens = new Screen[] {new StartScreen(surface), new GameScreen(surface), new PauseScreen(surface)};
		activeScreen = screens[START_SCREEN];
	}
	
	/**
	 * Transitions between screens accordingly.
	 */
	public void update() {
		if (activeScreen != toScreen && activeScreen.isFadedOut()) {
			if (toScreen != null)
				activeScreen = toScreen;
			activeScreen.fadeIn();
		}
	}
	
	/**
	 * Resets game screen.
	 */
	public void resetGameScreen(DrawingSurface surface) {
		screens[GAME_SCREEN] = new GameScreen(surface);
	}

	/**
	 * Switches the screen that this program displays.
	 * @param screen  screen to be switched to
	 */
	public void switchScreen(int screen) {
		activeScreen.fadeOut();
		toScreen = screens[screen];
	}
	
	/**
	 * Returns the screen that this program is displaying.
	 * @return current screen
	 */
	public Screen getActiveScreen() {
		return activeScreen;
	}
	
	/**
	 * Returns the screen that this program will switch to.
	 * @return screen to be switched to
	 */
	public Screen getToScreen() {
		return toScreen;
	}
	
}