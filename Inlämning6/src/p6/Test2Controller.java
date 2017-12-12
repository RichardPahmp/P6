package p6;

public class Test2Controller {
	private Array7x7 array;
	private Test1UI ui;
	private Array7 leftColumn;
	private Array7 rightColumn;

	public Test2Controller() {
		array = new Array7x7(Signs.getChar('X'));
		leftColumn = array.getCol(0);
		rightColumn = array.getCol(6);
	}

	public void setLeftColumn(int col) {
		this.leftColumn = array.getCol(col);
	}

	public void setRightColumn(int col) {
		this.rightColumn = array.getCol(col);
	}

	public void setUI(Test1UI ui) {
		this.ui = ui;
	}

	public Array7 getLeftColumn() {
		return leftColumn;
	}

	public Array7 getRightColumn() {
		return rightColumn;
	}

	public Array7x7 getArray() {
		return array;
	}

	public void moveLeft() {
		Array7 temp = rightColumn.getArray();
		rightColumn = leftColumn.getArray();
		leftColumn = array.getCol(0);
		array.shiftLeft();
		array.setCol(6, temp);
	}

	public void moveRight() {
		Array7 temp = leftColumn.getArray();
		leftColumn = rightColumn.getArray();
		rightColumn = array.getCol(6);
		array.shiftRight();
		array.setCol(0, temp);
	}
}