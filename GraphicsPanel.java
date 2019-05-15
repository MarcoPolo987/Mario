import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public Player player;
	public ArrayList<Obstacle> obstacles;
	private int obstacleTimer = 60;
	public GraphicsPanel(){
		super();
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(400, 400));
		player = new Player(this);
		obstacles = new ArrayList<Obstacle>();
		this.addKeyListener(player);
		this.setFocusable(true);
	}
	public void tick() {
		player.tick();
		for(Obstacle o : obstacles) {
			o.tick();
		}
		
		obstacleTimer--;
		if(obstacleTimer <= 0) {
			obstacleTimer=60;
			obstacles.add(new Obstacle(this));
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.paint(g);
		for(Obstacle o : obstacles) {
			o.paint(g);
		}
		
	}
	
}
