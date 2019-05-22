import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mushroom extends EnemyObj  {
	Rectangle rect;
	private static final int WIDTH=50,HEIGHT=50;
	private int x,y;
	private BufferedImage myPicture = null;
	//static final int D_X=500, D_Y=185, D_W = 120, D_H=100;
	public Mushroom(int x,int y) {
		super(x,y);
		this.y=y;
		this.x=x;
		this.rect= new Rectangle(x,y,WIDTH,HEIGHT);
		try {
			myPicture = ImageIO.read(this.getClass().getResource("goomba.jpg"));
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
	private boolean t=false;
	public  void move(Mario m) {
		if(!collides(m)) {
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
	@Override
	public void moveuntilcollide(Mario m) {
		// TODO Auto-generated method stub
		
	}

}