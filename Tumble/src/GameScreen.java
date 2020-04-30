import java.util.ArrayList;

/**
 * Represents the game's main screen
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 */
public class GameScreen extends Screen {
	
	private Game game;
	
	/**
	 * Creates a screen with a game.
	 * @param surface - drawing surface onto which this screen is drawn
	 */
	public GameScreen(DrawingSurface surface) {
		super(surface);
		game = new Game();
		super.addButton(new Button(Screen.WIDTH - 50, 60, 50, DrawingSurface.PAUSE_SCREEN));
	}
	
	/**
	 * Draw this game screen.
	 */
	public void draw() {
		
		DrawingSurface g = getSurface();
		game.draw(g);
		
		// pause button
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