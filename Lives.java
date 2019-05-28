import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Lives {
	private int x,y;
	private int lives = 3;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = 50,HEIGHT = 50;
	private Image img;
	public Lives(int x1,int y1) {
		x=x1;
		y=y1;
		try {
			img = ImageIO.read(this.getClass().getResource("heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	public int getLives() {
		return lives;
	}
	public void lose1() {
		if(lives>0)
			lives--;
	}
	public void set(int i) {
		lives = i;
	}
	public void draw(Graphics g) {
		for(int i=0; i<lives; i++) {
			g.drawImage(img, x+50*i, y, WIDTH, HEIGHT, null);
		}
	}
}