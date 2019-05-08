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
	// private static Image getImage() {
	//	 openSpriteSheet();
	//	 if(img == null)
	//		 img= openImageFromSpriteSheet(50, 50, 50, 50);
	//	 return img;
	// }
	/*private static void openSpriteSheet() {
			if(spriteSheet==null) {
				try {
					spriteSheet = ImageIO.read(new File("spritesheet.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 protected static Image openImageFromSpriteSheet(int x, int y, int w, int h) {
		 return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
	 }
	 */
	public boolean collides(Mario m) {
		if(m.getRect().intersects(rect)) {
			return true;
		}
		return false;
		
	}
	public void moveuntilcollide(Mario m) {
		while(collides(m)!=true) {
		if(x<800) {
		
			moveRight();
		}
			
		
		if(x!=0) {
			
			moveLeft();
			
		}
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(i, x, y, w, h, null);
	}
	public Rectangle getrect() {
		return rect;
	}
	 public void move() {
		 //rect.translate(x,y);
	 }
	 public  void moveRight() {
		 //rect.translate(x+1,y);
		 x+=10;
		 System.out.println(x);
	 }
	 public  void moveLeft() {
		 //rect.translate(x-1,y+1);
		 x-=10;
	 }

}
