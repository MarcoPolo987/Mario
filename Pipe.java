import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Pipe extends Object {
	private Rectangle enter;

	public Pipe(int w, int h, int x, int y, String str) {
		super(w, h, x, y, str);
		enter = new Rectangle(w,1,x,y);
	}
	
	public void checkEntry(Character c) {
		return this.getEntry().intersects(c.getRect());
	}
	
	public Rectangle getEntry() {
		return this.enter;
	}


}
