
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block {
	private static final int WIDTH=50;
	private static final int HEIGHT=50;
	 private int x,y;
	 private Rectangle rect;
	 private Image img;
	
	 public Block(int x1,int y1) {
		 x=x1;
		 y=y1;
		;
		 this.rect= new Rectangle(x,y,WIDTH,HEIGHT);
		 try {
				img=ImageIO.read(this.getClass().getResource("blocks.png"));
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
}
