package TILE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	protected BufferedImage texture;
	protected int id;

	public static final int TILEWIDTH = 34;
	public static final int TILEHEIGHT = 34;
	
	//STATIC STUFF HERE
	public static Tile[] tiles = new Tile[256];
	
	public static Tile surfaceTile = new Surface(0);
	public static Tile lineTile = new Line(1);
	public static Tile floorTile = new FloorTile(2);
	public static Tile wallTile = new WallTile(3);
	public static Tile healthTile = new healthTile(4);
	public static Tile fireTile = new fireTile(5);
	
	public static Tile upDoorTile = new DoorUpTile(6);
	public static Tile downDoorTile = new DoorDownTile(7);
	
	
	//CLASS
	
	public Tile(BufferedImage texture,int id) {
		
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
		
	}
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture,x,y,TILEWIDTH*2,TILEHEIGHT*2,null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
