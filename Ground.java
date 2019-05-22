import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Ground extends Object{
	private static final int WIDT = 50, HEIGH=50;
	public final int scrollSpeed = -1;
	private Rectangle rect;
	private int x, y;
	private Image img;
	public Ground(int i, int j) {
		super(i,j);
		x=i;
		y=j;
		this.rect = new Rectangle(x, y, WIDT, HEIGH);
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
		return this.rect;
	}public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void scroll() {
		rect.translate(scrollSpeed,0);
		x+=scrollSpeed;
	}
	 public void bScroll() {
		 rect.translate(-scrollSpeed,0);
		 x-=scrollSpeed;
	 }
}