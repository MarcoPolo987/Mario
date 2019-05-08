import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Koopa extends EnemyObj {

	Rectangle rect;
	private int w = 50;
	private int h = 50;
	private BufferedImage myPicture = null;

	public Koopa(int x,int y) {
		super(x,y);
		this.rect= new Rectangle(x,y,w,h);
		
		try {
			myPicture= ImageIO.read(this.getClass().getResource("images.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public boolean collides(Mario m) {
		if(m.getRect().intersects(rect)) {
			return true;
		}
		return false;
		
	}
	
	public void draw(Graphics g,int x,int y) {
		g.drawImage(myPicture, x, y, w, h, null);
	}
	public Rectangle getrect() {
		return rect;
		
	}
	


}
