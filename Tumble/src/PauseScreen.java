import processing.core.PApplet;

/**
 * Represents the game's pause screen. Has a continue button.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class PauseScreen extends Screen {
	
	/**
	 * Creates a screen with a continue button.
	 */
	public PauseScreen() {
		super();
		super.addButton(new Button(400, 380, 100, DrawingSurface.GAME_SCREEN));
	}

	/**
	 * Draws this pause screen.
	 * @param g - the surface to be drawn on
	 */
	public void draw(PApplet g) {
		
		g.background(217);
		
		// platform
		g.fill(100);
		g.rect(0, 550, 800, 25);
		
		// player
		g.fill(255, 240, 0);
		g.ellipse(100, 300, 500, 500);
		
		// text
		g.fill(50);
		g.textSize(72);
		g.text("PAUSED", 270, 270);
		
		// play button
		g.fill(180);
		g.ellipse(400, 380, 100, 100);
		g.fill(240);
		g.triangle(382, 350, 382, 410, 432, 380);
		
	}

}