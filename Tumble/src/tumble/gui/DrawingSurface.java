package tumble.gui;

import java.awt.event.KeyEvent;
import processing.core.PApplet;
//import processing.core.PImage;

/**
 * Represents a canvas onto which a game is drawn.
 * @author Amanda Xu, Andra Liu, Julia Gu
 * @version May 5, 2020
 */
public class DrawingSurface extends PApplet implements KeyHandler {
	
	private ScreenManager manager;
	private boolean[] keys;
	
//	private PImage[] p = new PImage[4];
//	private boolean isAnimating;
	
	/**
	 * Creates a canvas that displays a game.
	 */
	public DrawingSurface() {
		super();
		manager = new ScreenManager(this);
		keys = new boolean[5];
	}

	/**
	 * Sets the size of the drawing surface.
	 */
	public void settings() {
		size((int) Screen.WIDTH, (int) Screen.HEIGHT);
	}

	/**
	 * Sets up the drawing surface.
	 */
	public void setup() {
		noStroke();
//		p[0] = loadImage("media/images/frame_0.png");
//		p[1] = loadImage("media/images/frame_1.png");
//		p[2] = loadImage("media/images/frame_2.png");
//		p[3] = loadImage("media/images/frame_3.png");
		surface.setResizable(true);
	}

	/**
	 * Draws the game.
	 */
	public void draw() {
		
		Screen activeScreen = manager.getActiveScreen();
		activeScreen.update(keys);
		activeScreen.draw();
		manager.update();
		
//		if (isAnimating)
//			image(p[frameCount%4], Screen.WIDTH/2, Screen.HEIGHT/2);
		
	}
	
	/**
	 * Responds to mouse release.
	 */
	public void mouseReleased() {
		manager.getActiveScreen().mouseReleased();
	}

	/**
	 * Stores this key press.
	 */
	public void keyPressed() {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				keys[KeyHandler.UP] = true;
				break;
			case KeyEvent.VK_LEFT:
				keys[KeyHandler.LEFT] = true;
				break;
			case KeyEvent.VK_RIGHT:
				keys[KeyHandler.RIGHT] = true;
				break;
			case KeyEvent.VK_SHIFT:
				keys[KeyHandler.SHIFT] = true;
				break;
			case KeyEvent.VK_SPACE:
				keys[KeyHandler.SPACE] = true;
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
			case KeyEvent.VK_LEFT:
				keys[KeyHandler.LEFT] = false;
				break;
			case KeyEvent.VK_RIGHT:
				keys[KeyHandler.RIGHT] = false;
				break;
			case KeyEvent.VK_SHIFT:
				keys[KeyHandler.SHIFT] = false;
				break;
			case KeyEvent.VK_SPACE:
				keys[KeyHandler.SPACE] = false;
				break;
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
	
//	/**
//	 * Begins player's animation.
//	 */
//	public void startAnimation() {
//		isAnimating = true;
//	}
	
//	/**
//	 * Ends player's animation.
//	 */
//	public void endAnimation() {
//		isAnimating = false;
//	}
	
	/**
	 * Resets game screen.
	 */
	public void resetGameScreen() {
		manager.resetGameScreen(this);
	}
	
	/**
	 * Switches screen.
	 */
	public void switchScreen(int screen) {
		manager.switchScreen(screen);
	}
	
}