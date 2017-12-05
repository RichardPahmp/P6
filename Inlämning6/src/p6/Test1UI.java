package p6;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Test1UI extends JPanel {

	private JTextField colTextField, rowTextField;
	private JButton rowReadBtn, rowWriteBtn, colReadBtn, colWriteBtn;

	// panel för rutnät osv
	private JPanel viewPanel = new JPanel();

	// panel för knappar och inmatningsfält
	private JPanel controlPanel = new JPanel();

	private JPanel centerLabels;
	private JPanel westLabels = new JPanel();
	private JPanel southLabels = new JPanel();
	private JPanel eastLabels;

	private Array7x7 arr;

	private JTextField[] westTextFields = new JTextField[7];
	private JTextField[] southTextFields = new JTextField[7];

	ButtonListener bl = new ButtonListener();

	public Test1UI() {
		arr = new Array7x7(Signs.FOUR);
		setPreferredSize(new Dimension(800, 500));
		setLayout(new BorderLayout());

		viewPanel.setLayout(new BorderLayout());
		viewPanel.setPreferredSize(new Dimension(400, 400));
		controlPanel.setLayout(new BorderLayout());

		add(viewPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);

		updateWest(arr.getCol(0));
		updateSouth(arr.getRow(6));
		updateEast();
		updateLabels();

	}

	private void updateEast() {
		eastLabels = new JPanel();
		eastLabels.setLayout(new BorderLayout());

		JPanel rowPanel = new JPanel();
		JPanel colPanel = new JPanel();

		JLabel rowLbl = new JLabel("Rad nr: ");
		rowTextField = new JTextField("6");
		rowTextField.setPreferredSize(new Dimension(70, 30));

		rowReadBtn = new JButton("Läs rad");
		rowReadBtn.addActionListener(bl);
		rowWriteBtn = new JButton("Skriv rad");
		rowWriteBtn.addActionListener(bl);

		rowPanel.add(rowLbl);
		rowPanel.add(rowTextField);
		rowPanel.add(rowReadBtn);
		rowPanel.add(rowWriteBtn);

		eastLabels.add(rowPanel, BorderLayout.NORTH);

		JLabel colLbl = new JLabel("Kolumn nr: ");
		colTextField = new JTextField("0");
		colTextField.setPreferredSize(new Dimension(70, 30));
		colReadBtn = new JButton("Läs kolumn");
		colReadBtn.addActionListener(bl);
		colWriteBtn = new JButton("Skriv kolumn");
		colWriteBtn.addActionListener(bl);

		colPanel.add(colLbl);
		colPanel.add(colTextField);
		colPanel.add(colReadBtn);
		colPanel.add(colWriteBtn);

		eastLabels.add(colPanel, BorderLayout.CENTER);

		controlPanel.add(eastLabels, BorderLayout.EAST);
	}

	private void updateWest(Array7 array) {
		westLabels.removeAll();
		westLabels.setLayout(new GridLayout(7, 1, 5, 0));

		for (int i = 0; i < 7; i++) {
			JTextField col = new JTextField(array.getElement(i) + "");
			col.setPreferredSize(new Dimension(40, 20));
			col.setHorizontalAlignment(col.CENTER);
			col.setFont(lblFont);
			westTextFields[i] = col;
			westLabels.add(col);
		}

		viewPanel.add(westLabels, BorderLayout.WEST);
		viewPanel.revalidate();
	}

	private void updateSouth(Array7 array) {
		southLabels.removeAll();
		southLabels.setLayout(new GridLayout(1, 7, 0, 5));

		for (int i = 0; i < 7; i++) {
			JTextField row = new JTextField(array.getElement(i) + "");
			row.setHorizontalAlignment(row.CENTER);
			row.setFont(lblFont);
			southTextFields[i] = row;
			southLabels.add(row);
		}

		viewPanel.add(southLabels, BorderLayout.SOUTH);
		viewPanel.revalidate();
	}

	Font lblFont = new Font("ComicSans", Font.BOLD, 16);

	private void updateLabels() {
		centerLabels = new JPanel();
		centerLabels.setLayout(new GridLayout(7, 7, 5, 5));

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				String temp = arr.getElement(i, j) + "";
				JLabel label = new JLabel("" + temp);
				label.setHorizontalAlignment(label.CENTER);
				label.setOpaque(true);
				if (temp.equals("0")) {
					label.setBackground(Color.GRAY);
				} else {
					label.setBackground(Color.GREEN);
				}
				label.setForeground(Color.WHITE);
				label.setFont(lblFont);
				centerLabels.add(label);
			}
		}

		viewPanel.add(centerLabels, BorderLayout.CENTER);
		viewPanel.revalidate();
	}

	public static void main(String[] args) {
		Test1UI test = new Test1UI();
		JOptionPane.showMessageDialog(null, test);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(rowReadBtn)) {

				updateSouth(arr.getRow(Integer.parseInt(rowTextField.getText())));
			} else if (e.getSource().equals(rowWriteBtn)) {

				int[] tempRow = new int[7];
				for (int i = 0; i < southTextFields.length; i++) {
					tempRow[i] = Integer.parseInt(southTextFields[i].getText());
				}
				arr.setRow(Integer.parseInt(rowTextField.getText()), new Array7(tempRow));
				updateLabels();

			} else if (e.getSource().equals(colReadBtn)) {

				updateWest(arr.getCol(Integer.parseInt(colTextField.getText())));

			} else if (e.getSource().equals(colWriteBtn)) {

				int[] tempCol = new int[7];
				for (int i = 0; i < westTextFields.length; i++) {
					tempCol[i] = Integer.parseInt(westTextFields[i].getText());
				}
				arr.setCol(Integer.parseInt(colTextField.getText()), new Array7(tempCol));
				updateLabels();

			}
		}
	}
}
