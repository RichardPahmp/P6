package p6;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Test5Controller {

	/**
	 * Variables for colors, JFrame, JPanel, ColorDisplay and more.
	 */
	private static final int backgroundColor = Color.RED;
	private static final int textColor = Color.BLACK;

	/**
	 * The delay between every update in milliseconds
	 */
	private static final int DELAY = 100;

	private int counter = 0;
	private int tiles = 5;

	private Array7x7[] chars;
	private String input;

	private Timer timer;

	private Test5UI viewer;

	public static void main(String[] args) {
		Test5UI t5ui = new Test5UI();
		Test5Controller t5 = new Test5Controller(t5ui);
		t5.run();
	}

	/**
	 * draws the background red and runs the restart method
	 * @param ui The UI for displaying the messages
	 */
	public Test5Controller(Test5UI ui) {

		viewer = ui;
		restart();

		Array7x7 blank = new Array7x7();
		for (int i = 0; i < 5; i++) {
			viewer.getDisplay().setDisplay(blank.getColoredGrid(backgroundColor, textColor).toIntArray(), 0, i);
		}
	}
	
	
	/**
	 * Takes input from the user and runs the restart(String s) function
	 */
	public void restart(){
		input = JOptionPane.showInputDialog("Skriv något");
		restart(input);
	}
	
	/**
	 * Generates the 7x7 arrays to display from the input message and resets the counter
	 * @param m The input message to display
	 */
	private void restart(String m){
		String message = "     " + m;
		message = message.toUpperCase();
		chars = new Array7x7[message.length()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = Signs.getChar(message.charAt(i));
		}
		counter = chars.length * 7;

		if (tiles > chars.length) {
			tiles = chars.length;
		}
	}

	/**
	 * Starts a new timer to run update every DELAY milliseconds
	 */
	private void run() {
		timer = new Timer();
		timer.schedule(new TimerTask() {

			public void run() {
				update();
			}
		}, 0, DELAY);
	}

	/**
	 * Shifts every 7x7 character 1 step to the left and draws it to the colorDisplay
	 */
	private void update() {
		for (int i = 0; i < tiles; i++) {
			viewer.getDisplay().setDisplay(chars[i].getColoredGrid(backgroundColor, textColor).toIntArray(), 0, i);
		}
		viewer.getDisplay().updateDisplay();
		for (int i = 0; i < chars.length; i++) {
			// shift the entire array to the left
			chars[i].shiftLeft();
			if (i == chars.length - 1) {
				// if its the last array we empty the rightmost column
				chars[i].resetCol(6);
			} else {
				// move the first column in the next array to the last column in
				// the current array
				chars[i].setCol(6, chars[i + 1].getCol(0));
			}
		}

		// when the counter hits 0 we have nothing more to update and we break
		// the loop
		counter--;
		if (counter < 0) {
			timer.cancel();
			//run restart to let the user input another message
			restart();
		}
	}

}
