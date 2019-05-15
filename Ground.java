
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Ground {
	private static final int WIDT = 50, HEIGH=50;
	private int scrollSpeed= -1;
	private Rectangle rect;
	private int x, y;
	private Image img;
	public Ground(int i, int j) {
		x=i;
		y=j;
		rect = new Rectangle(x, y, WIDT, HEIGH);
		try {
			img = ImageIO.read(this.getClass().getResource("ground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDT, HEIGH, null);

	}
	public Rectangle getRect() {
		return rect;
	}
	public void scroll() {
		this.rect.translate(x+scrollSpeed,y);
		x+=scrollSpeed;
	}
	 public void bScroll() {
		 this.rect.translate(x-scrollSpeed,y);
		 x-=scrollSpeed;
	 }
	 
	 public int getX() {
		 return this.x;
	 }
} 
