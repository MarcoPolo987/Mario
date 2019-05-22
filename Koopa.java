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
	private static final int WIDTH=50,HEIGHT=50;
	private BufferedImage myPicture = null;

	public Koopa(int x,int y) {
		super(x, y);
		this.x=x;
		this.y=y;
		this.rect= new Rectangle(x,y,WIDTH, HEIGHT);
		
		try {
			myPicture= ImageIO.read(this.getClass().getResource("images.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean collides(Mario m) {
		if(m.getRect().intersects(rect)) {
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
	private boolean t=false;
	public  void move(Mario m) {
		System.out.println(collides(m));
		if(collides(m)!=true) {
			if(t) {
				moveRight();
				if(x>800) {
					t=false;
				}
			}
			else {
				moveLeft();
				if(x<0) {
					t=true;
				}
			}
		}
	}
	public  void moveRight() {
		rect.translate(1,0);
		x+=1;
	//System.out.println(x);
	}
	public  void moveLeft() {
		rect.translate(-1,0);
		x-=1;
	}
	@Override
	public void moveuntilcollide(Mario m) {
		{
			System.out.println(collides(m));
			while(collides(m)!=true) {
				while(x<800) {
					this.moveRight();
				}
				while(x>0) {
					this.moveLeft();
				}
			}
		}
	}




}