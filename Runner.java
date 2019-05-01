import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class Runner {
	private JPanel panel;
	private Game game = new Game();
	private Timer timer;
	private Mario mario = new Mario(5, 5);
	private MysteryBlock m = new MysteryBlock(150, 300);
	private Blocks blockss = new Blocks();
	private int ticks, sx;
	private Grounds grounds = new Grounds();
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private static final int REFRESH_RATE = 10;
	public static void main(String[] args) {
		new Runner().start();
	}
	public void start() {
		ArrayList<Ground> ground = grounds.getGround(); 
		ArrayList<Block> blocks = blockss.getBlocks(); 
		JFrame frame = new JFrame("Mario!");
		timer = new Timer(sx, null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				mario.draw(g);
				for(Block block : blocks){
					block.draw(g);
				}
				m.draw(g);
				//				pipe.draw(g);
				//				arrow.draw(g);
				//				button.draw(g);
				for(Ground ground : ground) {
					ground.draw(g);
				}
			};	
		};
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("timer went off!");
				for(Ground g : ground) {
					System.out.println(mario.stand(g));
					if(mario.stand(g)) {
						
					}
				}
				panel.repaint();
			}
		});
		panel.setPreferredSize(new Dimension(800,550));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		panel.setBackground(new Color(135,206,250));
		panel.repaint();
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();
		panel.getInputMap().put(KeyStroke.getKeyStroke("UP"),"up");
		panel.getActionMap().put("up",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");
				mario.fall(ground);
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
		//System.out.println(mario.getX()+""+ mario.getY());
		timer.start();
		keyHit(s);
		panel.repaint();
	}
	public void keyHit(String s) {
		System.out.println("In mario game (keyHit): "+s);
		if(s.equals("right")) {
			mario.moveRight();
		}
		if(s.equals("left")) {
			mario.moveLeft();
		}
		if(s.equals("up")) {
			mario.jump();
		}
		if(s.equals("down")) {
			mario.crouch();
		}
	}
}

