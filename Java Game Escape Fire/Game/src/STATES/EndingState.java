package STATES;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import LAUNCH.Game;
import LAUNCH.Handler;

public class EndingState extends States {

	private Backgroung bg;
	private static String result;
	
	public static void getResult(String resultx) {
		result = resultx;
	}
	
	public EndingState(Handler handler) {
		super(handler);
		try {
			bg = new Backgroung("/resources/ENDING.png");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean flag = false;
	
	@Override
	public void tick() {
		if(handler.getKeyManager().enter) {
			handler.getKeyManager().currentChoice=-2;
			Game.states.set(1,new GameState(handler));
			Handler.setstateNum(0);
		}
		
		if(handler.getKeyManager().ifRelease) {
			flag = true;
		}
		else if(flag && handler.getKeyManager().continueGame) {
			Handler.setstateNum(1);
			flag = false;
		}
	}

	@Override
	public void render(Graphics g) {
		bg.draw(g);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.setColor(Color.red);
		g.drawString(result, 75, 50);
	}

}
