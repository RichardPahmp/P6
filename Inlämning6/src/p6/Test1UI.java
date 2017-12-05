package p6;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Test1UI extends JPanel {
	private Test1Controller controller;
	private JTextField colTextField, rowTextField;
	private JButton rowReadBtn, rowWriteBtn, colReadBtn, colWriteBtn;

	// 7x7 rutnätet och raden/kolumnen. Ligger i West i huvudpanelen. 
	private JPanel viewPanel = new JPanel();

	// panel för knappar och inmatningsfält
	private JPanel controlPanel = new JPanel();

	//Panel för 7x7 rutnätet med labels 
	private JPanel centerLabels;
	//Panel för 7x1 rutnätet för en kolumn (vänster)
	private JPanel westLabels = new JPanel();
	//Panel för 1x7 rutnätet för en rad (längst ner)
	private JPanel southLabels = new JPanel();
	private JPanel eastLabels;

	private JTextField[] westTextFields = new JTextField[7];
	private JTextField[] southTextFields = new JTextField[7];

	private ButtonListener bl = new ButtonListener();


	public Test1UI(Test1Controller controller) {
		this.controller = controller;
		controller.setUI(this);
		setPreferredSize(new Dimension(800, 500));
		setLayout(new BorderLayout());

		viewPanel.setLayout(new BorderLayout());
		viewPanel.setPreferredSize(new Dimension(400, 400));
		controlPanel.setLayout(new BorderLayout());

		add(viewPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);

		updateWest();
		updateSouth();
		setupEast();
		updateLabels();

	}

	private void setupEast() {
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

	private void updateWest() {
		westLabels.setLayout(new GridLayout(7, 1, 5, 0));
		for (int i = 0; i < 7; i++) {
			JTextField col = new JTextField(controller.getLeftColumn().getElement(i) + "");
			col.setPreferredSize(new Dimension(40, 20));
			col.setHorizontalAlignment(SwingConstants.CENTER);
			col.setFont(lblFont);
			westTextFields[i] = col;
			westLabels.add(col);
		}
	}
	
	public JPanel getWestLabels() {
		return westLabels;
	}
	
	public JPanel getViewPanel() {
		return viewPanel;
	}

	private void updateSouth() {
		southLabels.setLayout(new GridLayout(1, 7, 0, 5));
		for (int i = 0; i < 7; i++) {
			JTextField row = new JTextField(controller.getBottomRow().getElement(i) + "");
			row.setHorizontalAlignment(SwingConstants.CENTER);
			row.setFont(lblFont);
			southTextFields[i] = row;
			southLabels.add(row);
		}
	}
	
	public JPanel getSouthLabels() {
		return southLabels;
	}

	Font lblFont = new Font("ComicSans", Font.BOLD, 16);

	private void updateLabels() {
		centerLabels.setLayout(new GridLayout(7, 7, 5, 5));
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				String temp = controller.getArray().getElement(i, j) + "";
				JLabel label = new JLabel("" + temp);
				label.setHorizontalAlignment(SwingConstants.CENTER);
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
	}
	public JPanel getCenterLabels() {
		return centerLabels;
	}



	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(rowReadBtn)) {
				controller.updateSouth();
//				updateSouth(arr.getRow(Integer.parseInt(rowTextField.getText())));

			} else if (e.getSource().equals(rowWriteBtn)) {
				int[] tempRow = new int[7];
				for (int i = 0; i < southTextFields.length; i++) {
					tempRow[i] = Integer.parseInt(southTextFields[i].getText());
				}
//				arr.setRow(Integer.parseInt(rowTextField.getText()), new Array7(tempRow));
				controller.updateLabels();

			} else if (e.getSource().equals(colReadBtn)) {
				controller.updateWest();
//				updateWest(arr.getCol(Integer.parseInt(colTextField.getText())));

			} else if (e.getSource().equals(colWriteBtn)) {

				int[] tempCol = new int[7];
				for (int i = 0; i < westTextFields.length; i++) {
					tempCol[i] = Integer.parseInt(westTextFields[i].getText());
				}
//				arr.setCol(Integer.parseInt(colTextField.getText()), new Array7(tempCol));
				controller.updateLabels();

			}
		}
	}
	public static void main(String[] args) {
		Test1Controller control = new Test1Controller();
		Test1UI test = new Test1UI(control);
		JOptionPane.showMessageDialog(null, test);
	}
}
