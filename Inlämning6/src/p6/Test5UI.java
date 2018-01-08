package p6;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test5UI {
	
	public static void main(String[] args) {
		Test5UI t5ui = new Test5UI();
		Test5Controller t5 = new Test5Controller(t5ui);
		t5.run();
	}
	
	private JFrame frame;
	private JPanel panel; 
	private ColorDisplay display;
	
	/**
	 * Initialize the window and colorDisplay
	 */
	public Test5UI() {
		frame = new JFrame();
		panel = new JPanel();
		display = new ColorDisplay(1, 5, Color.WHITE, Color.BLACK);
		display.setPreferredSize(new Dimension(500, 500));
		panel.add(display);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	/** get the colordisplay
	 * @return display The colorDisplay
	 */
	public ColorDisplay getDisplay(){
		return display;
	}
	
}
