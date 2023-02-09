package tumble.game;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import tumble.gui.*;

/**
 * Represents a Tumble game.
 * Credit to Mr. Shelby for basic class structure. 
 * @author Andra Liu, Julia Gu, Amanda Xu
 * @version May 16, 2020
 */
public class Game {
	
	private Player player;
	private ArrayList<Platform> platforms;
	private Item[] items;
	private Camera camera;
	private Message message;
	private Fade fade;
	private boolean hasColor;
	
	/**
	 * Creates a game with a player, platforms, and items. 
	 */
	public Game() {
		
		Map map = new Map("/data/map.txt");
		
		Point2D.Float playerLocation = map.getPlayerLocation();
		player = new Player(this, playerLocation.x, playerLocation.y);
		
		platforms = map.getPlatforms();
		items = map.getItems();
		
		camera = new Camera(player.x + player.width/2, player.y + player.width/2, Screen.WIDTH, Screen.HEIGHT);
		
		fade = new Fade(0.4f, 0.05f);
		hasColor = false;
		
	}
	
	/**
	 * Updates the game.
	 * @param keys  current keys being pressed
	 */
	public void update(boolean[] keys) {
		
		if (message == null) {
			
			if (keys[KeyHandler.LEFT])
				player.rollLeft();
			if (keys[KeyHandler.RIGHT])
				player.rollRight();
			if (keys[KeyHandler.SHIFT])
				player.tryBoost();
			if (keys[KeyHandler.UP]) {
				player.tryJump();
				player.tryGlide();
			}
			
		} else if (keys[KeyHandler.SPACE]) {
			
			if (fade.getOpacity() > 0.4f) {
				fade.fadeTo(0);
				hasColor = true;
				for (Platform p : platforms)
					p.addColor();
			}
			
			if (message == items[Item.ORB].getMessage())
				SoundPlayer.playSound(SoundPlayer.TOOT);
			else
				SoundPlayer.playSound(SoundPlayer.CLINK);
			
			message = null;
//			surface.endAnimation();
			
		}

		player.update(platforms, items);
		
		camera.setTargetLocation(player.x + player.width/2, player.y + player.width/2);
		camera.slide();
		
		fade.update();
		
	}
	
	/**
	 * Changes this game's message to match that of the given item.
	 * @param item  item whose message is to be shown
	 */
	public void showMessageOf(Item item) {
		if (item == items[Item.ORB])
			fade.fadeTo(1);
		this.message = item.getMessage();
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
	 * @param g  surface to be drawn on
	 */
	public void draw(DrawingSurface g) {
		
		g.pushMatrix();
		g.scale(g.width/camera.width, g.height/camera.height);
		g.translate(-camera.x, -camera.y);

		// background
		if (!hasColor)
			g.background(190, 185, 195);
		else
			g.background(170, 225, 240);
		
		// platforms
		for (Platform p : platforms)
			p.draw(g);
		
		// fade
		fade.draw(g, camera.x, camera.y, camera.width, camera.height);
		
		// items
		for (Item i : items)
			if (!player.hasItem(i) || message == i.getMessage())
				i.draw(g);

		// player
		player.draw(g);

		g.popMatrix();
		
	}

}