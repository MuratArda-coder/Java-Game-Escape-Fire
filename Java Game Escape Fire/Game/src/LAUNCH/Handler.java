package LAUNCH;

import DUNGEON.Dungeon;
import IMAGES.Camera;
import INPUT.KeyManager;

public class Handler {

	private Game game;
	private Dungeon dungeon;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public Camera getCamera() {
		return game.getCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Dungeon getDungeon() {
		return dungeon;
	}

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	public static void setstateNum(int Num) {
		Game.stateNum = Num;
	}
	
}
