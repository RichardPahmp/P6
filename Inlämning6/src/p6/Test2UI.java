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
	private Test1Controller control;
	private JTextField[] westTF = new JTextField[7];
	private JTextField[] eastTF = new JTextField[7];

	private JButton moveLeftBtn;
	private JButton moveRightBtn;

	private ButtonListener bl = new ButtonListener();

	public Test2UI(Test1Controller controller) {
		control = controller;
		setPreferredSize(new Dimension(800, 400));
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

	public void updateWest() {
		westFields.setLayout(new GridLayout(7, 1, 10, 10));
		for (int i = 0; i < 7; i++) {
			JTextField tf = new JTextField(control.getLeftColumn().getElement(i) + "");
			tf.setPreferredSize(new Dimension(40, 40));
			tf.setHorizontalAlignment(SwingConstants.CENTER);
			westTF[i] = tf;
			westFields.add(tf);
		}
	}

	public void updateCenter() {
		centerLabels.setLayout(new GridLayout(7, 7, 5, 5));

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				JLabel lbl = new JLabel(control.getArray().getElement(i, j) + "");
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				lbl.setOpaque(true);
				centerLabels.add(lbl);
			}
		}
	}

	public void updateEast() {
		eastFields.setLayout(new GridLayout(7, 1, 10, 10));
		for (int i = 0; i < 7; i++) {
			JTextField tf = new JTextField(control.getRightColumn().getElement(i) + "");
			tf.setPreferredSize(new Dimension(40, 40));
			tf.setHorizontalAlignment(SwingConstants.CENTER);
			eastTF[i] = tf;
			eastFields.add(tf);
		}
	}

	public void setupSouth() {
		southBtns.removeAll();
		southBtns.setLayout(new GridLayout(1, 2, 20, 20));
		moveLeftBtn = new JButton("<- Flytta vänster <-");
		moveRightBtn = new JButton("-> Flytta höger ->");
		moveLeftBtn.addActionListener(bl);
		southBtns.add(moveLeftBtn);
		southBtns.add(moveRightBtn);
		southBtns.revalidate();
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(moveLeftBtn)) {

				int[] temp = new int[7];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = Integer.parseInt(westTF[i].getText());
				}

				// Flyttar kolumn 0 till vänster textfields
				for (int i = 0; i < temp.length; i++)
					westTF[i].setText("" + control.getArray().getCol(i).getElement(i));

				// Flyttar kolumner 1-6 ett steg till vänster.
				for (int i = 1; i < 7; i++) {
					Array7 movingCol = control.getArray().getCol(i);
					control.getArray().setCol(i - 1, movingCol);
				}
				// Flyttar höger TextFields till kolumn 6
				for (int i = 0; i < 7; i++) {
					int movingNbr = Integer.parseInt(eastTF[i].getText());
					control.getArray().getCol(6).setElement(i, movingNbr);
				}

				updateCenter();

			} else if (e.getSource().equals(moveRightBtn)) {

			}
		}

	}

	public static void main(String[] args) {
		Test1Controller cont = new Test1Controller();
		Test2UI test = new Test2UI(cont);
		JFrame frame = new JFrame("TEST 2 GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(test);
		frame.pack();
		frame.setVisible(true);
	}

}
