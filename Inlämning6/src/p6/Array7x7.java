package p6;

public class Array7x7 {
	private int[][] array = new int[7][7];
	
	public Array7x7() {
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = 0;
			}
		}
	}
	
	public Array7x7(int[][] array) {
		this.array = array;
	}
	
	public Array7x7(Array7x7 array) {
		this.array = array.array;
	}
	
	public void setElement(int row, int col, int value) {
		array[row][col] = value;
	}
	
	public int getElement(int row, int col) {
		return array[row][col];
	}
	
	public void setRow(int row, Array7 theRow) {
		for(int i = 0; i < array.length; i++) {
			array[row][i] = theRow.getElement(i);
		}
	}
	
	public Array7 getRow(int row) {
		return new Array7(array[row]);
	}
	
	public void setCol(int col, Array7 theCol) {
		for(int i = 0; i < array.length; i++) {
			array[i][col] = theCol.getElement(i);
		}
	}
	
	public Array7 getCol(int col) {
		int[] tempCol = new int[array.length];
		
		for(int i = 0; i < tempCol.length; i++) {
			tempCol[i] = array[i][col];
		}
		
		return new Array7(tempCol);		
	}
	
	public void setArray(Array7x7 array7x7) {
		this.array = array7x7.array;
	}
	
	public void setArray(int[][] array) {
		this.array = array;
	}
	
	public Array7x7 getArray() {
		return this;
	}
	
	public int[][] toIntArray() {
		return array;
	}
}
