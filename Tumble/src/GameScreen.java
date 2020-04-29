import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Represents the game's main screen
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 */
public class GameScreen extends Screen {
	
	private Game game;
	private Camera camera;
	
	/**
	 * Creates a screen with a game.
	 */
	public GameScreen() {
		super();
		game = new Game();
		camera = new Camera(Screen.WIDTH/2, Screen.HEIGHT/2, Screen.WIDTH, Screen.HEIGHT);
		super.addButton(new Button(Screen.WIDTH - 50, 60, 50, DrawingSurface.PAUSE_SCREEN));
	}
	
	/**
	 * Draw this game screen.
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		camera.setTargetLocation(game.getPlayer().x + Player.WIDTH/2, game.getPlayer().y + Player.WIDTH/2);
		camera.slide();
		
		g.pushMatrix();
		g.scale(g.width/camera.width, g.height/camera.height);
		g.translate(-camera.x, -camera.y);
		game.draw(g);
		g.popMatrix();
		
		g.pushMatrix();
		g.scale(g.width/Screen.WIDTH, g.height/Screen.HEIGHT);
		g.fill(180);
		g.ellipse(750, 60, 50, 50);
		g.fill(240);
		g.rect(741, 48, 5, 24);
		g.rect(754, 48, 5, 24);
		g.popMatrix();
		
	}
	
	/**
	 * Updates this game screen.
	 * @param keys - keys that are currently pressed
	 */
	public void update(ArrayList<Integer> keys) {
		game.update(keys);
	}

}