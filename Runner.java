import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	private Grounds grounds = new Grounds();
	public static void main(String[] args) {
		new Runner().start();
	}
	public void start() {
		ArrayList<Ground> ground = grounds.getGround(); 
		JFrame frame = new JFrame("Mario!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
//				tank.draw(g);
//				target.draw(g);
//				p.draw(g);
//				arrow.draw(g);
//				button.draw(g);
				for(Ground ground : ground) {
					ground.draw(g);
				}
			};	
		};
		panel.setPreferredSize(new Dimension(800,550));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		panel.repaint();
	}
}
