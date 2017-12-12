package p6;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test4 {
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
		
		while(true){
			String res = JOptionPane.showInputDialog("Skriv en bokstav");
			char c = res.charAt(0);
			Array7x7 array = Signs.getChar(c);
			display.setDisplay(array.getColoredGrid(Color.RED, Color.BLUE).toIntArray());
			display.updateDisplay();
		}
	}
}
