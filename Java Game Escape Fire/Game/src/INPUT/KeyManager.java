package INPUT;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right,enter,esc;
	public int currentChoice=0;
	public boolean ifRelease;
	
	public boolean continueGame;
	public KeyManager() {
		keys = new boolean[256];
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	private int length;
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		ifRelease = false;
		if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = length - 1;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == length) {
				currentChoice = 0;
			}	
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			continueGame = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		ifRelease = true;
		continueGame = false;
	}

	
	public void tick() {
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];;
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];;
		left =  keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];;
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		enter = keys[KeyEvent.VK_ENTER] || keys[KeyEvent.VK_E];
		esc = keys[KeyEvent.VK_ESCAPE];
	}

}
