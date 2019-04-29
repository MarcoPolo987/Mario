import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Object {
	public final int scrollSpeed = 	3;
	private int width;
	private int height;
	private int xCord;
	private int yCord;
	private Rectangle rect;
	private Image im;

	public Object(int w, int h, int x, int y, String str) {
		width = w;
		height = h;
		xCord = x;
		yCord = y;
		rect = new Rectangle(x,y,w,h);
		im = getImage(str);
		
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
	
	public Rectangle getRect() {
		return this.rect;
	}
	

}
