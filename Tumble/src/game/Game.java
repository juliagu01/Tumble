package game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;
import items.*;

/**
 * Represents a Tumble game.
 * Credit to Mr. Shelby for basic class structure. 
 * @author Julia Gu
 * @version Apr. 27, 2020
 */
public class Game {
	
	private Player player;
	private ArrayList<Platform> platforms;
	private ArrayList<Item> items;
	private Camera camera;

	/**
	 * Creates a game with a player, platforms, and items. 
	 */
	public Game() {
		
		createPlayer();
		
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(300, 250, 200, 50));  // top center
		platforms.add(new Platform(375, 300, 50, 100));  // middle
		platforms.add(new Platform(200, 400, 400, 50));  // bottom
		platforms.add(new Platform(0,   250, 100, 50));  // top left
		platforms.add(new Platform(700, 250, 100, 50));  // top right
		
		items = new ArrayList<Item>();
		items.add(new Leaf(200, 350));
		items.add(new Feather(300, 350));
		items.add(new Stick(450, 350));
		items.add(new Straw(500, 370));
		items.add(new Kite(600, 350));
		
		camera = new Camera(800f/2, 600f/2, 800f, 600f);
		
	}
	
	/**
	 * Updates the player's velocity.
	 * @param keys  the current keys being pressed
	 */
	public void update(ArrayList<Integer> keys) {
		
		if (keys.contains(KeyEvent.VK_LEFT))
			player.rollLeft();
		if (keys.contains(KeyEvent.VK_RIGHT))
			player.rollRight();
		if (keys.contains(KeyEvent.VK_UP))
			player.jump();

		player.update(platforms, items);

		if (player.y >= 800)
			createPlayer();
		
		camera.setTargetLocation(player.x + Player.WIDTH/2, player.y + Player.WIDTH/2);
		camera.slide();
		
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
		player = new Player(400 - Player.WIDTH/2, 150 - Player.WIDTH/2);
	}

}