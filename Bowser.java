import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bowser extends EnemyObj {
	Rectangle rect;
	private static final int WIDTH=50,HEIGHT=50;
	private BufferedImage myPicture = null;
	private int x=0, y=0;
	public Bowser(int x,int y) {
		super(x,y);
		this.y=y;
		this.rect= new Rectangle(x,y,WIDTH,HEIGHT);
		try {
			myPicture= ImageIO.read(this.getClass().getResource("download.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
}
public boolean collides(Mario m) {
	if(m.getRect().intersects(rect)) {
		return true;
	}
	return false;
	
}
public int getX() {
	return x;
}
public int getY() {
	return y;
}
private boolean t=false;
public  void move(Mario m) {
	if(t) {
		moveRight();
		if(x>800) {
			t=false;
		}
	}
	else {
		moveLeft();
	if(x<0) {
		t=true;
	}
}
}
public  void moveRight() {
	//rect.translate(x+1,y);
	x+=1;
	//System.out.println(x);
	}
	public  void moveLeft() {
		//rect.translate(x-1,y+1);
		x-=1;
	}


public void draw(Graphics g) {
	g.drawImage(myPicture, x, y, WIDTH, HEIGHT, null);
}
public Rectangle getrect() {
	return rect;
}
	

}
