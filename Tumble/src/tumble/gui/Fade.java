package tumble.gui;

import processing.core.PApplet;

/**
 * Represents a white layer that can change opacity. 
 * @author Julia Gu
 * @version May 20, 2020
 */
public class Fade {

	private float opacity, targetOpacity;
	private float speed;
	
	/**
	 * Creates a layer that can change opacity. 
	 * @param startOpacity  layer's initial opacity between 0.0 and 1.0, inclusive
	 * @param speed  speed of fade
	 */
	public Fade(float startOpacity, float speed) {
		opacity = targetOpacity = startOpacity;
		this.speed = speed;
	}
	
	/**
	 * Begins a fade from the current opacity to the given. 
	 * @param opacity  layer's target opacity between 0.0 and 1.0, inclusive
	 */
	public void fadeTo(float opacity) {
		targetOpacity = opacity;
	}
	
	/**
	 * Returns this layer's opacity. 
	 * @return layer's opacity between 0.0 and 1.0, inclusive
	 */
	public float getOpacity() {
		return opacity;
	}
	
	/**
	 * Updates this layer's opacity. 
	 */
	public void update() {
		opacity += (targetOpacity-opacity) * speed;
	}
	
	/**
	 * Draws this layer.
	 * @param g  surface to be drawn on
	 * @param x  x-coordinate of layer's upper-left corner
	 * @param y  y-coordinate of layer's upper-left corner
	 * @param w  layer's width
	 * @param h  layer's height
	 */
	public void draw(PApplet g, float x, float y, float w, float h) {
		g.fill(255, 255 * opacity);
		g.rect(x, y, w, h);
	}
	
}