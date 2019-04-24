import java.awt.*
import javax.swing.*
import java.util.*
public class Runner {
	private FroggerGame game = new FroggerGame();
	private Timer timer;
	private int ticks;
	private Grounds grounds = new Grounds();
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private static final int REFRESH_RATE = 10;
	public FroggerGameRunner() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					start();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
			}
		});
	}

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
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();
		inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
		inMap.put(KeyStroke.getKeyStroke("pressed W"), "up");
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");
			}
		});
		inMap.put(KeyStroke.getKeyStroke("pressed DOWN"), "down");
		inMap.put(KeyStroke.getKeyStroke("pressed W"), "down");
		map.put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("down");
			}
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
		panel.getActionMap().put("right",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("right");
			}
		});
		public  void hit(String s) {
		game.keyHit(s);
		panel.repaint();
	}
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		panel.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});
		public  void hit(String s) {
		game.keyHit(s);
		panel.repaint();
	}
	}
}
