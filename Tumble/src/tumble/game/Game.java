package tumble.game;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import processing.core.PApplet;
import tumble.gui.KeyHandler;
import tumble.gui.Message;

/**
 * Represents a Tumble game.
 * Credit to Mr. Shelby for basic class structure. 
 * @author Andra Liu, Julia Gu, Amanda Xu
 * @version May 7, 2020
 */
public class Game {
	
	private Player player;
	private ArrayList<Platform> platforms;
	private ArrayList<Item> items;
	private Camera camera;
	private Message message;
	
	/**
	 * Creates a game with a player, platforms, and items. 
	 */
	public Game() {
		
		Map map = new Map();
		
		Point2D.Float playerLoc = map.getPlayerLocation();
		player = new Player(this, playerLoc.x, playerLoc.y);
		
		platforms = map.getPlatforms();
		items = map.getItems();
		
		camera = new Camera(playerLoc.x, playerLoc.y, 800f, 600f);
		
	}
	
	/**
	 * Updates the player's velocity.
	 * @param keys  the current keys being pressed
	 */
	public void update(boolean[] keys) {
		
		if (message == null) {
			if (keys[KeyHandler.LEFT])
				player.rollLeft();
			if (keys[KeyHandler.RIGHT])
				player.rollRight();
			if (keys[KeyHandler.UP]) 
				player.jump();
			
			if (keys[KeyHandler.A])
				player.setCurrGlide(true);
			else
				player.setCurrGlide(false);
		} else if (keys[KeyHandler.ENTER])
			message = null;

		player.update(platforms, items);
		
		camera.setTargetLocation(player.x + Player.WIDTH/2, player.y + Player.WIDTH/2);
		camera.slide();
		
	}
	
	/**
	 * Switches this game's message. 
	 * @param message  message to be switched to
	 */
	public void setMessage(Message message) {
		this.message = message;
	}
	
	/**
	 * Returns this game's current message. 
	 * @return this game's message
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Draws this game.
	 * @param g  the surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		g.pushMatrix();
		g.scale(g.width/camera.width, g.height/camera.height);
		g.translate(-camera.x, -camera.y);
		
		for (Platform p : platforms)
			p.draw(g);
		
		for (Item i : items) {
			ArrayList<Item> playerItems = player.getItems();
			if (!playerItems.contains(i))
				i.draw(g);
		}

		player.draw(g);

		g.popMatrix();
		
	}

}