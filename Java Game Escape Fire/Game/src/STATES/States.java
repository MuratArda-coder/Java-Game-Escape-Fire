package STATES;

import java.awt.Graphics;

import LAUNCH.Handler;

public abstract class States {

	private static States currentState = null;
	
	public static void setState(States state) {
		currentState = state;
	}
	
	public static States getState() {
		return currentState;
	}
	
	protected Handler handler;
	public States(Handler handler) {
		this.handler = handler;
	}
	
	//CLASS
	public abstract void tick();
	public abstract void render(Graphics g);

}
