import processing.core.PApplet;

 /**
  * Represents a movable ellipse with basic physics and rectangular collision detection.
  * @author Julia Gu
  * @version Apr. 20, 2020
  */
public class Sprite extends MovableRectangle {
	
	private int color;
	
	/**
	 * Creates an ellipse that represents a sprite. Sprite has a rectangular hit-box.
	 * @param x - x-coordinate of sprite's upper-left corner
	 * @param y - y-coordinate of sprite's upper left corner
	 * @param w - sprite's width
	 * @param h - sprite's height
	 * @param c - sprite's color
	 */
	public Sprite(int x, int y, int w, int h, int c) {
		super(x, y, w, h);
		color = c;
	}
	
	/**
	 * Draws this sprite as an ellipse.
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(color);
		g.ellipse((float)(x + width/2), (float)(y + height/2), (float)width, (float)height);
	}
	
}