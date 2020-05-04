package tumble.gui;

/**
 * Represents the mechanism for switching screens.
 * Credit to ProcessingScreenSwitching from Demos Folder.
 * @author Amanda Xu
 * @version 4/28/20
 */
public interface ScreenSwitcher {
	
	/**
	 * Screen constants.
	 */
	public static final int START_SCREEN = 0, GAME_SCREEN = 1, PAUSE_SCREEN = 2;
	
	/**
	 * Changes active screen to given screen. 
	 * @param s  screen to be switched to
	 */
	public void switchScreen(int s);
	
}