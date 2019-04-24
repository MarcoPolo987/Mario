import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;
public class Runner {
	private JPanel panel;
	private Game game = new Game();
	private Timer timer;
	private int ticks;
	private Grounds grounds = new Grounds();
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private static final int REFRESH_RATE = 10;
	public static void main(String[] args) {
		new Runner().start();
	}
	public void start() {
		ArrayList<Ground> ground = grounds.getGround(); 
		JFrame frame = new JFrame("Mario!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
//				mario.draw(g);
//				for(block : blocks){
//					block.draw(g);
//				}
//				pipe.draw(g);
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
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"),"up");
		panel.getActionMap().put("up",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		panel.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
		panel.getActionMap().put("right",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("right");
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		panel.getActionMap().put("down",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("down");
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"space");
		panel.getActionMap().put("space",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("space");
			}
		});
	}
	public  void hit(String s) {
		game.keyHit(s);
		panel.repaint();
	}
}

