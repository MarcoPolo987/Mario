import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Pipe extends Object {
	private Rectangle enter;

	public Pipe(int w, int h, int x, int y, String str) {
		super(w, h, x, y, str);
		enter = new Rectangle(w,1,x,y);
	}
	
	public boolean checkEntry(Character c) {
		if(this.getEntry().intersects(c.getRect())&&c.isCrouch == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void move(int x,int y) {
		super.move(x, y);
		this.getEntry().translate(x,y);
	}
	
	public Rectangle getEntry() {
		return this.enter;
	}


}
