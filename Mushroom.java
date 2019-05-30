import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Mushroom extends EnemyObj  {
	private Rectangle rect;
	private static final int WIDTH=50,HEIGHT=50;
	private int x,y;
	private Rectangle r;
	private Rectangle rr;
	private Rectangle lr;
	private BufferedImage myPicture = null;
	//static final int D_X=500, D_Y=185, D_W = 120, D_H=100;
	public Mushroom(int x,int y) {
		super(x,y);
		this.y=y;
		this.x=x;
		this.rect= new Rectangle(x,y,WIDTH,HEIGHT);
		this.r= new Rectangle(x,y-5,WIDTH,5);
		lr = new Rectangle(this.x,this.y,5, HEIGHT-2);
		rr = new Rectangle(this.x+45,this.y,5, HEIGHT-2);
		try {
			myPicture = ImageIO.read(this.getClass().getResource("goomba.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public boolean collides(Mario m) {
		if(m.getRect().intersects(rect)) {
			return true;
		}
		return false;
		
	}
	public boolean sideCollide(ArrayList<Object> b) {
		for(int i = 0; i < b.size(); i++) {
		if(lr.intersects(b.get(i).getRect())||rr.intersects(b.get(i).getRect())) {
			return true;
		}
			
		}
		return false;
	}
	public boolean enemycoll(Mario m) {
		if(m.getSpecR().intersects(r)) {
			return true;
		}
		return false;
		
	}
	public Rectangle getspecialrect() {
		return r;
	}
	private boolean t=false;
	public  void move(Mario m, ArrayList<Object> b, Lives life) {
		if(!collides(m)) {
			if(t && sideCollide(b)==false) {
				moveRight();
				for(int i = 0; i < b.size(); i++) {
					if(b.get(i).getRect().intersects(this.rect)) {
						t=false;
					}
				}

					
				
			}
			else {
				moveLeft();
				if(b.get(0).getX()== this.x) {
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
	public void remove() {
		r.translate(-10000,-10000);
		x-=10000;
		y-=10000;
		rect.translate(-10000,-10000);
	}
	public  void moveLeft() {
		rect.translate(-2,0);
		r.translate(-2,0);
		lr.translate(-2,0);
		rr.translate(-2,0);
		x-=2;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}



	public Rectangle getrect() {
		return rect;
	}
//	private static Image getImage() {
	//	if( MushroomImage==  null) {
		//	MushroomImage = openImageFromSpriteSheet(D_X, D_Y, D_W, D_H);
	//	}
	//	return MushroomImage;
	//}
	public void draw(Graphics g) {
		g.drawImage(myPicture, x, y, WIDTH, HEIGHT, null);
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
		// TODO Auto-generated method stub
		
	}

}