import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bowser extends EnemyObj {
	private Image i;
	Rectangle rect;
	private int w = 50;
	private int h = 50;
	private BufferedImage myPicture = null;
	public Bowser(int x,int y) {
		super(x,y);
		this.rect= new Rectangle(x,y,w,h);
	
}
public boolean collides(Mario m) {
	if(m.getRect().intersects(rect)) {
		return true;
	}
	return false;
	
}
//public boolean hit(Mario m,Fireball f) {
//	if(m.getRect().intersects(f.getrect())) {
//		return true;
	
//}
//	return false;
//}

public void draw(Graphics g,int x,int y) {
	g.drawImage(i, x, y, w, h, null);
}
public Rectangle getrect() {
	return rect;
}
	

}
