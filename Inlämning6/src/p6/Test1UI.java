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
	Font lblFont = new Font("ComicSans", Font.BOLD, 16);

	// 7x7 rutnätet och raden/kolumnen. Ligger i West i huvudpanelen.
	private JPanel viewPanel = new JPanel();

	// panel för knappar och inmatningsfält
	private JPanel controlPanel = new JPanel();

	// Panel för 7x7 rutnätet med labels
	private JPanel centerLabels = new JPanel();
	// Panel är 7x1 rutnätet för en kolumn (vänster)
	private JPanel westLabels = new JPanel();
	// Panel för raden med JTextFields
	private JPanel southLabels = new JPanel();
	//Panel för val av rad/kol nr och läs/skriv
	private JPanel eastLabels = new JPanel();

	private JTextField[] westTextFields = new JTextField[7];
	private JTextField[] southTextFields = new JTextField[7];

	private ButtonListener bl = new ButtonListener();

	public Test1UI(Test1Controller controller) {
		this.controller = controller;
		setPreferredSize(new Dimension(800, 500));
		setLayout(new BorderLayout());

		viewPanel.setLayout(new BorderLayout());
		viewPanel.setPreferredSize(new Dimension(400, 400));
		controlPanel.setLayout(new BorderLayout());

		add(viewPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);

		updateWest();
		updateSouth();
		updateEast();
		updateCenter();
	}

	private void updateEast() {
		eastLabels.setLayout(new BorderLayout());

		JPanel rowPanel = new JPanel();
		rowPanel.setPreferredSize(new Dimension(150,120));
		JPanel colPanel = new JPanel();
		colPanel.setPreferredSize(new Dimension(150,40));

		Dimension lblDim = new Dimension(70,30);
		Dimension btnDim = new Dimension(145,30);
		
		JLabel rowLbl = new JLabel("Rad nr: ");
		rowLbl.setPreferredSize(lblDim);
		rowLbl.setHorizontalAlignment(SwingConstants.LEFT);
		rowTextField = new JTextField("6");
		rowTextField.setPreferredSize(lblDim);

		rowReadBtn = new JButton("Läs rad");
		rowReadBtn.setPreferredSize(btnDim);
		rowReadBtn.addActionListener(bl);
		rowWriteBtn = new JButton("Skriv rad");
		rowWriteBtn.setPreferredSize(btnDim);
		rowWriteBtn.addActionListener(bl);

		rowPanel.add(rowLbl);
		rowPanel.add(rowTextField);
		rowPanel.add(rowReadBtn);
		rowPanel.add(rowWriteBtn);

		eastLabels.add(rowPanel, BorderLayout.NORTH);

		JLabel colLbl = new JLabel("Kolumn nr: ");
		colLbl.setPreferredSize(lblDim);
		colLbl.setHorizontalAlignment(SwingConstants.LEFT);
		colTextField = new JTextField("0");
		colTextField.setPreferredSize(lblDim);
		colReadBtn = new JButton("Läs kolumn");
		colReadBtn.setPreferredSize(btnDim);
		colReadBtn.addActionListener(bl);
		colWriteBtn = new JButton("Skriv kolumn");
		colWriteBtn.setPreferredSize(btnDim);
		colWriteBtn.addActionListener(bl);

		colPanel.add(colLbl);
		colPanel.add(colTextField);
		colPanel.add(colReadBtn);
		colPanel.add(colWriteBtn);

		eastLabels.add(colPanel, BorderLayout.CENTER);

		controlPanel.add(eastLabels, BorderLayout.EAST);
	}

	private void updateWest() {
		westLabels.removeAll();
		westLabels.setLayout(new GridLayout(7, 1, 5, 0));
		for (int i = 0; i < 7; i++) {
			JTextField col = new JTextField(controller.getLeftColumn().getElement(i) + "");
			col.setPreferredSize(new Dimension(40, 20));
			col.setHorizontalAlignment(SwingConstants.CENTER);
			col.setFont(lblFont);
			westTextFields[i] = col;
			westLabels.add(col);
		}
		viewPanel.add(westLabels, BorderLayout.WEST);
		viewPanel.revalidate();
	}

	private void updateSouth() {
		southLabels.removeAll();
		southLabels.setLayout(new GridLayout(1, 7, 0, 5));
		for (int i = 0; i < 7; i++) {
			JTextField row = new JTextField(controller.getBottomRow().getElement(i) + "");
			row.setHorizontalAlignment(SwingConstants.CENTER);
			row.setFont(lblFont);
			southTextFields[i] = row;
			southLabels.add(row);
		}
		viewPanel.add(southLabels, BorderLayout.SOUTH);
		viewPanel.revalidate();
	}

	private void updateCenter() {
		centerLabels.removeAll();
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
		viewPanel.add(centerLabels, BorderLayout.CENTER);
		viewPanel.revalidate();
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(rowReadBtn)) {
				controller.setBottomRow(Integer.parseInt(rowTextField.getText()));
				updateSouth();

			} else if (e.getSource().equals(rowWriteBtn)) {
				int[] tempRow = new int[7];
				for (int i = 0; i < southTextFields.length; i++) {
					tempRow[i] = Integer.parseInt(southTextFields[i].getText());
				}
				controller.getArray().setRow(Integer.parseInt(rowTextField.getText()), new Array7(tempRow));
				updateCenter();

			} else if (e.getSource().equals(colReadBtn)) {
				controller.setLeftColumn(Integer.parseInt(colTextField.getText()));
				updateWest();

			} else if (e.getSource().equals(colWriteBtn)) {
				int[] tempCol = new int[7];
				for (int i = 0; i < westTextFields.length; i++) {
					tempCol[i] = Integer.parseInt(westTextFields[i].getText());
				}
				controller.getArray().setCol(Integer.parseInt(colTextField.getText()), new Array7(tempCol));
				updateCenter();
			}
		}
	}

	public static void main(String[] args) {
		Test1Controller control = new Test1Controller();
		Test1UI test = new Test1UI(control);
		
		JFrame frame1 = new JFrame("TEST 1");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(test);
		frame1.pack();
		frame1.setVisible(true);
	}
}
