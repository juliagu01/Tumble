package gui;

import java.util.ArrayList;
import processing.core.PApplet;
import screens.*;

/**
 * Represents a canvas onto which a game is drawn. 
 * Credit to Mr. Shelby for basic class structure. 
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	private Screen[] screens;
	private Screen activeScreen;
	private ArrayList<Integer> keys;
	
	/**
	 * Creates a canvas that displays a game. 
	 */
	public DrawingSurface() {
		
		super();
		keys = new ArrayList<Integer>();
		
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
	}
	
	/**
	 * Returns the actual x-coordinate that corresponds to the transformed x-coordinate.
	 * @param assumed - x-coordinate in transformed coordinates
	 * @return the x-coordinate in actual coordinates
	 */
	public float getActualCoordinateX(float assumedX) {
		return assumedX * width/Screen.WIDTH;
	}
	
	/**
	 * Returns the actual y-coordinate that corresponds to the transformed y-coordinate.
	 * @param assumed - y-coordinate in transformed coordinates
	 * @return the y-coordinate in actual coordinates
	 */
	public float getActualCoordinateY(float assumedY) {
		return assumedY * height/Screen.HEIGHT;
	}
	
	/**
	 * Returns the transformed x-coordinate that corresponds to the actual x-coordinate.
	 * @param assumed - x-coordinate in actual coordinates
	 * @return the x-coordinate in transformed coordinates
	 */
	public float getTransformedCoordinateX(float actualX) {
		return actualX * Screen.WIDTH/width;
	}
	
	/**
	 * Returns the actual y-coordinate that corresponds to the transformed y-coordinate.
	 * @param assumed - y-coordinate in transformed coordinates
	 * @return the y-coordinate in actual coordinates
	 */
	public float getTransformedCoordinateY(float actualY) {
		return actualY * Screen.HEIGHT/height;
	}

	/**
	 * Switches the screen that this drawing surface displays.
	 * @param newScreen - screen to be switched to
	 */
	public void switchScreen(int screen) {
		activeScreen = screens[screen];
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
		activeScreen.mouseReleased();
	}
	
}