package p6;

public class Array7x7 {
	private Array7[] array7 = new Array7[7];
	
	/**
	 * Sets up an Array7x7 object filled with 0. 
	 */
	public Array7x7() {
		for (int i = 0; i < array7.length; i++) {
			array7[i] = new Array7();
		}
	}

	/**
	 * Sets up an Array7x7 object matching the given 2D int array. 
	 * @param array The array to be matched. 
	 */
	public Array7x7(int[][] array) {
		setArray(array);
	}

	/**
	 * Sets up an Array7x7 object matching the given Array7x7. 
	 * @param array The Array7x7 to be matched. 
	 */
	public Array7x7(Array7x7 array) {
		setArray(array.toIntArray());
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
		for (int i = 0; i < 7; i++) {
			array7[i] = new Array7(array7x7.array7[i]);
		}
	}

	public void setArray(int[][] array) {
		for (int i = 0; i < array7.length; i++) {
			array7[i] = new Array7(array[i]);
		}
	}

	/**
	 * Returns a copy of this Array7x7 object. 
	 * @return Copy of this Array7x7 object. 
	 */
	public Array7x7 getArray() {
		Array7x7 temp = new Array7x7(this);
		return temp;
	}

	/**
	 * Returns this Array7x7 as a 2 dimensional int array. 
	 * @return Int array representation of this Array7x7. 
	 */
	public int[][] toIntArray() {
		int[][] tempArray = new int[7][7];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array7[i].toIntArray();
		}
		return tempArray;
	}
	
	/**
	 * Shifts every column to the left. 
	 */
	public void shiftLeft() {
		Array7 temp = getCol(0);

		for (int i = 0; i < 6; i++) {
			setCol(i, getCol(i + 1));
		}

		setCol(6, temp);
	}

	/**
	 * Shifts every column to the right. 
	 */
	public void shiftRight() {
		Array7 temp = getCol(6);
		
		for (int i = 6; i > 0; i--) {
			setCol(i, getCol(i - 1));
		}
		
		setCol(0, temp);
	}
	
	public Array7x7 getColoredGrid(int col1, int col2){
		Array7x7 res = new Array7x7(this);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if(res.getElement(i, j) == 0){
					res.setElement(i, j, col1);
				} else if(res.getElement(i, j) == 1){
					res.setElement(i, j, col2);
				} else {
					//res.setElement(i, j, 0);
					//System.out.println(res.getElement(i, j));
				}
			}
		}
		return res;
	}
	
	/**
	 * Sets the column at the index col to all 0. 
	 * @param col The col to be reset.
	 */
	public void resetCol(int col) {
		for (int i = 0; i < array7.length; i++) {
			array7[i].setElement(col, 0);
		}
	}
	
	/**
	 * Returns a string representation of this object.
	 * @return String representation of this 2 dimensional array.
	 */
	public String toString(){
		String res = "";
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				res += this.getElement(i, j);
			}
			res += "\n";
		}
		return res;
	}
}
