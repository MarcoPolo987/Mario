import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mario extends Character{
	private static final int WIDTH=50,HEIGHT=50;
	 private Rectangle rect;
	 private Image img;
	 public Mario(int x, int y) {
		super(x,y);
		try {
			
			img=ImageIO.read(this.getClass().getResource(".png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 }
	 public Rectangle getRect() {
		 return this.rect;
	 }
	 public void move(int x, int y) {
		 rect.translate(x,y);
	 }
	 public void moveRight(int x, int y) {
		 rect.translate(x+1,y);
	 }
	 public void moveLeft(int x, int y) {
		 rect.translate(x-1,y+1);
	 }
	 public void jump(int x,int y) {
		 rect.translate(x, y-2);
	 }
	 public void crouch(int x, int y) {
		 rect.translate(x-2, y-2);
	 }
	 public void draw(Graphics g, int x, int y) {
		 g.drawImage(img,x,y,WIDTH,HEIGHT, null); 
	 }
	 public boolean collide(EnemyObj e) {
		 if (this.rect.intersects(e.getRect())){
			 return true;
		 }
		 return false;
	 }
	 public boolean powerUp(PowerUp p) {
		 if (this.rect.intersect(p.getRect())) {
			 return true;
		 }
	 }
}