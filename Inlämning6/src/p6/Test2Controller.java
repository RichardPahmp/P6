package p6;

public class Test2Controller {
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	
	/**
	 * Constructor, sets the sign in the window.
	 * leftColumn is the first column in the index, starts at 0.
	 * rightColumn is the last column in the index, ends at 6
	 */

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

	public Array7 getLeftColumn() {
		return leftColumn;
	}

	public Array7 getRightColumn() {
		return rightColumn;
	}

	public Array7x7 getArray() {
		return array;
	}
	
	/**
	 * Moves the array to the left. Creating a tempArray that holds the value that is about to be moved(?). 
	 * Then puts the tempValue into the left Column. 
	 */

	public void moveLeft() {
		Array7 temp = rightColumn.getArray();
		rightColumn = leftColumn.getArray();
		leftColumn = array.getCol(0);
		array.shiftLeft();
		array.setCol(6, temp);
	}
	
	/**
	 * Moves the array to the right. Creating a tempArray that holds the value that is about to be moved(?).
	 * Then puts the tempValue into the right Column
	 */

	public void moveRight() {
		Array7 temp = leftColumn.getArray();
		leftColumn = rightColumn.getArray();
		rightColumn = array.getCol(6);
		array.shiftRight();
		array.setCol(0, temp);
	}
}