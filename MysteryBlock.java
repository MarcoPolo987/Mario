import java.awt.Graphics;
import java.awt.*;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MysteryBlock{
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	private int x,y;
	private Image img;
	private Rectangle rect;
	public MysteryBlock(int i, int j) {
		x=i;
		y=j;
		rect = new Rectangle(x, y);
		try {
			img = ImageIO.read(this.getClass().getResource("mystery.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	}
}
