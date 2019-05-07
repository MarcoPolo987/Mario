
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
		initX=x;
		initY=y;
		rect = new Rectangle(x, y, WIDTH, HEIGHT);
		try {

			img=ImageIO.read(this.getClass().getResource("sprite.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//getImage();
	}
	//	 private static Image getImage() {
	//		 openSpriteSheet();
	//		 if(img == null)
	//			 img= openImageFromSpriteSheet(10, 10, 50, 64);
	//		 return img;
	//	 }
	//	 private static void openSpriteSheet() {
	//			if(spriteSheet==null) {
	//				try {
	//					spriteSheet = ImageIO.read(new File("spritesheet(2).png"));
	//					System.out.println("g");
	//				} catch (IOException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		}
	//	 protected static Image openImageFromSpriteSheet(int x, int y, int w, int h) {
	//		 return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
	//
	//	 }
	public Rectangle getRect() {
		return this.rect;
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
		rect.translate(x+1,y);
		x+=5;
//		System.out.println(x);
	}
	public  void moveLeft() {
		rect.translate(x-1,y+1);
		x-=5;
	}
	public  void jump() {
		y-=30;
		
		//rect.translate(x, y-2);
	}
	public  void crouch() {
		y+=5;
		this.rect.translate(0, 5);
		//rect.translate(x-2, y-2);
	}
	public boolean collide(EnemyObj e) {
		if (this.rect.intersects(e.getRect())){
			return true;
		}
		return false;
	}
	public void move() {
		//y=initY+(int) (-1*(20*10*Math.sin(90))*time+gravity+time*time/2);
		y=(int) (y+speed*time);
	}
	//	 public boolean powerUp(PowerUp p) {
	//		 if (this.rect.intersects(p.getRect())) {
	//			 return true;
	//		 }
	//		return false;
	//	 }
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
				System.out.println(ground.get(i).getRect().intersects(this.getRect()));
		}
	}
}
