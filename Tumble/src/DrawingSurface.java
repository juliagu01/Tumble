import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Represents a canvas onto which a game is drawn. 
 * @author Julia Gu 
 * @version Apr. 27, 2020
 * Credit to Mr. Shelby for basic class structure! 
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher{
	
	/**
	 * DrawingSurfaces' shared dimensions. 
	 */
	public static final int DRAWING_WIDTH = 800, DRAWING_HEIGHT = 600;
	public float ratioX, ratioY;
	private Game game;
	private Camera camera;
	private ArrayList<Integer> keys;
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	/**
	 * Creates a canvas that displays a game. 
	 */
	public DrawingSurface() {
		super();
		screens = new ArrayList<Screen>();
//		game = new Game();
		keys = new ArrayList<Integer>();
		StartScreen screen1 = new StartScreen(this);
		screens.add(screen1);
		camera = new Camera(DRAWING_WIDTH/2, DRAWING_HEIGHT/2, DRAWING_WIDTH, DRAWING_HEIGHT);
		
		activeScreen = screens.get(0);
	}
	
	public void settings() {
		// size(DRAWING_WIDTH, DRAWING_HEIGHT, P2D);
		size(activeScreen.WIDTH, activeScreen.HEIGHT);
	}
	
	/**
	 * Sets up the drawing surface.
	 */
	public void setup() {
		surface.setResizable(true);
		for (Screen s : screens)
			s.setup();
		noStroke();
	}

	/**
	 * Draws the game.
	 */
	public void draw() {
		ratioX = (float)width/activeScreen.WIDTH;
		ratioY = (float)height/activeScreen.HEIGHT;
		game.update(keys);
		
		camera.setTargetLocation(game.getPlayer().x + Player.WIDTH/2, game.getPlayer().y + Player.WIDTH/2);
		camera.slide();
		
		background(150);
		
		pushMatrix();
		scale(width/camera.width, height/camera.height);
		translate(-camera.x, -camera.y);
		
		fill(100);
		for (Rectangle2D.Float r : game.getPlatforms())
			rect(r.x, r.y, r.width, r.height);

		game.getPlayer().draw(this);
		activeScreen.draw();
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
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
	
}