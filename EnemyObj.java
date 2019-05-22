import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class EnemyObj {
	private int x,y;
	private Image i;
	Rectangle rect;
	private int w = 50;
	private int h = 50;
	private BufferedImage myPicture = null;
	private static Image spriteSheet;
	private static Image img;

	public EnemyObj(int r,int c) {
		this.i=i;
		x=r;
		y=c;
		this.rect= new Rectangle(x,y,w,h);
		
	}
	public boolean collides(Mario m) {
		if(m.getRect().intersects(rect)) {
			return true;
		}
		return false;
		
	}
	public abstract void moveuntilcollide(Mario m);
	protected abstract void moveRight();
	protected abstract void moveLeft();
	public void draw(Graphics g) {
		g.drawImage(i, x, y, w, h, null);
	}
	public Rectangle getRect() {
		return rect;
	}
	public abstract int getX();
	public abstract int getY();
	 public void move() {
		 //rect.translate(x,y);
	 }
//	 public  void moveRight() {
//		 //rect.translate(x+1,y);
//		 x+=10;
//		 System.out.println(x);
//	 }
//	 public  void moveLeft() {
//		 //rect.translate(x-1,y+1);
//		 x-=10;
//	 }

}