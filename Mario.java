
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mario extends Character{
	private int x; private int y;
	private static final int WIDTH=50,HEIGHT=50;
	private Rectangle rect;
	private static Image spriteSheet;
	private static Image img;
	public Mario(int x, int y) {
		super(x,y);
		//		 try {
//
//			 img=ImageIO.read(this.getClass().getResource(".png"));
//		 } catch (IOException e1) {
//			 // TODO Auto-generated catch block
//			 e1.printStackTrace();
//		 }
		//getImage();
	 }
	 private static Image getImage() {
		 openSpriteSheet();
		 if(img == null)
			 img= openImageFromSpriteSheet(10, 10, 10, 10);
		 return img;
	 }
	 private static void openSpriteSheet() {
			if(spriteSheet==null) {
				try {
					spriteSheet = ImageIO.read(new File("spritesheet(1).png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 protected static Image openImageFromSpriteSheet(int x, int y, int w, int h) {
		 return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);

	 }
	 public Rectangle getRect() {
		 return this.rect;
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
	 public  void jump() {
		 y+=10;
		 //rect.translate(x, y-2);
	 }
	 public  void crouch() {
		 y-=10;
		 //rect.translate(x-2, y-2);
	 }
	 public boolean collide(EnemyObj e) {
		 if (this.rect.intersects(e.getRect())){
			 return true;
		 }
		 return false;
	 }
	 public boolean powerUp(PowerUp p) {
		 if (this.rect.intersects(p.getRect())) {
			 return true;
		 }
		return false;
	 }
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, 64, 64, null);
	}
}
