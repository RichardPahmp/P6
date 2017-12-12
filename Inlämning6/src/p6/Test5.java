package p6;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		ColorDisplay display = new ColorDisplay(1, 5, Color.WHITE, Color.BLACK);
		display.setPreferredSize(new Dimension(500, 500));
		panel.add(display);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		
		String input = JOptionPane.showInputDialog("Skriv något");
		input = input.toUpperCase();
		Array7x7[] chars = new Array7x7[input.length()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = Signs.getChar(input.charAt(i));
		}
		int index = 0;
		while(true){
			for (int i = 0; i < 5; i++) {
				display.setDisplay(chars[i + index].getColoredGrid(Color.RED, Color.BLACK).toIntArray(), 0, i);
			}
			display.updateDisplay();
			System.out.println(chars[0].toString());
			index++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
