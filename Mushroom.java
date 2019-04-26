import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Mushroom extends EnemyObj  {
	private Image i;
	Rectangle rect;
	private int w = 50;
	private int h = 50;
	private BufferedImage myPicture = null;
	public Mushroom(int x,int y) {
		super(x,y);
	}
	

}
