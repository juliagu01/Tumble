package tumble.gui;
import processing.core.PApplet;
import processing.core.PImage;

public class Animation extends PApplet {
	
	private PImage p;

	public void setup() {
		p = loadImage("lightning.gif", "gif");
	}
	
	public void draw() {
		image(p, 100, 100);

	}
}