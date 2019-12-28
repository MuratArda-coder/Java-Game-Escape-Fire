package DISPLAY;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private int width,height;
	private String title;
	private int scale;
	
	private Canvas canvas;
	
	
	public Display(String title,int width,int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		scale = 2;
		createDiplay();
	}
	public JFrame getframe() {
		return frame;
	}

	private void createDiplay() {
		frame = new JFrame(title);
		frame.setSize(width*scale,height*scale);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width*scale,height*scale));
		canvas.setMaximumSize(new Dimension(width*scale,height*scale));
		canvas.setMinimumSize(new Dimension(width*scale,height*scale));
		frame.add(canvas);
		frame.pack();
		canvas.setFocusable(false);
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	
	
}
