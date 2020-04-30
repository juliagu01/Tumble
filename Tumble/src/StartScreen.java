/**
 * Represents the game's start screen. Has a play button.
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 */
public class StartScreen extends Screen {
	
	/**
	 * Creates a screen with the game's title and a play button.
	 */
	public StartScreen(DrawingSurface surface) {
		super(surface);
		super.addButton(new Button(Screen.WIDTH/2, Screen.HEIGHT * 2/3, Screen.HEIGHT/6, DrawingSurface.GAME_SCREEN));
	}

	/**
	 * Draws this start screen.
	 * @param g - the surface to be drawn on
	 */
	public void draw() {
		
		DrawingSurface g = getSurface();
		g.background(150);
		
		g.pushMatrix();
		g.scale(g.width/800f, g.height/600f);
		
		// platform
		g.fill(100);
		g.rect(0, 550, 800, 50);
		
		// player
		g.fill(250, 230, 50);
		g.ellipse(100, 300, 500, 500);
		
		// title
		g.fill(50);
		g.textSize(90);
		String title = "TUMBLE";
		float titleW = g.textWidth(title);
		g.text("TUMBLE", 400 - titleW/2, 250);
		
		// subtitle
		g.textSize(24);
		String subtitle = "game by VanillaChip";
		float subtitleW = g.textWidth(subtitle);
		g.text("game by VanillaChip", 400 - subtitleW/2, 300);
		
		// play button
		g.fill(180);
		g.ellipse(400, 400, 100, 100);
		g.fill(240);
		g.triangle(385, 375, 385, 425, 425, 400);
		
		g.popMatrix();
		
	}

}