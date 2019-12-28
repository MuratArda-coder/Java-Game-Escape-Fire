package STATES;

import java.awt.Graphics;

import CREATURE.Player;
import DUNGEON.Dungeon;
import LAUNCH.Handler;

public class GameState extends States {

	private Player player;
	public static final int width = 38;
	public static final int height = 40;
	
	private Dungeon dungeon;
	
	public GameState(Handler handler) {
		super(handler);
		dungeon = new Dungeon(handler,"graphics/resources/dungeon1.txt");
		handler.setDungeon(dungeon);
		player = new Player(handler,280,350);
	
		//game.getCamera().move(0,0);
	}
	public boolean flag=false;
	@Override
	public void tick() {
		
		if(handler.getKeyManager().ifRelease) {
			flag = true;
		}
		
		
		if(handler.getKeyManager().esc && flag) {
			EndingState.getResult("Game Paused");
			Handler.setstateNum(2);
			flag = false;
		}
		dungeon.tick();
		player.tick();
		
		handler.getCamera().move(1,1);
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0,0,640,480);
		//g.drawImage(Assets.surface,0,0,64,64,null);
		dungeon.render(g);
		player.render(g);
	}

}
