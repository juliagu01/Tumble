package tumble.gui;

import processing.core.PApplet;

/**
 * Represents a colored message that spans the bottom of the screen. 
 * @author Julia Gu 
 * @version May 5, 2020 
 */
public class Message {
	
	private String text;
	private int color;

	/**
	 * Creates a message that spans the bottom of the screen.
	 * @param text  message's text
	 * @param color  message's background color
	 */
	public Message(String text, int color) {
		this.text = text;
		this.color = color;
	}
	
	/**
	 * Draws this message. 
	 * @param g  surface to be drawn on
	 */
	public void draw(PApplet g) {
		g.fill(color);
		g.rect(0, 400, 800, 200);
		g.fill(255);
		g.textSize(16);
		g.text(text, 100, 450, 600, 100);
		g.textSize(10);
		String instruction = "[space to continue]";
		g.text(instruction, 700 - g.textWidth(instruction), 570);
	}
	
}