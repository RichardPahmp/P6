package p6;
import javax.swing.*;
import java.awt.*;


public class Test1Controller {
	private Test1UI ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 bottomRow;
	private JPanel viewPanel;
 
	public Test1Controller() {
		array = new Array7x7(Signs.FOUR);
		leftColumn = array.getCol(0);
		bottomRow = array.getRow(6);
		viewPanel = ui.getViewPanel();
	}

	public void setUI(Test1UI ui) {
		this.ui = ui; 
	}

	public void updateWest() {
		JPanel westLabels = ui.getWestLabels();
		//		westLabels.removeAll();

		viewPanel.add(westLabels, BorderLayout.WEST);
		viewPanel.revalidate();
	}

	public void updateSouth() {
		JPanel southLabels = ui.getSouthLabels(); 
//		southLabels.removeAll();
		
		viewPanel.add(southLabels, BorderLayout.SOUTH);
		viewPanel.revalidate();
	}
	
	public Array7 getBottomRow() {
		return bottomRow;
	}
	
	public Array7 getLeftColumn() {
		return leftColumn;
	}
	
	public Array7x7 getArray() {
		return array;
	}
	
	public void updateLabels() {
		JPanel centerLabels = ui.getCenterLabels();
		centerLabels = new JPanel();
		
		viewPanel.add(centerLabels, BorderLayout.CENTER);
		viewPanel.revalidate();
	}

//	public void update() {
//		array.setCol(Integer.parseInt(colTextField.getText()), new Array7(tempCol));
//		array.setRow(Integer.parseInt(rowTextField.getText()), new Array7(tempRow));
//		updateSouth(array.getRow(Integer.parseInt(rowTextField.getText())));
//		String temp = array.getElement(i, j) + "";
//	}

}
