package tumble.game;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import processing.core.PApplet;
import tumble.game.items.Orb;
import tumble.gui.DrawingSurface;
import tumble.gui.Fade;
import tumble.gui.KeyHandler;
import tumble.gui.Message;
import tumble.gui.Sound;

/**
 * Represents a Tumble game.
 * Credit to Mr. Shelby for basic class structure. 
 * @author Andra Liu, Julia Gu, Amanda Xu
 * @version May 16, 2020
 */
public class Game {
	
	private Player player;
	private ArrayList<Platform> platforms;
	private ArrayList<Item> items;
	private Camera camera;
	private Message message;
	private Fade fade;
	private boolean hasColor;
	private final Sound clink = new Sound("audio/powerup.wav");
	private final Sound toot = new Sound("audio/orb.wav");
	
	/**
	 * Creates a game with a player, platforms, and items. 
	 */
	public Game() {
		
		Map map = new Map("/tumble/game/map.txt");
		
		Point2D.Float playerLoc = map.getPlayerLocation();
		player = new Player(this, playerLoc.x, playerLoc.y);
		
		platforms = map.getPlatforms();
		items = map.getItems();
		
		camera = new Camera(playerLoc.x + player.width/2, playerLoc.y + player.width/2, 800f, 600f);
		
		fade = new Fade(0.4f, 0.05f);
		hasColor = false;
		
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
			message = null;
			if (DrawingSurface.hasSound())
				clink.play();
		}

		player.update(platforms, items);
		
		camera.setTargetLocation(player.x + player.width/2, player.y + player.width/2);
		camera.slide();
		
		fade.update();
		
	}
	
	/**
	 * Switches this game's message. 
	 * @param message  message to be switched to
	 */
	public void setMessage(Message message) {
		for (Item i : items)
			if (i instanceof Orb && i.getMessage() == message) {
				fade.fadeTo(1);
				if (DrawingSurface.hasSound())
					toot.play();
			}
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

		// background
		if (!hasColor)
			g.background(192, 185, 194);
		else 
			g.background(183, 225, 237);
		
		// platforms
		for (Platform p : platforms)
			p.draw(g);
		
		// fade
		fade.draw(g, camera.x, camera.y, camera.width, camera.height);
		
		// items
		for (Item i : items)
			if (!player.getItems().contains(i) || i.getMessage() == message)
				i.draw(g);

		// player
		player.draw(g);

		g.popMatrix();
		
	}

}