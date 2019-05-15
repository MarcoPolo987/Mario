import java.awt.Color;
import java.awt.Graphics;

public class Obstacle {
	int x, y, xSpeed;
	GraphicsPanel host;
	public Obstacle(GraphicsPanel host){
		this.host = host;
		y=host.getHeight()-100;
		xSpeed = -10;
		x = host.getWidth()+25;
		
	}
	public void tick() {
		x+=xSpeed;
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x-25, y-75, 50, 200);
	}
}
