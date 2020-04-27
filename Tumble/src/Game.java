import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Represents a Tumble game.
 * @author Julia Gu
 * @version Apr. 27, 2020
 * Credit to Mr. Shelby for basic class structure! 
 */
public class Game {
	
	private Player player;
	private ArrayList<Rectangle2D.Float> platforms;

	/**
	 * Creates a game with a player and platforms. 
	 */
	public Game() {
		createPlayer();
		platforms = new ArrayList<Rectangle2D.Float>();
		platforms.add(new Rectangle2D.Float(300, 250, 200, 50));  // top center
		platforms.add(new Rectangle2D.Float(375, 300, 50, 100));  // middle
		platforms.add(new Rectangle2D.Float(200, 400, 400, 50));  // bottom
		platforms.add(new Rectangle2D.Float(0,   250, 100, 50));  // top left
		platforms.add(new Rectangle2D.Float(700, 250, 100, 50));  // top right
	}
	
	/**
	 * Updates the player's velocity.
	 * @param keys - the current keys being pressed
	 */
	public void update(ArrayList<Integer> keys) {

		if (keys.contains(KeyEvent.VK_LEFT))
			player.roll(-1);
		if (keys.contains(KeyEvent.VK_RIGHT))
			player.roll(1);
		if (keys.contains(KeyEvent.VK_UP))
			player.jump();

		player.update(platforms);

		if (player.y >= 800)
			createPlayer();
		
	}
	
	/**
	 * Returns this game's player. 
	 * @return the object representing this game's player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Returns this game's platforms.
	 * @return the array representing this game's platforms
	 */
	public ArrayList<Rectangle2D.Float> getPlatforms() {
		return platforms;
	}

	private void createPlayer() {
		player = new Player(DrawingSurface.DRAWING_WIDTH/2 - Player.WIDTH/2, DrawingSurface.DRAWING_HEIGHT/4 - Player.WIDTH/2);
	}

}