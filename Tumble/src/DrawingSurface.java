import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Player player;
	private ArrayList<Rectangle> obstacles;

	private ArrayList<Integer> keys;

	public DrawingSurface() {
		super();
		keys = new ArrayList<Integer>();
		obstacles = new ArrayList<Rectangle>();
		obstacles.add(new Rectangle(200, 400, 400, 50));
		obstacles.add(new Rectangle(0,   250, 100, 50));
		obstacles.add(new Rectangle(700, 250, 100, 50));
		obstacles.add(new Rectangle(375, 300, 50, 100));
		obstacles.add(new Rectangle(300, 250, 200, 50));
	}


	private void createPlayer() {
		player = new Player(DRAWING_WIDTH/2 - Player.PLAYER_WIDTH/2, DRAWING_HEIGHT/4 - Player.PLAYER_WIDTH/2, color(255, 240, 0));
	}
	

	public void setup() {
		noStroke();
		createPlayer();
	}


	public void draw() {

		
		// drawing
		
		background(150);
		
		pushMatrix();
		float ratioX = (float)width/DRAWING_WIDTH;
		float ratioY = (float)height/DRAWING_HEIGHT;
		translate((float)width/2, (float)height/2);
		scale(ratioX, ratioY);

		fill(100);
		for (Rectangle r : obstacles)
			rect(r.x - (float)(player.x + Player.PLAYER_WIDTH/2), r.y - (float)(player.y + Player.PLAYER_WIDTH/2), r.width, r.height);

		player.draw(this);

		popMatrix();


		// modifying

		if (isPressed(KeyEvent.VK_LEFT))
			player.roll(-1);
		if (isPressed(KeyEvent.VK_RIGHT))
			player.roll(1);
		if (isPressed(KeyEvent.VK_UP))
			player.jump();

		player.update(obstacles);

		if (player.y >= 800)
			createPlayer();
		
		
	}


	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove((Integer)keyCode);
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

}