package p6;

public class Array7x7 {
	private Array7[] array7 = new Array7[7];

	public Array7x7() {
		for(int i = 0; i < array7.length; i++){
			for(int j = 0; j < array7.length; j++) {
				array7[i].setElement(j,0);
			}
		}
	}

	public Array7x7(int[][] array) {
		setArray(array);
	}

	public Array7x7(Array7x7 array) {
		this.array7 = array.array7;
	}

	public void setElement(int row, int col, int value) {
		array7[row].setElement(col, value);
	}

	public int getElement(int row, int col) {
		return array7[row].getElement(col);
	}

	public void setRow(int row, Array7 theRow) {
		array7[row] = theRow;
	}

	public Array7 getRow(int row) {
		return array7[row];
	}

	public void setCol(int col, Array7 theCol) {
		for (int i = 0; i < array7.length; i++) {
			array7[i].setElement(col, theCol.getElement((i)));
		}
	}

	public Array7 getCol(int col) {
		int[] tempCol = new int[array7.length];

		for (int i = 0; i < tempCol.length; i++) {
			tempCol[i] = array7[i].getElement(col);
		}

		return new Array7(tempCol);
	}

	public void setArray(Array7x7 array7x7) {
		this.array7 = array7x7.array7;
	}

	public void setArray(int[][] array) {
		for (int i = 0; i < array7.length; i++) {
			array7[i] = new Array7(array[i]);
		}
	}

	public Array7x7 getArray() {
		return this;
	}

	public int[][] toIntArray() {
		int[][] tempArray = new int[7][7];
		for(int i = 0; i < tempArray.length; i++){
			tempArray[i] = array7[i].toIntArray();
		}
		return tempArray;
	}
}
