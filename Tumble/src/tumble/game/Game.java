package tumble.game;

import java.util.ArrayList;
import processing.core.PApplet;
import tumble.gui.DrawingSurface;
import tumble.gui.Message;
import tumble.items.*;

/**
 * Represents a Tumble game.
 * Credit to Mr. Shelby for basic class structure. 
 * @author Julia Gu, Andra Liu
 * @version May 5, 2020
 */
public class Game {
	
	private Player player;
	private ArrayList<Platform> platforms;
	private ArrayList<Item> items;
	private Message message;
	private Camera camera;

	/**
	 * Creates a game with a player, platforms, and items. 
	 */
	public Game() {
		
		createPlayer();
		
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(-200, 150, 400, 40));  // top
		platforms.add(new Platform( 500, 275, 100, 40));   // middle
		platforms.add(new Platform(-200, 400, 1500, 40));  // bottom
		
		items = new ArrayList<Item>();
		items.add(new Leaf(300, 350));
		items.add(new Feather(200, 350));
		items.add(new Stick(125, 100));
		items.add(new Straw(0, 100));
		items.add(new Kite(-100, 100));
		
		camera = new Camera(800f/2, 600f/2, 800f, 600f);
		
	}
	
	/**
	 * Updates the player's velocity.
	 * @param keys  the current keys being pressed
	 */
	public void update(boolean[] keys) {
		
		if (message == null) {
			if (keys[DrawingSurface.LEFT])
				player.rollLeft();
			if (keys[DrawingSurface.RIGHT])
				player.rollRight();
			if (keys[DrawingSurface.UP]) 
				player.jump();
			
			if (keys[DrawingSurface.A])
				player.setCurrGlide(true);
			else
				player.setCurrGlide(false);
		} else if (keys[DrawingSurface.RIGHT]) {
			message = null;
			for (int i = 0; i < keys.length; i++)
				keys[i] = false;
		}

		player.update(platforms, items);

		if (player.y >= 800)
			createPlayer();
		
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
			if (playerItems == null || !playerItems.contains(i))
				i.draw(g);
		}

		player.draw(g);

		g.popMatrix();
		
	}

	private void createPlayer() {
		player = new Player(this, 400 - Player.WIDTH/2, 150 - Player.WIDTH/2);
	}

}