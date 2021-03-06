package p6;

public class Test1Controller {
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 bottomRow;

	public Test1Controller() {
		array = new Array7x7(Signs.getChar('X'));
		leftColumn = array.getCol(0);
		bottomRow = array.getRow(6);
	}

	public void setLeftColumn(int col) {
		this.leftColumn = array.getCol(col);
	}

	public void setBottomRow(int row) {
		this.bottomRow = array.getRow(row);
	}

	public Array7 getLeftColumn() {
		return leftColumn;
	}

	public Array7 getBottomRow() {
		return bottomRow;
	}

	public Array7x7 getArray() {
		return array;
	}
}
