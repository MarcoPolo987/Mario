import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
public class Mario extends Character{
	private int x; private int y;
	private int initX, initY;
	private static final int WIDTH=50,HEIGHT=75;
	private Rectangle rect;
	private static Image spriteSheet;
	private static Image img;
	private double time;
	private int speed = 10;
	public Mario(int x, int y) {
		super(x,y);
		this.x=x;
		this.y=y;
		initX=x;
		initY=y;
		rect = new Rectangle(x, y, WIDTH, HEIGHT);
		try {

			img=ImageIO.read(this.getClass().getResource("sprite.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public Rectangle getRect() {
		return rect;
	}
	
	public boolean stand(Ground g) {
		return super.stand(g);
	}
	@Override
	public void move(int c, int j) {
		x=c;
		y=j;
	}
	public  void moveRight() {
		x+=5;
		rect.translate(5, 0);
	}
	public  void moveLeft() {
		x-=5;
		rect.translate(-5, 0);
	}
	public  void jump() {
		y-=75;
		initY-=75;
		rect.translate(0, -75);
	}
	public  void crouch() {
	}
	
	public int getX() {
		return this.x;
	}
	public boolean collide(Object e) {
		if (this.rect.intersects(e.getRect())){
			return true;
		}
		
		return false;
	}
	public boolean isSafe(ArrayList<Object> o) {
		//int c = 0;
		for(Object g:o) {
			System.out.println(collide(g));
			//System.out.println(rect.getY());
			//System.out.println(rect.getX());
			if(collide(g)) {
				time=0;
				return false;
				
			}
		}
		return true;
	}
	public void move(ArrayList<Object> o) {
		if(isSafe(o)) {	
			time+=.01;
			y=initY+(int) (1*(20*10*Math.sin(90))*time+gravity+time*time/2);
			rect.translate(0, initY+(int) (1*(20*10*Math.sin(90))*time+gravity+time*time/2));
		}
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	}
	private boolean t = true;
	public void fall(ArrayList<Ground> ground) {
		
		while(t) {
			time+=.01;
			move();
			for(int i=0; i<ground.size(); i++)
				System.out.println(ground.get(i).getRect().intersects(rect));
		}
	}
}
