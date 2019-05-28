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
	private boolean up, down, left, right;
	private boolean onGround;
	private Rectangle rect;
	private Rectangle rr;
	private Object obj;
	private Rectangle lr;
	private static final int S = 1;
	private Rectangle br;
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
		rect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		lr = new Rectangle(this.x,this.y,5, HEIGHT-2);
		rr = new Rectangle(this.x+45,this.y,5, HEIGHT-2);
		br = new Rectangle(this.x,this.y+HEIGHT,WIDTH, 5);
		try {
			img=ImageIO.read(this.getClass().getResource("sprite.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public Rectangle getRect() {
		return rect;
	}
	public Rectangle getSpecR() {
		return br;
	}
	
	public boolean stand(Ground g) {
		return super.stand(g);
	}

	public boolean sideCollide(ArrayList<Object> b) {
		for(int i = 0; i < b.size(); i++) {
			if(lr.intersects(b.get(i).getRect())) {
				moveRight();
				return true;
			}
			if(rr.intersects(b.get(i).getRect())) {
				moveLeft();
				return true;
			}
		}
		return false;
	}
	public Object getO() {
		return obj;
	}
	public  void moveRight() {
		x+=S;
		rect.translate(S, 0);
		br.translate(S, 0);
		rr.translate(S,0);
		lr.translate(S,0);
	}
	public  void moveLeft() {
		x-=S;
		rect.translate(-S, 0);
		br.translate(-S, 0);
		rr.translate(-S,0);
		lr.translate(-S,0);
	}
	public  void jump() {
		y-=200;
		initY=y;
		br.translate(0, -200);
		rect.translate(0, -200);
		rr.translate(0,-200);
		lr.translate(0,-200);
	}
	public  void crouch() {
	}
	
	public int getX() {
		return this.x;
	}
	public boolean collide(Object e) {
		if (e.getRect().intersects(rect)){
			return true;
		}
		return false;
	}
	
	public boolean isSafe(ArrayList<Object> o) {
		//int c = 0;
		for(Object g:o) {
			//System.out.println(collide(g));
			if(collide(g)) {
				initY=y;
				time=0;
				return false;
				
			}
		}
		
		return true;
	}
	public void move(ArrayList<Object> o) {
		if(isSafe(o)) {	
			time+=.01;
			int tempY = y;
			y=initY+(int) (1*(20*10*Math.sin(90))*time+gravity+time*time/2);
			rect.translate(0, y-tempY);
			br.translate(0, y-tempY);
			rr.translate(0, y-tempY);
			lr.translate(0, y-tempY);
			System.out.println(rect.getY());
			System.out.println(y);
		}
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	}
	public void fall(ArrayList<Ground> ground) {
	}
	public void set(int i, int j) {
		x=i;
		y=j;
		initX=x;
		initY=y;
		rect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		lr = new Rectangle(this.x,this.y,5, HEIGHT-2);
		rr = new Rectangle(this.x+45,this.y,5, HEIGHT-2);
		br = new Rectangle(this.x,this.y+50,WIDTH, 5);
	}
}
