package p6;
import java.awt.*;
import javax.swing.*;

public class Test1UI extends JPanel {
	private JLabel lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl10, lbl11, lbl12, lbl13, 
	lbl14, lbl15, lbl16, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl30, lbl31, lbl32, lbl33,
	lbl34, lbl35, lbl36, lbl40, lbl41, lbl42, lbl43, lbl44, lbl45, lbl46, lbl50, lbl51, lbl52, lbl53,
	lbl54, lbl55, lbl56, lbl60, lbl61, lbl62, lbl63, lbl64, lbl65, lbl66;
	private JTextField row0, row1, row2, row3, row4, row5, row6, col0, col1, col2, col3, col4, col5, col6, rowInput, colInput;
	private JButton readRow, writeRow, readCol, writeCol;
	private JPanel centerLabels;
	private JPanel westText;
	private Array7x7 arr;
	
	public Test1UI() {
		arr = new Array7x7(Signs.B);
		setPreferredSize(new Dimension(500,500));
		setLayout(new BorderLayout());
		centerLabels.setLayout(new GridLayout(7, 7, 20, 20));
		setUpCenter();
		westText.setLayout(new GridLayout(1, 7));
		setUpTextWest();
		add(westText, BorderLayout.CENTER);
		add(centerLabels, BorderLayout.CENTER);
	}
	
	private void setUpTextWest() {
		col0 = new JTextField("");
		col1 = new JTextField("");
		col2 = new JTextField("");
		col3 = new JTextField("");
		col4 = new JTextField("");
		col5 = new JTextField("");
		col6 = new JTextField("");

	}
	
	private void setUpLabels() {
		lbl00 = new JLabel(""+arr.getElement(0, 0));
		lbl01 = new JLabel("" + arr.getElement(0, 1));
		lbl02 = new JLabel ("" + arr.getElement(0, 2));
		lbl03 = new JLabel (""+arr.getElement(0, 3));
		lbl04 = new JLabel (""+ arr.getElement(0, 4));
		lbl05 = new JLabel (""+ arr.getElement(0, 5));
		lbl06 = new JLabel (""+arr.getElement(0, 6));
		
		lbl10 = new JLabel (""+arr.getElement(1, 0));
		lbl11 = new JLabel (""+arr.getElement(1, 1));
		lbl12 = new JLabel (""+arr.getElement(1, 2));
		lbl13 = new JLabel (""+arr.getElement(1, 3));
		lbl14 = new JLabel (""+arr.getElement(1, 4));
		lbl15 = new JLabel (""+arr.getElement(1, 5));
		lbl16 = new JLabel (""+arr.getElement(1, 6));
		
		lbl20 = new JLabel (""+arr.getElement(2, 0));
		lbl21 = new JLabel (""+arr.getElement(2, 1));
		lbl22 = new JLabel (""+arr.getElement(2, 2));
		lbl23 = new JLabel (""+arr.getElement(2, 3));
		lbl24 = new JLabel (""+arr.getElement(2, 3));
		lbl25 = new JLabel (""+arr.getElement(2, 5));
		lbl26 = new JLabel (""+arr.getElement(2, 6));
		
		lbl30 = new JLabel (""+arr.getElement(3, 0));
		lbl31 = new JLabel (""+arr.getElement(3, 1));
		lbl32 = new JLabel (""+arr.getElement(3, 2));
		lbl33 = new JLabel (""+arr.getElement(3, 3));
		lbl34 = new JLabel (""+arr.getElement(3, 4));
		lbl35 = new JLabel (""+arr.getElement(3, 5));
		lbl36 = new JLabel (""+arr.getElement(3, 6));
		
		lbl40 = new JLabel (""+arr.getElement(4, 0));
		lbl41 = new JLabel (""+arr.getElement(4, 1));
		lbl42 = new JLabel (""+arr.getElement(4, 2));
		lbl43 = new JLabel (""+arr.getElement(4, 3));
		lbl44 = new JLabel (""+arr.getElement(4, 4));
		lbl45 = new JLabel (""+arr.getElement(4, 5));
		lbl46 = new JLabel (""+arr.getElement(4, 6));
		
		lbl50 = new JLabel (""+arr.getElement(5, 0));
		lbl51 = new JLabel (""+arr.getElement(5, 1));
		lbl52 = new JLabel (""+arr.getElement(5, 2));
		lbl53 = new JLabel (""+arr.getElement(5, 3));
		lbl54 = new JLabel (""+arr.getElement(5, 4));
		lbl55 = new JLabel (""+arr.getElement(5, 5));
		lbl56 = new JLabel (""+arr.getElement(5, 6));
		
		lbl60 = new JLabel (""+arr.getElement(6, 0));
		lbl61 = new JLabel (""+arr.getElement(6, 1));
		lbl62 = new JLabel (""+arr.getElement(6, 2));
		lbl63 = new JLabel (""+arr.getElement(6, 3));
		lbl64 = new JLabel (""+arr.getElement(6, 4));
		lbl65 = new JLabel (""+arr.getElement(6, 5));
		lbl66 = new JLabel (""+arr.getElement(6, 6));
	}
	private void setUpCenter() {
		setUpLabels();
		centerLabels.add(lbl00);
		centerLabels.add(lbl01);
		centerLabels.add(lbl02);
		centerLabels.add(lbl03);
		centerLabels.add(lbl04);
		centerLabels.add(lbl05);
		centerLabels.add(lbl06);
		
		centerLabels.add(lbl10);
		centerLabels.add(lbl11);
		centerLabels.add(lbl12);
		centerLabels.add(lbl13);
		centerLabels.add(lbl14);
		centerLabels.add(lbl15);
		centerLabels.add(lbl16);
		
		centerLabels.add(lbl20);
		centerLabels.add(lbl21);
		centerLabels.add(lbl22);
		centerLabels.add(lbl23);
		centerLabels.add(lbl24);
		centerLabels.add(lbl25);
		centerLabels.add(lbl26);
		
		centerLabels.add(lbl30);
		centerLabels.add(lbl31);
		centerLabels.add(lbl32);
		centerLabels.add(lbl33);
		centerLabels.add(lbl34);
		centerLabels.add(lbl35);
		centerLabels.add(lbl36);
		
		centerLabels.add(lbl40);
		centerLabels.add(lbl41);
		centerLabels.add(lbl42);
		centerLabels.add(lbl43);
		centerLabels.add(lbl44);
		centerLabels.add(lbl45);
		centerLabels.add(lbl46);
		
		centerLabels.add(lbl50);
		centerLabels.add(lbl51);
		centerLabels.add(lbl52);
		centerLabels.add(lbl53);
		centerLabels.add(lbl54);
		centerLabels.add(lbl55);
		centerLabels.add(lbl56);
		
		centerLabels.add(lbl60);
		centerLabels.add(lbl61);
		centerLabels.add(lbl62);
		centerLabels.add(lbl63);
		centerLabels.add(lbl64);
		centerLabels.add(lbl65);
		centerLabels.add(lbl66);
	}
	
	public static void main(String[] args) {
		Test1UI test = new Test1UI();
		JOptionPane.showMessageDialog(null, test);
	}

}
