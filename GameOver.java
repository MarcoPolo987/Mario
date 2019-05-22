import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
public class GameOver {
	private int x,y;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private Image img;
	public GameOver(int x1,int y1) {
		x=x1;
		y=y1;
		try {
			img = ImageIO.read(this.getClass().getResource("gameOver.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	}
}
