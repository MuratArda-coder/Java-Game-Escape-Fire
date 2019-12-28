package TILE;

import IMAGES.Assets;
import LAUNCH.Handler;
import STATES.EndingState;

public class DoorDownTile extends Tile {

	public DoorDownTile(int id) {
		super(Assets.exitDoorDown,id);
	}
	public boolean isSolid() {
		EndingState.getResult("You Won!!!");
		Handler.setstateNum(2);
		return true;
	}
	
}
