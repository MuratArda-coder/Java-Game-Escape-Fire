package IMAGES;

import ENTITIES.Entity;
import LAUNCH.Handler;

public class Camera {
	
	//Starting Points
	private float xOffset,yOffset;
	private Handler handler;
	
	public Camera(Handler handler,float xOffset,float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
		this.handler = handler;
	}
	
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth()  + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight()  + e.getHeigth() / 2;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
	
	
	
}
