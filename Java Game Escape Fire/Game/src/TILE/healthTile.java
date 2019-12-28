package TILE;

import IMAGES.Assets;

public class healthTile extends Tile {

	public healthTile(int id) {
		super(Assets.health, id);
	}
	public boolean isSolid() {
		return false;
	}

}
