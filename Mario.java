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
	private Rectangle lr;
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
		lr = new Rectangle(this.x,this.y,WIDTH-45, HEIGHT- 10);
		rr = new Rectangle(this.x+45,this.y,WIDTH-45, HEIGHT- 10);
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
	
	public boolean sideCollide(ArrayList<Block> b) {
		for(int i = 0; i < b.size(); i++) {
		if(lr.intersects(b.get(i).getRect())||rr.intersects(b.get(i).getRect())) {
			return true;
		}
			
		}
		return false;
	}
	
	public  void moveRight() {
		x+=1;
		rect.translate(1, 0);
		rr.translate(1,0);
		lr.translate(1,0);
	}
	public  void moveLeft() {
		x-=1;
		rect.translate(-1, 0);
		rr.translate(-1,0);
		lr.translate(-1,0);
	}
	public  void jump() {
		y-=200;
		initY=y;
		
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
			System.out.println(rect.getY());
			System.out.println(y);
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
