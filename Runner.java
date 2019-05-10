import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class Runner {
	private JPanel panel;
	private Game game = new Game();
	private Timer timer;
	private Mario mario = new Mario(155, 225);
	private MysteryBlock m = new MysteryBlock(150, 300);
	private Blocks blockss = new Blocks();
	private scrollChecks scrollss= new scrollChecks();
	private Koopa k = new Koopa(150, 450);
	private Bowser boss = new Bowser(300, 450);
	private int ticks, sx;
	private Grounds grounds = new Grounds();
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private static final int REFRESH_RATE = 10;
	public static void main(String[] args) {
		new Runner().start();
	}
	protected void updateGame() {
		ticks++;// keeps track of the number of times the timer has gone off
		
		int hurts = 1000/REFRESH_RATE;
		if(ticks %hurts == 0) {
			System.out.println(ticks/hurts+" seconds");
		}
	}
	public void start() {
		
		ArrayList<Ground> ground = grounds.getGround(); 
		ArrayList<Block> blocks = blockss.getBlocks(); 
		ArrayList<scrollCheck> scrolls= scrollss.getScroll();
		JFrame frame = new JFrame("Mario!");
		timer = new Timer(sx, null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timer.start();
		
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				mario.draw(g);
				for(Block block : blocks){
					block.draw(g);
				}
				m.draw(g);
				k.draw(g);
				//				pipe.draw(g);
				//				arrow.draw(g);
				//				button.draw(g);
				for(Ground ground : ground) {
					ground.draw(g);
				}
			};	
		};
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				mario.move();
				k.move(mario);
				panel.repaint();
			}
		});
		timer.start();
//		timer.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				updateGame();
//				System.out.println("timer went off!");
//				mario.move();
//				k.move(mario);
//				panel.repaint();
////				for(Ground g : ground) {
////				System.out.println(mario.stand(g));
////				if(mario.stand(g)) {
////					
////				}
////			}
//			}
//		});
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
		if(s.equals("space")) {
			mario.jump();
		}
		if(s.equals("up")) {
			mario.jump();
		}
		if(s.equals("down")) {
			mario.crouch();
		}
	}
}

