import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class EnemyObj {
	private int x,y;
	private Image i;
	Rectangle rect;
	private int w = 50;
	private int h = 50;
	private BufferedImage myPicture = null;

	public EnemyObj(int r,int c) {
		x=r;
		y=c;
		this.rect= new Rectangle(x,y,w,h);
		
	}
	public boolean collides(Mario m) {
		if(m.getrect().intersects(rect)) {
			return true;
		}
		return false;
		
	}
	public void draw(Graphics g) {
		g.drawImage(i, x, y, w, h, null);
	}
	public Rectangle getrect() {
		return rect;
	}

}
