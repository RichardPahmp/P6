package p6;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test4 {

	/**
	 * Main method. Creates a JFrame, JPanel & ColorDisplay. Adds panel &
	 * colordisplay into frame. Shows a 7x7 grid and input-box. While char is
	 * inserted as input - updates 7x7 grid and shows the char in the grid.
	 * 
	 * @param args
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

		while (true) {
			try {
				String res = JOptionPane.showInputDialog("Skriv en bokstav, siffra, eller ett tecken");
				char c = res.charAt(0);
				Array7x7 array = Signs.getChar(c);
				display.setDisplay(array.getColoredGrid(Color.CYAN, Color.BLUE).toIntArray());
				display.updateDisplay();
			} catch (IndexOutOfBoundsException ex) {

			}
		}
	}
}
