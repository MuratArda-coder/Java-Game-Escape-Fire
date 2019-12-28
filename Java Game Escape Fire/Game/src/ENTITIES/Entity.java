package ENTITIES;

import java.awt.Graphics;
import java.awt.Rectangle;

import LAUNCH.Handler;

public abstract class Entity {
	
	
	protected Handler handler;
	protected float x,y;
	protected int width,heigth;
	
	protected Rectangle bounds;
	
	//starting position
	public Entity(Handler handler,float x,float y,int width,int heigth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
		this.handler = handler;
		bounds = new Rectangle(0,0,width,heigth);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

}
