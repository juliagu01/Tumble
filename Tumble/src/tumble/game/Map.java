package tumble.game;

import java.util.ArrayList;

import processing.core.PApplet;
/**
 * Represents the map that the player can explore
 * @author Amanda Xu
 * @version 5/6/20
 */
public class Map {
	private ArrayList<Platform> platforms;
	private int tileState[][];
	private int height, width;
	private static final int MIN_DIM = 40;
	/**
	 * possible states in a tile
	 */
	private static final int EMPTY = 0, PLAT = 1, ITEM = 2, PLAYER = 3;
	
	/**
	 * Constructs a map object of the area that the player can explore with platforms
	 * @param height the height of the full map
	 * @param width the width of the full map
	 */
	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		tileState = new int[height/MIN_DIM][width/MIN_DIM];
		for(int i = 0; i<tileState.length; i++) {
			for(int j = 0; j<tileState[0].length; j++) {
				//if player occupies space, then equals 3, if item equals 2 all else
				//either empty or platform
//				if() {
//					
//				} else if{
//					
//				} else {
//					tileState[i][j] = (int)(Math.random()+1);
//				}
			}
		}
//		platforms = new ArrayList<Platform>();
//		
//		platforms.add(new Platform(-200, 150, 400, 40));   // top
//		platforms.add(new Platform( 500, 275, 100, 40));   // middle
//		platforms.add(new Platform(-200, 400, 1500, 40));  // bottom
	}
	
	/**
	 * Draws the map
	 * @param g the surface to be drawn on
	 */
	public void draw(PApplet g) {
		for (Platform p : platforms)
			p.draw(g);
	}
	
	/**
	 * Sets the state of all the specific layed out tiles on the screen
	 * @param tileState the state of all the tiles on the map
	 */
	public void setTileState(int[][] tileState) {
		this.tileState = tileState;
	}
	
	/**
	 * Returns all the platforms on the map
	 * @return all the platforms on the map
	 */
	public ArrayList<Platform> getPlatforms(){
		return platforms;
	}
	
	/**
	 * Returns the height of the map
	 * @return height of the map
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Returns the width of the map
	 * @return width of the map
	 */
	public int getWidth() {
		return width;
	}
	
}
