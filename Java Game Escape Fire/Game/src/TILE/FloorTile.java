package TILE;

import IMAGES.Assets;

public class FloorTile extends Tile{

	public FloorTile(int id) {
		super(Assets.floor,id);
	}
	public boolean isSolid() {
		return false;
	}
	
}
