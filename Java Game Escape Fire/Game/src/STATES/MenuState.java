package STATES;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import LAUNCH.Game;
import LAUNCH.Handler;



public class MenuState extends States{

	private int currentChoice = 0;
	
	private String[] options = {
			"Enter to Play Game",
			"Options",
			"Exit"
		};

	private Font font;
	private Backgroung bg;
	
	public MenuState(Handler handler) {
		super(handler);
		try {
			bg = new Backgroung("/resources/MENU.png");
			font = new Font("Arial", Font.BOLD, 20);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		handler.getKeyManager().setLength(options.length);
	}
	private boolean flag = true;
	@Override
	public void tick() {
		currentChoice = handler.getKeyManager().currentChoice;
		if(currentChoice==-2 && handler.getKeyManager().enter) {
			currentChoice=0;
		}
		else if(handler.getKeyManager().enter) {
			select();
		}
		else if(!handler.getKeyManager().enter) {
			flag = true;
		}
	}
	
	@Override
	public void render(Graphics g) {
		bg.draw(g);
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.white);
				g.drawString(options[i], 225, 250 + i * 30);
			}
			else {
				g.setColor(Color.RED);
				g.drawString(options[i], 225, 250 + i * 30);
			}		
		}
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			Game.setstateNum(1);
		}
		if(currentChoice == 1) {
			if(flag) {
				JOptionPane.showMessageDialog(null,
											"You have to find exit door to escape \n"+
											"You have to stay away from the fire,It is Dangerous for you\n"+
											"W:Go Straight\n"+
											"S:Go Back\n"+
											"D: Go Right\n"+		
											"A: Go Left\n",
											"Options",
											JOptionPane.INFORMATION_MESSAGE
											);
				flag = false;
				currentChoice = -2;
			}
			
		}
		if(currentChoice == 2) {
			System.exit(0);
		}	
	}

}
