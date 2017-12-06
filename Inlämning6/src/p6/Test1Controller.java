package p6;
import javax.swing.*;
import java.awt.*;


//	public void update() {
//		array.setCol(Integer.parseInt(colTextField.getText()), new Array7(tempCol));
//		array.setRow(Integer.parseInt(rowTextField.getText()), new Array7(tempRow));
//		updateSouth(array.getRow(Integer.parseInt(rowTextField.getText())));
//		String temp = array.getElement(i, j) + "";
//	}

public class Test1Controller {
	private Array7x7 array;
	private Test1UI ui;
	private Array7 leftColumn;
	private Array7 bottomRow;
	private Array7 rightColumn;

	public Test1Controller() {
		array = new Array7x7(Signs.X);
		leftColumn = array.getCol(0);
		bottomRow = array.getRow(6);
		rightColumn = array.getCol(6);
	}

	public void setLeftColumn(int col) {
		this.leftColumn = array.getCol(col);
	}

	public void setBottomRow(int row) {
		this.bottomRow = array.getRow(row);
	}

	public void setUI(Test1UI ui) {
		this.ui = ui;
	}

	public Array7 getLeftColumn() {
		return leftColumn;
	}

	public Array7 getBottomRow() {
		return bottomRow;
	}
	
	public Array7 getRightColumn() {
		return rightColumn;
	}

	public Array7x7 getArray() {
		return array;
	}
}
