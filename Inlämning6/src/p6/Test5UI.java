package p6;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test5UI {
	
	private JFrame frame;
	private JPanel panel; 
	private ColorDisplay display;
	
	/**
	 * Draws up all the frames. Input to let one write something. 
	 * Array7x7 is a "new Array7x7". 
	 * For Loop that sets the color (?). 
	 * Timer creates a new timer. 
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
	
	/**
	 * Updates the display. Makes the letters in the display go left. 
	 * When letters reach left side they "disappear". 
	 */
	
	public ColorDisplay getDisplay(){
		return display;
	}
	
}
