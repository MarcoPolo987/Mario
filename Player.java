import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener{
	int x, y, ySpeed;
	boolean up, down, left, right;
	boolean onGround;
	GraphicsPanel host;
	
	public Player(GraphicsPanel host){
		this.host=host;
		x = (int) (host.getPreferredSize().getWidth()/2);
		y = (int) (host.getPreferredSize().getHeight()/2);
		
		up = false;
		down = false;
		left = false;
		right = false;
		ySpeed = 0;
		onGround=false;
	}
	public void paint(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x-25, y-25, 50, 50);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void tick() {
		y += ySpeed;
		ySpeed += 1;
		if(y>=host.getHeight()-25) {
			y=host.getHeight()-25;
			ySpeed=0;
			onGround=true;
		}
		else {
			onGround=false;
		}
		if(left) {
			x -=5;
		}
		if(right) {
			x += 5;
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(onGround) {
				ySpeed = -20;
			}
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
	}
}
