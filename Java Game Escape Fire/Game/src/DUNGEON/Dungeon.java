 package DUNGEON;
 
import java.awt.Graphics;

import LAUNCH.Handler;
import TILE.Tile;
import UTILS.Utils;

public class Dungeon {

	private int width , height;
	private int spawnX , spawnY;
	private int[][] tiles;//holds bunch of id which tile and where
	
	int widthTile = Tile.TILEWIDTH;
	int heightTile = Tile.TILEHEIGHT;
	
	private Handler handler;
	
	
	public Dungeon(Handler handler,String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		
		//To avoid redundant render
		int xStart = Math.max(0, (int) (handler.getCamera().getxOffset()/Tile.TILEWIDTH/2));
		int xEnd = (int) Math.min(width,(handler.getCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH+10);
		int yStart = Math.max(0, (int) (handler.getCamera().getyOffset()/Tile.TILEHEIGHT/2));
		int yEnd = (int) Math.min(height,(handler.getCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGHT+10);
		
		for(int y = yStart;y<yEnd;y++) {
			for(int x = xStart;x<xEnd;x++) {
				getTile(x,y).render(g,
								(int) (x*widthTile*2-handler.getCamera().getxOffset()),
								(int) (y*heightTile*2-handler.getCamera().getyOffset())
							);
			}
		}
	}
	
	public Tile getTile(int x,int y) {
		
		//if we have parameters outside the map
		if(x<0 || y<0 || x>=width || y>=height)
			return Tile.surfaceTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.surfaceTile;
		return t;
	}

	
	private void loadWorld(String path) {
		
		String file = Utils.LoadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int x = 0;x<width;x++) {
			for(int y = 0;y<height;y++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
		
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
	
	
}
