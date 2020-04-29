import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Represents a canvas onto which a game is drawn. 
 * Credit to Mr. Shelby for basic class structure! 
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 */
public class DrawingSurface extends PApplet {
	
	/**
	 * DrawingSurface's screen constants.
	 */
	public static final int START_SCREEN = 0, GAME_SCREEN = 1, PAUSE_SCREEN = 2;

	private int screen;
	private Screen[] screens;
	private ArrayList<Integer> keys;
	
	/**
	 * Creates a canvas that displays a game. 
	 */
	public DrawingSurface() {
		
		super();
		keys = new ArrayList<Integer>();
		
		screen = START_SCREEN;
		screens = new Screen[] {new StartScreen(), new GameScreen(), new PauseScreen()};
		
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
	}

	/**
	 * Draws the game.
	 */
	public void draw() {
		screens[screen].update(keys);
		screens[screen].draw(this);
	}

	/**
	 * Stores this key press.
	 */
	public void keyPressed() {
		keys.add(keyCode);
	}

	/**
	 * Stores this key release.
	 */
	public void keyReleased() {
		while (keys.contains(keyCode))
			keys.remove((Integer)keyCode);
	}
	
	/**
	 * Responds to mouse release.
	 */
	public void mouseReleased() {
		int newScreen = screens[screen].checkClick(mouseX, mouseY);
		if (newScreen != -1)
			screen = newScreen;
	}
	
}