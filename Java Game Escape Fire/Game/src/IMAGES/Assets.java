package IMAGES;

import java.awt.image.BufferedImage;

public class Assets {

	public static final int width = 32;
	public static final int height = 32;
	public static BufferedImage wall,health,fire,player;
	public static BufferedImage line,surface,floor;
	public static BufferedImage exitDoorUp,exitDoorDown;
	
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/resources/sheet.png"));
	
		
		player_down = new BufferedImage[2];
		player_down[0] = sheet.crop(width*4, height*2, width, height);
		player_down[1] = sheet.crop(width*5, height*2, width, height);
		
		player_up = new BufferedImage[2];
		player_up[0] = sheet.crop(width*6, height*2, width, height);
		player_up[1] = sheet.crop(width*7, height*2, width, height);

		player_left = new BufferedImage[2];
		player_left[0] = sheet.crop(width*6, height*3, width, height);
		player_left[1] = sheet.crop(width*7, height*3, width, height);
		
		player_right = new BufferedImage[2];
		player_right[0] = sheet.crop(width*4, height*3, width, height);
		player_right[1] = sheet.crop(width*5, height*3, width, height);
		
		
		wall = sheet.crop(width*3,0,width,height);
		health = sheet.crop(width,height,width,height);
		fire = sheet.crop(width*2,height,width,height);
		player = sheet.crop(width*4, height*2, width, height);
		line = sheet.crop(width, height*2, width, height);
		surface = sheet.crop(width*3, height, width, height);
		floor = sheet.crop(width*2, height*2, width, height);
		
		exitDoorUp = sheet.crop(width*3, height*2, width, height);
		exitDoorDown = sheet.crop(width*3, height*3, width, height);
	}
	
}
