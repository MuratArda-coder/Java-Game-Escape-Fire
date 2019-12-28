package CREATURE;

import ENTITIES.Entity;
import LAUNCH.Handler;
import TILE.Tile;

public abstract class Creature extends Entity{

	protected int health;
	public static final int DEFAULT_HEALTH = 10;
	
	protected float speed;
	public static final float DEFAULT_SPEED = 2.0f;
	
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	protected float xMove;
	protected float yMove;
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Creature(Handler handler,float x, float y,int width,int heigth) {
		super(handler,x, y,width,heigth);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!colllisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!colllisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!colllisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!colllisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!colllisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!colllisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!colllisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!colllisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}
	}
	
	protected boolean colllisionWithTile(int x,int y) {
		return handler.getDungeon().getTile(x/2, y/2).isSolid(); 
	}
	
	
	
	
}
