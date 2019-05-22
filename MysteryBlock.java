import java.awt.Graphics;
import java.awt.*;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MysteryBlock extends Object{
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	private int x,y;
	public final int scrollSpeed = -1;
	private Image img;
	private Rectangle rect;
	public MysteryBlock(int i, int j) {
		super(i, j);
		x=i;
		y=j;
		rect = new Rectangle(x, y, WIDTH, HEIGHT);
		try {
			img = ImageIO.read(this.getClass().getResource("mystery.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	}
	public Rectangle getRect() {
		return this.rect;
	}
	public void scroll() {
		this.rect.translate(scrollSpeed,0);
		x+=scrollSpeed;
	}
	 public void bScroll() {
		 this.rect.translate(-scrollSpeed,0);
		 x-=scrollSpeed;
	 }
}
