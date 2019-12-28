package CREATURE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import IMAGES.Animation;
import IMAGES.Assets;
import LAUNCH.Handler;

public class Player extends Creature {

	private Handler handler;
	
	//Animation
	private Animation animDown;
	private Animation animUp;
	private Animation animRight;
	private Animation animLeft;
	
	public Player(Handler handler,float x, float y) {
		super(	handler,x, y,
				Creature.DEFAULT_CREATURE_HEIGHT,
				Creature.DEFAULT_CREATURE_HEIGHT
			);
		this.handler = handler;
		
		bounds.x = 16;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 64;
		
		//Animations
		animDown = new Animation(500,Assets.player_down);
		animUp = new Animation(500,Assets.player_up);
		animRight = new Animation(500,Assets.player_right);
		animLeft = new Animation(500,Assets.player_left);
	}
	


	@Override
	public void tick() {
		getInput();
		move();
		
		animDown.tick();		
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		
		handler.getCamera().centerOnEntity(this);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),
				(int) (x-handler.getCamera().getxOffset()),
				(int) (y-handler.getCamera().getyOffset()),
				width,
				heigth,
				null);
		
		//	g.setColor(Color.red);
		//	g.fillRect(	(int) (x + bounds.x - handler.getCamera().getxOffset()),
		//			(int) (y + bounds.y - handler.getCamera().getyOffset()),
		//			bounds.width,bounds.height
		//		);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0)
			return animLeft.getCurrentFrame();
		else if(xMove > 0)
			return animRight.getCurrentFrame();
		else if(yMove < 0)
			return animUp.getCurrentFrame();
		else if(yMove > 0)
			return animDown.getCurrentFrame();
		else
			return Assets.player;
	}

	private void getInput() {
	
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().right) 
			xMove = +speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = +speed;
	
	}

}
