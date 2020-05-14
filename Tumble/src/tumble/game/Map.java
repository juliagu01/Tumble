package tumble.game;

import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import tumble.game.items.*;

/**
 * Represents the map that the player can explore. 
 * @author Amanda Xu, Julia Gu
 * @version May 10, 2020
 */
public class Map {
	
	private static final char VERTICAL_PLATFORM = '|', HORIZONTAL_PLATFORM = '=', VERTICAL_VINE = 'v', HORIZONTAL_VINE = 'h', 
			PLAYER = '$', LEAF = '1', FEATHER = '2', STICK = '3', STRAW = '4', KITE = '5', ORB = '*';
	private static final int TILE_WIDTH = 40;
	private char[][] map;

	/**
	 * Constructs a map of the area that the player can explore from a file. Has platforms and items. 
	 * @param fileName  name of text file from which map is read
	 */
	public Map(String fileName) {
		map = new char[36][60];  // dimensions should automatically adjust to text file instead!
		readFile(fileName);
	}

	/**
	 * Returns an array of this map's platforms.
	 * @return array containing map's platforms
	 */
	public ArrayList<Platform> getPlatforms() {
		
		ArrayList<Platform> platforms = new ArrayList<Platform>();
		
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				
				int len = 1;
				
				// joining process (to reduce # of platform objects)
				if (map[row][col] == HORIZONTAL_PLATFORM) {
					while (col+len < map[row].length && map[row][col+len] == HORIZONTAL_PLATFORM)
						len++;
					platforms.add(new Platform(col * TILE_WIDTH, row * TILE_WIDTH, len * TILE_WIDTH, TILE_WIDTH));
					col += len-1;  // to prevent overcounting
				} 
				else if (map[row][col] == VERTICAL_PLATFORM) {
					while (row+len < map.length && map[row+len][col] == VERTICAL_PLATFORM) {
						map[row+len][col] = 'p';  // to prevent overcounting
						len++;
					}
					platforms.add(new Platform(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH, len * TILE_WIDTH));
				}
				else if (map[row][col] == HORIZONTAL_VINE) {
					while (col+len < map[row].length && map[row][col+len] == HORIZONTAL_VINE)
						len++;
					platforms.add(new Vine(col * TILE_WIDTH, row * TILE_WIDTH, len * TILE_WIDTH, TILE_WIDTH));
					col += len-1;
				} 
				else if (map[row][col] == VERTICAL_VINE) {
					while (row+len < map.length && map[row+len][col] == VERTICAL_VINE) {
						map[row+len][col] = 'p';
						len++;
					}
					platforms.add(new Vine(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH, len * TILE_WIDTH));
				}
				
			}
		}
		
		return platforms;
		
	}

	/**
	 * Returns an array of the map's items.
	 * @return array containing map's items
	 */
	public ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				switch (map[row][col]) {
					case LEAF:
						items.add(new Leaf(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH));
						break;
					case FEATHER:
						items.add(new Feather(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH));
						break;
					case STICK:
						items.add(new Stick(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH));
						break;
					case STRAW:
						items.add(new Straw(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH));
						break;
					case KITE:
						items.add(new Kite(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH));
						break;
					case ORB:
						items.add(new Orb(col * TILE_WIDTH, row * TILE_WIDTH, TILE_WIDTH));
						break;
				}
			}
		}
		return items;		
	}

	/**
	 * Returns the player's starting location.
	 * @return point storing the location of player's center
	 */
	public Point2D.Float getPlayerLocation() {
		for (int row = 0; row < map.length; row++)
			for (int col = 0; col < map[0].length; col++)
				if (map[row][col] == PLAYER)
					return new Point2D.Float(col * TILE_WIDTH, row * TILE_WIDTH);
		return null;		
	}
	
	// Reads map from text file.
	private void readFile(String fileName) {
		
		try {
			InputStream in = getClass().getResourceAsStream(fileName);
			int row = 0, col = 0;
			int ch = in.read();
			while (ch != -1) {
				if (ch == '\n') {
					row++;
					col = 0;
				} else {
					map[row][col] = (char)ch;
					col++;
				}
				ch = in.read();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Map not found.");
		} catch (IOException e) {
			System.out.println("Failed to read map.");
		}
		
	}

}