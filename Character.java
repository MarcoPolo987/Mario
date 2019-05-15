import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Character {
	private Rectangle feet;
	private static final int WIDTH=50,HEIGHT=75;
	private int x,y;
	private Rectangle rect;
	protected int gravity = 8;
	private Image img;
	public Character(int x1,int y1) {
		x=x1;
		feet = new Rectangle(x,y+75,50,1);
		y=y1;
		this.rect= new Rectangle(x,y,WIDTH,HEIGHT);
		//	 try {
		//
		//		 img=ImageIO.read(this.getClass().getResource(".png"));
		//	 } catch (IOException e1) {
		//		  
		//		 e1.printStackTrace();
		//	 }
	}
	public int getX() {
		return this.x; 
	}
	public int getY() {
		return this.y;
	}
	public Rectangle getRect() {
		return this.rect;
	}
	public void move() {
		rect.translate(x,y);
	}
	public boolean collide(Object h) {
		if (rect.intersects(h.getRect())){
			return true;
		}
		return false;
	}
	

	public void move(int c, int r) {
		x=c;
		y=r;
	}

	private Rectangle getFeet() {
		return feet;
	}
	public abstract void fall(ArrayList<Ground> ground);
	//(int)this.getRect().getY()+(int) (-1*(5*10*Math.sin(90))/*time*/+gravity/*+time*time*//2)
	public abstract void draw(Graphics g);
	public boolean stand(Ground g) {

		if (this.rect.intersects(g.getRect())) {

			return true;
		}
		return false;
	}
}