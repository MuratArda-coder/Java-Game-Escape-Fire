package TILE;

import IMAGES.Assets;

public class Line extends Tile {

	public Line(int id) {
		super(Assets.line,id);
	}
	public boolean isSolid() {
		return true;
	}
	
}
