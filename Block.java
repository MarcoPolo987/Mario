
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block {
	public final int scrollSpeed = -1;
	private static final int WIDTH=50;
	private static final int HEIGHT=50;
	 private int x,y;
	 private Rectangle rect;
	 private Image img;
	
	 public Block(int x1,int y1) {
		 x=x1;
		 y=y1;
		 this.rect= new Rectangle(x,y,WIDTH,HEIGHT);
		 try {
				img=ImageIO.read(this.getClass().getResource("Brick.jpg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	 }
	 public void draw(Graphics g) {
		 g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	 }
	 public Rectangle getBlock() {
		return this.rect;
	 }
	 
	 public void scroll() {
		 this.rect.translate(x+scrollSpeed,y);
		 x+=scrollSpeed;
	 }
	 public void bScroll() {
		 this.rect.translate(x-scrollSpeed,y);
		 x-=scrollSpeed;
	 }
}
