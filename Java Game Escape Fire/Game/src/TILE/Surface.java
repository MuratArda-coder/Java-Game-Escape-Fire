package TILE;

import IMAGES.Assets;

public class Surface extends Tile {

	public Surface(int id) {
		super(Assets.surface,id);
	}
	public boolean isSolid() {
		return false;
	}
	
}
