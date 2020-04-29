import processing.core.PApplet;

/**
 * Represents the game's start screen. Has a play button.
 * @author Amanda Xu, Julia Gu
 * @version Apr. 28, 2020
 */
public class StartScreen extends Screen {
	
	/**
	 * Creates a screen with the game's title and a play button.
	 */
	public StartScreen() {
		super();
		super.addButton(new Button(400, 400, 100, DrawingSurface.GAME_SCREEN));
	}

	/**
	 * Draws this start screen.
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		g.background(217);
		
		// platform
		g.fill(100);
		g.rect(0, 550, 800, 50);
		
		// player
		g.fill(255, 240, 0);
		g.ellipse(100, 300, 500, 500);
		
		// title
		g.fill(50);
		g.textSize(90);
		g.text("TUMBLE", 240, 250);
		
		// subtitle
		g.textSize(24);
		g.text("game by VanillaChip", 300, 300);
		
		// play button
		g.fill(180);
		g.ellipse(400, 400, 100, 100);
		g.fill(240);
		g.triangle(382, 370, 382, 430, 432, 400);
		
	}

}