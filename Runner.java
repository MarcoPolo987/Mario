import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class Runner {
	private JPanel panel;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private Timer timer;
	private boolean up, left, right;
	private boolean onGround;
	private Lives life = new Lives(WIDTH-150, 0);
	private Mario mario = new Mario(155, HEIGHT-273);
	private MysteryBlock m = new MysteryBlock(150, HEIGHT-200);
	private Koopa k = new Koopa(150, HEIGHT-100);
	private Mushroom  mush = new Mushroom(250, HEIGHT-100);
	private Bowser boss = new Bowser(300, HEIGHT-100);
	private int ticks, sx;
	private GameOver gg = new GameOver(0, 0);
	private Blocks blockss = new Blocks(WIDTH, HEIGHT);
	private Grounds grounds = new Grounds(WIDTH, HEIGHT);
	private Grounds obstacles = new Grounds(WIDTH, HEIGHT);
	private static final int REFRESH_RATE = 10;
	private ArrayList<Object> o = new ArrayList<>();
	ArrayList<Ground> ground = grounds.getGround(); 
	ArrayList<Ground> obstacle = obstacles.getGround(); 
	ArrayList<Block> blocks = blockss.getBlocks(); 
	public static void main(String[] args) {
		new Runner().start();
	}
	protected void updateGame() {
		ticks++;// keeps track of the number of times the timer has gone off
		
		int hurts = 1000/REFRESH_RATE;
		if(ticks %hurts == 0) {
			System.out.println(ticks/hurts+" seconds");
		}
		panel.repaint();
	}
	public void start() {
		for(int i=1; i<4; i++) {
			for(int y=0; y<=i; y++) {
				obstacle.add(new Ground(obstacle.get(i+20).getX(), obstacle.get(i+20).getY()-(50*y)));
			}
		}
		for(int i=1; i<4; i++) {
			for(int y=4; y>=i; y--) {
				obstacle.add(new Ground(obstacle.get(i+23).getX(), obstacle.get(i+23).getY()-(50*(4-y))));
			}
		}
		//obstacle.add(e)
		for(Ground f : ground) {
			o.add(f);
		}
		for(Ground f : obstacle) {
			o.add(f);
		}
		for(Block b : blocks) {
			o.add(b);
		}
		o.add(m);
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
				mush.draw(g);
				if(life.getLives()==0) {
					gg.draw(g);
				}
				//				pipe.draw(g);
				for(Ground ground : ground) {
					ground.draw(g);
				}
				for(Ground f : obstacle) {
					f.draw(g);
				}
				life.draw(g);
				Toolkit.getDefaultToolkit().sync();
			};	
		};
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				if(k.enemycoll(mario)) {
					k.remove();
				}
				if(mush.enemycoll(mario)) {
					mush.remove();
				}
				mario.move(o);
				k.move(mario, o);
				//boss.move(mario);
				mush.move(mario, o);
				onGround=false;
				if(!mario.isSafe(o)) {
					onGround=true;
				}
//				for(Object u: o)
//					if(mario.getLR().intersects(u.getRect()))
//						
				if(left) {
					
					if(mario.sideCollide(o)){
						right=false;
						mario.moveRight();
					}
					else if(mario.getX()>350) {
						mario.moveLeft();
						}
					else if(ground.get(0).getX()!=0){
						bscrol();
						}
					
					else if(mario.getX()<=0) {
						
					}
					else {
						mario.moveLeft();
					}
				}
				if(right) {
					
					if(mario.getX()>=WIDTH-50) {
					
					}
					else if(mario.sideCollide(o)) {
						left=false;
						mario.moveLeft();
					}
					else if(mario.getX()!=350) {
						mario.moveRight();
					}
					else if(ground.get(ground.size()-1).getX()!=WIDTH-50){
						scrol();
					}
					else {
						mario.moveRight();
					}
				}
				if(up) {
					if(onGround) {
						mario.jump();
					}
				}
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
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
//		panel.getActionMap().put("released", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				keyUp();
//			}
//			
//		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"space");
		panel.getActionMap().put("space",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("released UP"),"spaceu");
		panel.getActionMap().put("spaceu",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				up=false;
				onGround=false;
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"),"spaceu");
		panel.getActionMap().put("spaceu",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				up=false;
				onGround=false;
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"),"ru");
		panel.getActionMap().put("ru",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				right=false;
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"),"lu");
		panel.getActionMap().put("lu",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				left=false;
			}
		});
	}
	public void keyUp() {
		left=false;
		up=false;
		right=false;
	}
	public  void hit(String s) {
		keyHit(s);
		//System.out.println(mario.getX()+""+ mario.getY());
		
	}
	public void keyHit(String s) {
		System.out.println("In mario game (keyHit): "+s);
		if(s.equals("left")) {
			left=true;
			
		}
		if(s.equals("right")) {
			right=true;
			
		}
		if(s.equals("up")) {
			up=true;
		}
		if(s.equals("down")) {
			mario.crouch();
		}
	}
	private void scrol() {
		for(int q = 0; q < 5; q++) {
			for(int i = 0; i < blocks.size();i++ ) {
				blocks.get(i).scroll();
			}
			m.scroll();
			for (int i=0;i<ground.size();i++) {
				ground.get(i).scroll();
			}
			for (int i=0;i<obstacle.size();i++) {
				obstacle.get(i).scroll();
			}	
		}
		
	}
	private void bscrol() {
		for(int q = 0; q < 5; q++) {
			for(int i = 0; i < blocks.size();i++ ) {
				blocks.get(i).bScroll();
			}
			m.bScroll();
			for (int i=0;i<ground.size();i++) {
				ground.get(i).bScroll();
			}
			for (int i=0;i<obstacle.size();i++) {
				obstacle.get(i).bScroll();
			}	
		}
		
	}
}


