import java.awt.*;
import java.io.IOException;
import java.math.*;
import javax.imageio.ImageIO;;
public class Projectile {
	private static final int WIDT = 50, HEIGH=25;
	private int gravity = 0;
	private Image img;
	private int x,y, initX, initY;
	private Rectangle rect;
	int angle, speed;
	private boolean hit = false;
	private double time;
	public Projectile(int i, int j, int angl, int speed) {
		this.x=i;
		initX=i;
		this.speed=speed;
		angle=angl;
		this.y=j;
		initY=j;
		rect = new Rectangle(x, y, WIDT, HEIGH);
		img = getImg();
	}
	public Image getImg() {
		try {
			img = ImageIO.read(this.getClass().getResource("kcms0p.png"));
			return img;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDT, HEIGH, null);
		
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setAngle(int ang) {
		angle = ang;
		angle = (int) (angle*Math.PI/180);
	}
	public void setSpeed(int sped) {
		sped = speed;
	}
	public void fire(Target t) {
		

		System.out.println("hit");
	}
	private void checkHit(Target t) {
		if (t.getRect().intersects(rect))
			hit=true;
	}
	public void move() {
		time+=.01;
		x=initX+(int) ((speed*10*Math.cos(angle))*time);
		y=initY+(int) (-1*(speed*10*Math.sin(angle))*time+gravity+time*time/2);
	}
}
