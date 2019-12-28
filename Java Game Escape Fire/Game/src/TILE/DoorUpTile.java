package TILE;

import IMAGES.Assets;
import LAUNCH.Handler;
import STATES.EndingState;

public class DoorUpTile extends Tile {

	public DoorUpTile(int id) {
		super(Assets.exitDoorUp,id);
	}
	public boolean isSolid() {
		EndingState.getResult("You Won!!!");
		Handler.setstateNum(2);
		return true;
	}

}
