import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bowser extends EnemyObj {
	private Image i;
	Rectangle rect;
	private int x, y;
	private static final int WIDTH=75,HEIGHT=75;
	private BufferedImage myPicture = null;
	public Bowser(int x,int y) {
		super(x,y);
		this.x=x;
		this.y=y;
		this.rect= new Rectangle(x,y,WIDTH,HEIGHT);
		try {
			myPicture= ImageIO.read(this.getClass().getResource("bowser.png"));
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
	//public boolean hit(Mario m,Fireball f) {
	//	if(m.getRect().intersects(f.getrect())) {
	//		return true;

	//}
	//	return false;
	//}

	public void draw(Graphics g,int x,int y) {
		g.drawImage(myPicture, x, y, WIDTH, HEIGHT, null);
	}
	public Rectangle getrect() {
		return rect;
	}
	@Override
	protected void moveRight() {
		x+=1;
	}
	@Override
	protected void moveLeft() {
		x-=1;
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
	public void move(Mario m) {
		{
			while(collides(m)!=true) {
				if(x<800) {
					this.moveRight();
				}
				if(x!=0) {

					this.moveLeft();
				}
			}
		}
	}
	@Override
	public void moveuntilcollide(Mario m) {
		// TODO Auto-generated method stub
		
	}
}