package STATES;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Backgroung {

	private BufferedImage image;

	
	public Backgroung(String s) {
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));
		}
		catch(Exception e) {	
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		
		g.drawImage(image, 0, 0,
				640, 480,
				null);
	
	}
	
	
	
	
	
	
}
