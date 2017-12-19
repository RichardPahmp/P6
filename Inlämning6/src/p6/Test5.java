package p6;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test5 {
	
	private static final int backgroundColor = Color.RED;
	private static final int textColor = Color.BLACK;
	
	private JFrame frame;
	private JPanel panel; 
	private ColorDisplay display;
	
	private int counter = 0;
	private int tiles = 5;
	
	private Array7x7[] chars;
	private String input;
	
	private Timer timer;
	
	/**
	 * Draws up all the frames. Input to let one write something. 
	 * Array7x7 is a "new Array7x7". 
	 * For Loop that sets the color (?). 
	 * Timer creates a new timer. 
	 */
	private void program() {
		frame = new JFrame();
		panel = new JPanel();
		display = new ColorDisplay(1, 5, Color.WHITE, Color.BLACK);
		display.setPreferredSize(new Dimension(500, 500));
		panel.add(display);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

		input = JOptionPane.showInputDialog("Skriv något");
		input = input.toUpperCase();
		chars = new Array7x7[input.length()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = Signs.getChar(input.charAt(i));
		}
		counter = chars.length * 7;
		
		if(tiles > chars.length) {
			tiles = chars.length;
		}
		Array7x7 blank = new Array7x7();
		for (int i = 0; i < 5; i++) {
			display.setDisplay(blank.getColoredGrid(backgroundColor, textColor).toIntArray(), 0, i);
		}
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			public void run() {
				update();
			}
		}, 0, 500);
		
		
	}
	
	/**
	 * Updates the display. Makes the letters in the display go left. 
	 */
	
	private void update() {
		for (int i = 0; i < tiles; i++) {
			display.setDisplay(chars[i].getColoredGrid(backgroundColor, textColor).toIntArray(), 0, i);
		}
		display.updateDisplay();
		for (int i = 0; i < chars.length; i++) {
			chars[i].shiftLeft();
			if (i == chars.length - 1) {
				chars[i].resetCol(6);
			} else {
				chars[i].setCol(6, chars[i + 1].getCol(0));
			}
		}
		counter--;
		if(counter < 0) {
			timer.cancel();
		}
	}
	
	/** 
	 * 
	 * @param args - public static void main string args
	 */
	public static void main(String[] args) {
		Test5 t5 = new Test5();
		t5.program();
	}
}
