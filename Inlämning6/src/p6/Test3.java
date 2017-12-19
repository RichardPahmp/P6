package p6;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test3 {
	/**
	 * Main method that writes everything in the window.
	 * ColorDisplay sets up the display.
	 * The while loop moves the display to the left(whatever we chooses it to do) and 
	 * tries to catch an exception if one occurs.  
	 * @param args public static void main (don't know why we have args).
	 */
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		ColorDisplay display = new ColorDisplay(Color.WHITE, Color.BLACK);
		display.setPreferredSize(new Dimension(500, 500));
		panel.add(display);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		
		Array7x7 array = randomGrid();
		display.setDisplay(array.toIntArray());
		display.updateDisplay();
		
		while(true){
			array.shiftLeft();
			display.setDisplay(array.toIntArray());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("shiii");
			}
			display.updateDisplay();
		}
	}
	
	/**
	 * This Class creates a random generator and we use it to get different 
	 * colors in the display. We randomize all the RGB colors. 
	 * @return returns a 7x7array with the colors(?)
	 */
	
	public static Array7x7 randomGrid(){
		Array7x7 grid = new Array7x7();
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				grid.setElement(i, j, Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
			}
		}
		return grid;
	}
	
}
