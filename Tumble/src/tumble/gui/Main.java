package tumble.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/**
 * Creates a window containing an instance of a Tumble game.
 * @author John Shelby
 */
public class Main {

	/**
	 * Creates a window containing an instance of the game.
	 * @param args  command-line arguments
	 */
	public static void main(String args[]) {

		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setSize((int)Screen.WIDTH, (int)Screen.HEIGHT);
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Tumble - game by VanillaChip");
		window.setResizable(true);
		window.setVisible(true);
		canvas.requestFocus();
		
	}

}