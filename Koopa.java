import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Koopa extends EnemyObj {
	private int x=0, y=0;
	Rectangle rect;
	Rectangle r;
	private Rectangle lr;
	private Rectangle rr;
	private static final int WIDTH=50,HEIGHT=50;
	private BufferedImage myPicture = null;

	public Koopa(int x,int y) {
		super(x, y);
		this.x=x;
		this.y=y;
		this.rect= new Rectangle(x,y,WIDTH, HEIGHT);
		lr = new Rectangle(this.x,this.y,5, HEIGHT-2);
		rr = new Rectangle(this.x+45,this.y,5, HEIGHT-2);
		this.r= new Rectangle(x,y-5,WIDTH,5);
		
		try {
			myPicture= ImageIO.read(this.getClass().getResource("koopa.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Rectangle getR() {
		return rr;
	}
	public Rectangle getL() {
		return lr;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean sideCollide(ArrayList<Object> b) {
		for(int i = 0; i < b.size(); i++) {
		if(lr.intersects(b.get(i).getRect())||rr.intersects(b.get(i).getRect())) {
			return true;
		}
			
		}
		return false;
	}
	public void remove() {
		r.translate(-10000,-10000);
		x-=10000;
		y-=10000;
		rect.translate(-10000,-10000);
		}
	public boolean collides(Mario m) {
		if(m.getRect().intersects(rect)) {
			return true;
		}
		
		return false;
		
	} 
	public boolean enemycoll(Mario m) {
		if(m.getSpecR().intersects(r)) {
			return true;
		}
		return false;
		
	}

	public void draw(Graphics g) {
		g.drawImage(myPicture, x, y, WIDTH, HEIGHT, null);
	}
	public Rectangle getrect() {
		return rect;

	}
	
	public Rectangle getspecialrect() {
		return r;
	}
	private boolean t=false;
	public  void move(Mario m, ArrayList<Object> o, Lives life) {
		if(!collides(m)) {
			if(t && sideCollide(o)==false) {
				moveRight();
				for(int i = 0; i < o.size(); i++) {
					if(o.get(i).getRect().intersects(this.rect)) {
						t=false;
					}
				}

					
				
			}
			else {
				moveLeft();
				if(o.get(0).getX()== this.x) {
					t=true;
				}
			}
		}
		else {
			life.lose1();
			m.jump();
		}
	}
	
	
	public  void moveRight() {
		rect.translate(2,0);
		r.translate(2,0);
		lr.translate(2,0);
		rr.translate(2,0);
		x+=2;
	//System.out.println(x);
	}
	public  void moveLeft() {
		rect.translate(-2,0);
		r.translate(-2,0);
		lr.translate(-2,0);
		rr.translate(-2,0);
		x-=2;
	}
	public void set(int i, int j) {
		x=i;
		y=j;
		rect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		r= new Rectangle(x,y-5,WIDTH,5);
		lr = new Rectangle(this.x,this.y,5, HEIGHT-2);
		rr = new Rectangle(this.x+45,this.y,5, HEIGHT-2);
	}
	@Override
	public void moveuntilcollide(Mario m) {
	}




}
