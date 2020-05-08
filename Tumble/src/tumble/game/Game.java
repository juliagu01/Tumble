package tumble.game;

import java.util.ArrayList;
import processing.core.PApplet;
import tumble.gui.DrawingSurface;
import tumble.gui.KeyHandler;
import tumble.gui.Message;
import tumble.items.*;

/**
 * Represents a Tumble game.
 * Credit to Mr. Shelby for basic class structure. 
 * @author Andra Liu, Julia Gu, Amanda Xu
 * @version May 7, 2020
 */
public class Game {
	
	private Player player;
	private Map map;
	private ArrayList<Item> items;
	private Message message;
	private Camera camera;
	private ArrayList<Platform> platforms;
	/**
	 * Creates a game with a player, platforms, and items. 
	 */
	public Game() {
		
		createPlayer();
		
		map = new Map(3200, 1200);
		platforms = new ArrayList<Platform>();
		
		platforms.add(new Platform(-200, 150, 400, 40));   // top
		platforms.add(new Platform( 500, 275, 100, 40));   // middle
		platforms.add(new Platform(-200, 400, 1500, 40));  // bottom
		items = new ArrayList<Item>();
		items.add(new Leaf(300, 350));
		items.add(new Feather(200, 350));
		items.add(new Stick(125, 100));
		items.add(new Straw(0, 100));
		items.add(new Kite(-100, 100));
		items.add(new Orb(-200, 100));
		
		camera = new Camera(800f/2, 600f/2, 800f, 600f);
		
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
		
		map.draw(g);
		
		for (Item i : items) {
			ArrayList<Item> playerItems = player.getItems();
			if (!playerItems.contains(i))
				i.draw(g);
		}

		player.draw(g);

		g.popMatrix();
		
	}

	private void createPlayer() {
		player = new Player(this, 400 - Player.WIDTH/2, 150 - Player.WIDTH/2);
	}

}