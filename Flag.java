
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Flag extends Object{
	private int x,y;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = 150,HEIGHT=300;
	public final int scrollSpeed = -1;
	private Image img;
	private Rectangle rect;
	public Flag(int x1,int y1) {
		super(x1, y1);
		x=x1;
		y=y1;
		rect = new Rectangle(x, y, WIDTH, HEIGHT);
		try {
			img = ImageIO.read(this.getClass().getResource("flag.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	public Rectangle getRect() {
		return rect;
	}
	public void scroll() {
		rect.translate(scrollSpeed,0);
		x+=scrollSpeed;
	}
	 public void bScroll() {
		 rect.translate(-scrollSpeed,0);
		 x-=scrollSpeed;
	 }
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	}
}
