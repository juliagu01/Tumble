package tumble.game;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Represents the map that the player can explore
 * 
 * @author Amanda Xu
 * @version 5/6/20
 */
public class Map {
	
	private int tileState[][];
	private int height, width;
	private static final int MIN_DIM = 40;
	/**
	 * possible states in a tile
	 */
	private static final int EMPTY = 0, PLAT = 1, VINE = 2, ITEM = 3, PLAYER = 4;

	/**
	 * Constructs a map object of the area that the player can explore with
	 * platforms
	 * 
	 * @param height the height of the full map
	 * @param width  the width of the full map
	 */
	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		tileState = new int[height / MIN_DIM][width / MIN_DIM];
		tileState[tileState.length / 2][tileState[0].length / 2] = PLAYER;

		int itemC = 0;
		for (int i = 0; i < tileState.length; i++) {
			for (int j = 0; j < tileState[0].length; j++) {
				if (itemC < 5 && tileState[i][j] != PLAYER) {
					tileState[i][j] = (int) (Math.random() * 4);
				} else {
					tileState[i][j] = (int) (Math.random() * 3);
				}
			}
		}

	}

	/**
	 * Draws the map
	 * 
	 * @param g the surface to be drawn on
	 */
	public void draw(PApplet g) {

		
	}

	/**
	 * Sets the state of all the specific layed out tiles on the screen
	 * 
	 * @param tileState the state of all the tiles on the map
	 */
	public void setTileState(int[][] tileState) {
		this.tileState = tileState;
	}

//	/**
//	 * Returns all the platforms on the map
//	 * 
//	 * @return all the platforms on the map
//	 */
//	public ArrayList<Platform> getPlatforms() {
//		return platforms;
//	}

	/**
	 * Returns the height of the map
	 * 
	 * @return height of the map
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the width of the map
	 * 
	 * @return width of the map
	 */
	public int getWidth() {
		return width;
	}

}
