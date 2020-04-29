import java.awt.Point;
import java.awt.Rectangle;

public class GameScreen extends Screen{
	
	private DrawingSurface surface;
	private Rectangle button;
	
	public GameScreen(DrawingSurface surface) {
		super(800, 600);
		this.surface = surface;
		button = new Rectangle(100, 500, 200, 200);
		
	}
	public void draw() {
		surface.pushStyle();

		surface.background(255, 255, 255);

		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "PAUSE!";
		float w = surface.textWidth(str);
		surface.text(str, button.x + button.width / 2 - w / 2, button.y + button.height / 2);

		surface.popStyle();
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.PAUSE_SCREEN);
	}

}
