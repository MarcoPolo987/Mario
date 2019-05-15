import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphic_tests {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GraphicsPanel  pane = new GraphicsPanel();
		
		
		frame.add(pane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Timer t = new Timer(1000/30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.tick();
				pane.repaint();
			}
		});
		t.start();
	}

}
