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
	
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.PAUSE_SCREEN);
	}

}
