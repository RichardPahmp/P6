package p6;

import java.awt.*;
import java.awt.Color;

import javax.swing.*;

public class Test1UI extends JPanel {
	
	private JTextField colTextField;
	private JTextField rowTextField;

	private JPanel viewPanel = new JPanel();
	private JPanel controlPanel = new JPanel();
	
	private JPanel centerLabels;
	private JPanel westLabels;
	private JPanel southLabels;
	private JPanel eastLabels;
	private Array7x7 arr;

	public Test1UI() {
		arr = new Array7x7(Signs.B);
		setPreferredSize(new Dimension(800, 500));
		setLayout(new BorderLayout());
		
		viewPanel.setLayout(new BorderLayout());
		viewPanel.setPreferredSize(new Dimension(400,400));
		controlPanel.setLayout(new BorderLayout());
		
		add(viewPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);
		
		updateWest();
		updateSouth();
		updateEast();
		updateLabels();
		
	}
	
	private void updateEast() {
		eastLabels = new JPanel();
		eastLabels.setLayout(new BorderLayout());
		
		JPanel rowPanel = new JPanel();
		JPanel colPanel = new JPanel();
		
		JLabel rowLbl = new JLabel("Rad nr: ");
		rowTextField = new JTextField("0");
		rowTextField.setPreferredSize(new Dimension(70,30));

		JButton rowreadBtn = new JButton("Läs rad");
		JButton rowwriteBtn = new JButton("Skriv rad");
		
		rowPanel.add(rowLbl);
		rowPanel.add(rowTextField);
		rowPanel.add(rowreadBtn);
		rowPanel.add(rowwriteBtn);
		
		eastLabels.add(rowPanel, BorderLayout.NORTH);
		
		JLabel colLbl = new JLabel("Kolumn nr: ");
		colTextField = new JTextField("0");
		colTextField.setPreferredSize(new Dimension(70,30));
		JButton colreadBtn = new JButton("Läs kolumn");
		JButton colwriteBtn = new JButton("Skriv kolumn");
		
		colPanel.add(colLbl);
		colPanel.add(colTextField);
		colPanel.add(colreadBtn);
		colPanel.add(colwriteBtn);
		
		eastLabels.add(colPanel, BorderLayout.CENTER);
		
		controlPanel.add(eastLabels, BorderLayout.EAST);
	}

	private void updateWest() {
		westLabels = new JPanel();
		westLabels.setLayout(new GridLayout(7, 1, 5, 0));

		for (int i = 0; i < 7; i++) {
			JTextField col = new JTextField("0");
			col.setHorizontalAlignment(col.CENTER);
			col.setFont(lblFont);
			westLabels.add(col);
		}
		
		viewPanel.add(westLabels,BorderLayout.WEST);

	}
	
	private void updateSouth() {
		southLabels = new JPanel();
		southLabels.setLayout(new GridLayout(1, 7, 0, 5));

		for (int i = 0; i < 7; i++) {
			JTextField col = new JTextField("0");
			col.setHorizontalAlignment(col.CENTER);
			col.setFont(lblFont);
			southLabels.add(col);
		}
		
		viewPanel.add(southLabels, BorderLayout.SOUTH);

	}

	Font lblFont = new Font("ComicSans", Font.BOLD, 16);

	private void updateLabels() {
		centerLabels = new JPanel();
		centerLabels.setLayout(new GridLayout(7, 7, 5, 5));

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				JLabel label = new JLabel("" + arr.getElement(i, j));
				label.setHorizontalAlignment(label.CENTER);
				label.setOpaque(true);
				label.setBackground(Color.GRAY);
				label.setForeground(Color.WHITE);
				label.setFont(lblFont);
				centerLabels.add(label);
			}
		}

		viewPanel.add(centerLabels, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		Test1UI test = new Test1UI();
		JOptionPane.showMessageDialog(null, test);
	}

}
