package gui;
/**
 * Represents the mechanism for switching screens
 * Credit to ProcessingScreenSwitching from Demos Folder
 * @author Amanda Xu
 * @version 4/28/20
 */
public interface ScreenSwitcher {
	
	public static final int START_SCREEN = 0;
	public static final int GAME_SCREEN = 1;
	public static final int PAUSE_SCREEN = 2;
	
	public void switchScreen(int i);
	
}