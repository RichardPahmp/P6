package p6;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Test2UI extends JPanel {
	private JPanel centerLabels = new JPanel();
	private JPanel westFields = new JPanel(); 
	private JPanel eastFields = new JPanel();
	private JPanel southBtns = new JPanel();
	private Test2Controller controller;
	private JTextField[] westTF = new JTextField[7];
	private JTextField[] eastTF = new JTextField[7];
	
	private JButton moveLeftBtn;
	private JButton moveRightBtn;
	
	private ButtonListener bl = new ButtonListener();
	
	/**
	 * Test2Controller does all the "math". 
	 * Constructor updates the UI with the methods in this class. 
	 * @param controller controller does all the internal calculations.
	 */
	
	public Test2UI(Test2Controller controller ) {
		this.controller = controller;
		setPreferredSize(new Dimension(800,400));
		setLayout(new BorderLayout());
				
		add(westFields, BorderLayout.WEST);
		add(centerLabels, BorderLayout.CENTER);
		add(eastFields, BorderLayout.EAST);
		add(southBtns, BorderLayout.SOUTH);
		
		
		updateWest();
		updateCenter();
		updateEast();
		setupSouth();
	}
	
	/**
	 * Updates West Column 
	 */
	
	public void updateWest() {
		westFields.removeAll();
		westFields.setLayout(new GridLayout(7, 1, 10, 10));
		for (int i = 0; i < 7; i++) {
			JTextField tf = new JTextField(controller.getLeftColumn().getElement(i) + "");
			tf.setPreferredSize(new Dimension(40,40));
			tf.setHorizontalAlignment(SwingConstants.CENTER);
			westTF[i] = tf;
			westFields.add(tf);
		}
		westFields.revalidate();
	}
	
	/**
	 * Updates Center board 
	 */
	
	public void updateCenter() {
		centerLabels.removeAll();
		centerLabels.setLayout(new GridLayout(7,7, 5, 5));

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				JLabel lbl = new JLabel(controller.getArray().getElement(i, j) + "");
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				lbl.setOpaque(true);
				lbl.setBackground(Color.GRAY);
				lbl.setForeground(Color.WHITE);
				centerLabels.add(lbl);
				if (lbl.getText().equals("1"))
					lbl.setBackground(Color.GREEN);
			}
		}
		centerLabels.revalidate();
	}
	
	/**
	 * Updates East Column
	 */
	
	public void updateEast() {
		eastFields.removeAll();
		eastFields.setLayout(new GridLayout(7,1, 10, 10));
		for (int i = 0; i < 7; i++) {
			JTextField tf = new JTextField(controller.getRightColumn().getElement(i) + "");
			tf.setPreferredSize(new Dimension(40,40));
			tf.setHorizontalAlignment(SwingConstants.CENTER);
			eastTF[i] = tf;
			eastFields.add(tf);
		}
		eastFields.revalidate();
	}
	
	/**
	 * Sets up the buttons in South
	 */
	
	public void setupSouth() {
		southBtns.removeAll();
		southBtns.setLayout(new GridLayout(1,2, 20, 20));
		moveLeftBtn = new JButton("<- Flytta vänster <-");
		moveRightBtn = new JButton("-> Flytta höger ->");
		moveLeftBtn.addActionListener(bl);
		moveRightBtn.addActionListener(bl);
		southBtns.add(moveLeftBtn);
		southBtns.add(moveRightBtn);
		southBtns.revalidate();
	}
	
	/**
	 *  Inner Class that listens to the buttons 
	 */
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(moveLeftBtn)) {
				controller.moveLeft();
				
				updateWest();
				updateCenter();
				updateEast();
				
			} else if (e.getSource().equals(moveRightBtn)) {
				controller.moveRight();
				
				updateWest();
				updateCenter();
				updateEast();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Test2Controller cont = new Test2Controller();
		Test2UI test = new Test2UI(cont);
		JFrame frame = new JFrame("TEST 2 GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(test);
		frame.pack();
		frame.setVisible(true);
	}

}
