package TILE;

import IMAGES.Assets;
import LAUNCH.Handler;
import STATES.EndingState;

public class fireTile extends Tile {

	public fireTile(int id) {
		super(Assets.fire, id);
	}
	public boolean isSolid() {
		EndingState.getResult("You Lost!!!");
		Handler.setstateNum(2);
		return true;
	}

}
