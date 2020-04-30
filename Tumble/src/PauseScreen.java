/**
 * Represents the game's pause screen. Has a continue button.
 * @author Julia Gu
 * @version Apr. 28, 2020
 */
public class PauseScreen extends Screen {
	
	/**
	 * Creates a screen with a continue button.
	 * @param surface - drawing surface onto which this screen is drawn
	 */
	public PauseScreen(DrawingSurface surface) {
		super(surface);
		super.addButton(new Button(Screen.WIDTH/2, Screen.HEIGHT * 380/600, Screen.HEIGHT/6, DrawingSurface.GAME_SCREEN));
	}

	/**
	 * Draws this pause screen.
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
		
		// text
		g.fill(50);
		g.textSize(72);
		String text = "PAUSED";
		float textW = g.textWidth(text);
		g.text("PAUSED", 400 - textW/2, 270);
		
		// play button
		g.fill(180);
		g.ellipse(400, 380, 100, 100);
		g.fill(240);
		g.triangle(385, 355, 385, 405, 425, 380);
		
		g.popMatrix();
		
	}

}