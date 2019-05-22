import java.awt.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
public class Object {
	public final int scrollSpeed = 	-3;
	private int gravity = 8;
	private int width;
	private int height;
	private int xCord;
	private int yCord;
	private Rectangle rect;
	private Rectangle feet;
	private Image im;

	public Object(int x, int y) {
		xCord = x;
		yCord = y;
		
	}
	
	
	
	private Image getImage(String str) {
		Image img = null;
		try {
			
			img = ImageIO.read(this.getClass().getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void draw(Graphics g) {
		if(im != null) {
			g.drawImage(im, rect.x, rect.y, rect.width,rect.height, null);
		}
	}

	public void scroll(){
		this.getRect().translate((int) (-scrollSpeed*this.getRect().getWidth()), 0);
		
	}
	public void move(int x, int y) {
		this.getRect().translate(x,y);
		this.getFeet().translate(x,y);
		
	}
	
	public Rectangle getFeet() {
		return this.feet;
	}
	
	public Rectangle getRect() {
		return this.rect;
	}
	
	public boolean collide(Object o) {
		return this.getRect().intersects(o.getRect());
	}



	public  int getY() {
	return 0;
	}	public  int getX() {
		return 0;
	}
	
	

}