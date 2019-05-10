import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.*;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;




public class FroggerGameRunner {
	private JPanel panel;
	private FroggerGame game = new FroggerGame();
	private Timer timer;
	private int ticks;
	
	// Notice this intuitive method for finding the screen size 
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
		new FroggerGameRunner();
	}

	private void start() {
		JFrame frame = new JFrame("Frogger");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGame(g);
			}
		};
		// random color to the background
		panel.setBackground(new Color(20, 15, 120));
		
		// so that the frame isn't minimized
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		// so that the frame is placed a little way from top and left side
		frame.setLocation(WIDTH/10, HEIGHT/10);

		// map the keystrokes that the panel detects to the game
		mapKeyStrokesToActions(panel);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		// after setting visible to true, you can get focus.  You need focus to consume
		// the keystrokes hit by the user
		panel.requestFocusInWindow();
		
		// this timer controls the actions in the game and then repaints after each update to data
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				panel.repaint();
			}
		});
		timer.start();
	}

	// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
	protected void updateGame() {
		
		
		
		
		game.moveStuff();
	}
	

	private void mapKeyStrokesToActions(JPanel panel) {

		// A map is an Data storage interface which defines
		// an association of a key with a value
		// to "add" to a map you use the "put" method
		// to "get" from a map you use "get(key)" and the 
		// value associated with the key is returned (or null)
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();

		// code below associates pressing the up arrow with the command "up"
		// essentially creating the command "up" being broadcast any time the 
		// up key is hit
		inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
		inMap.put(KeyStroke.getKeyStroke("pressed LEFT"), "left");
		inMap.put(KeyStroke.getKeyStroke("pressed DOWN"), "down");
		inMap.put(KeyStroke.getKeyStroke("pressed RIGHT"), "right");
		inMap.put(KeyStroke.getKeyStroke("pressed W"), "up");
		inMap.put(KeyStroke.getKeyStroke("pressed A"), "left");
		inMap.put(KeyStroke.getKeyStroke("pressed D"), "right");
		inMap.put(KeyStroke.getKeyStroke("pressed S"), "down");
		
		// code below associates the "up" action with anything in the 
		// actionPerformed method.  Right now, it just prints something
		map.put("up", new AbstractAction() {
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

	
	panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
	panel.getActionMap().put("down",new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			hit("down");
		}
	});
	
	panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
	panel.getActionMap().put("right",new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			hit("right");
		}
	});
	}
	
	
	public  void hit(String s) {
		game.keyHit(s);
		panel.repaint();
		
	}
	protected void drawGame(Graphics g) {
		game.draw(g);
	}

}
