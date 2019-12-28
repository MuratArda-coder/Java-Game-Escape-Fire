package LAUNCH;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import DISPLAY.Display;
import IMAGES.Assets;
import IMAGES.Camera;
import INPUT.KeyManager;
import STATES.EndingState;
import STATES.GameState;
import STATES.MenuState;
import STATES.States;

public class Game implements Runnable{

	protected static Display display;
	private int width,height;
	private String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	public static ArrayList<States> states = new ArrayList<States>();
	private States menuState;//0
	private States gameState;//1
	private States endingState;//2
	public static int stateNum = 0 ;
	
	public static void setstateNum(int Num) {
		stateNum = Num;
	}
	
	//private SpriteSheet sheet;
	
	public Display getDisplay() {
		return display;
	}
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private Camera camera;
	
	//Handler
	private Handler handler;
	
	
	public Game(String title,int width,int height) {
		this.width=width;
		this.height=height;
		this.title=title;
		keyManager = new KeyManager();
	}
	
	
	
	private void init() {
		display = new Display(title,width,height);
		//testImage = ImageLoader.loadImage("/resources/Pictures.png");
		//sheet = new SpriteSheet(testImage);
		Assets.init();
		//y = height+120;
		//x = 0;

		handler = new Handler(this);
		camera = new Camera(handler,0,0);
		
		display.getFrame().addKeyListener(keyManager);
		
		menuState = new MenuState(handler);
		states.add(menuState);
		gameState = new GameState(handler);
		states.add(gameState);
		endingState = new EndingState(handler);
		states.add(endingState);
		
		States.setState(states.get(stateNum));
	}

	//private int y;
	//private int x;
	private void tick() {
		//y=y-1;
		//x=x+2;
		keyManager.tick();
		States.setState(states.get(stateNum));
		if(States.getState() != null) {
			States.getState().tick();
		}
		
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		States.setState(states.get(stateNum));
		if(States.getState() != null) {
			States.getState().render(g);
		}
		
		//Draw Here!

		/* 
		 * g.fillRect(0,0,width,height);
		 * g.clearRect(10, 10, width-15, height-15);
		 * 
		 * 
		 * g.setColor(Color.red);
		 * g.drawRect(width/10,height/10,width/2,height/2);
		 * 
		 * g.setColor(Color.blue);
		 * g.fillRect(width/2,height/2,width/2,height/2);
		 * 
		 */
		
		//g.drawImage(testImage,20,20,null);
		
		/*
		 * g.fillRect(0, 0, width*2, height*2);
		 * g.drawImage(sheet.crop(0, 0, 60, 120),5,5,null);
		 * 
		 */
		
		/*
		 * g.drawImage(Assets.right,0,0,null);
		 * g.drawImage(Assets.explosion,0,120,null);
		 * 
		 */
		
		//g.drawImage(Assets.singleMotor,x,y,null);
		
		
		//End Draw!
		bs.show();
		g.dispose();
	}
	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 100000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now-lastTime) / timePerTick;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public synchronized void start() {
		if (running)
				return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running = false;			
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
}
