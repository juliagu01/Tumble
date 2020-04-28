import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Represents a canvas onto which a game is drawn. 
 * @author Julia Gu 
 * @version Apr. 27, 2020
 * Credit to Mr. Shelby for basic class structure! 
 */
public class DrawingSurface extends PApplet {
	
	/**
	 * DrawingSurfaces' shared dimensions. 
	 */
	public static final int DRAWING_WIDTH = 800, DRAWING_HEIGHT = 600;

	private Game game;
	private Camera camera;
	private ArrayList<Integer> keys;
	
	/**
	 * Creates a canvas that displays a game. 
	 */
	public DrawingSurface() {
		super();
		game = new Game();
		keys = new ArrayList<Integer>();
		camera = new Camera(DRAWING_WIDTH/2, DRAWING_HEIGHT/2, DRAWING_WIDTH, DRAWING_HEIGHT);
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

		game.update(keys);
		
		camera.setTargetLocation(game.getPlayer().x + Player.WIDTH/2, game.getPlayer().y + Player.WIDTH/2);
		camera.slide();
		
		background(150);
		
		pushMatrix();
		scale(width/camera.width, height/camera.height);
		translate(-camera.x, -camera.y);
		
		for (Platform r : game.getPlatforms())
			r.draw(this);
		
		for (Item i : game.getItems()) {
			ArrayList<Item> playerItems = game.getPlayer().getItems();
			if (playerItems == null || !playerItems.contains(i))
				i.draw(this);
		}

		game.getPlayer().draw(this);

		popMatrix();
		
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
	
}