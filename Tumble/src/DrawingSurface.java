import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Player player;
	private ArrayList<Rectangle> obstacles;
	private Camera camera;

	private ArrayList<Integer> keys;
	

	public DrawingSurface() {
		super();
		keys = new ArrayList<Integer>();
		camera = new Camera(DRAWING_WIDTH/2, DRAWING_HEIGHT/2, DRAWING_WIDTH, DRAWING_HEIGHT);
		obstacles = new ArrayList<Rectangle>();
		obstacles.add(new Rectangle(300, 250, 200, 50));  // top center
		obstacles.add(new Rectangle(375, 300, 50, 100));  // middle
		obstacles.add(new Rectangle(200, 400, 400, 50));  // bottom
		obstacles.add(new Rectangle(0,   250, 100, 50));  // top left
		obstacles.add(new Rectangle(700, 250, 100, 50));  // top right
	}


	private void createPlayer() {
		player = new Player(DRAWING_WIDTH/2 - Player.PLAYER_WIDTH/2, DRAWING_HEIGHT/4 - Player.PLAYER_WIDTH/2, color(255, 240, 0));
	}
	

	public void setup() {
		noStroke();
		createPlayer();
	}

	public void draw() {


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
		
		camera.setTargetLocation(player.x + Player.PLAYER_WIDTH/2, player.y + Player.PLAYER_WIDTH/2);
		camera.slide();

		
		// drawing
		
		background(150);
		
		pushMatrix();
		scale((float)(width/camera.width), (float)(height/camera.height));
		translate((float)-camera.x, (float)-camera.y);
		
		fill(100);
		for (Rectangle r : obstacles)
			rect(r.x, r.y, r.width, r.height);

		player.draw(this);

		popMatrix();
		
		
	}


	public void keyPressed() {
		keys.add(keyCode);
		if (keyCode == KeyEvent.VK_A)
			System.out.println(player.x + ", " + player.y);
			
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove((Integer)keyCode);
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

}