package p6;

public class Array7 {
	private int[] array = new int[7];

	/**
	 * Sets this array to all 0. 
	 */
	public Array7(){
		for(int i = 0; i < array.length; i++){
			array[i] = 0;
		}
	}

	/**
	 * Sets this array to be the same as the given Array7 object. 
	 * @param array7 The Array7 object to be copied into this array.
	 */
	public Array7(Array7 array7){
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array7.array[i];
		}
	}

	/**
	 * Sets this array to the given int array.
	 * @param array The int array to be copied into this array. 
	 */
	public Array7(int[] array){
		setArray(array);
	}

	/**
	 * Sets the element at the given position to the given value. 
	 * @param pos The position to be changed. 
	 * @param value The new value to be assigned. 
	 */
	public void setElement(int pos, int value){
		array[pos] = value;
	}

	/**
	 * Returns the value in the array at the given position. 
	 * @param pos Which position to get a value from. 
	 * @return Value at pos in the array. 
	 */
	public int getElement(int pos){
		return array[pos];
	}

	/**
	 * Copies the values of the given Array7 object
	 * into this array. 
	 * @param array7 Array to be copied into this array. 
	 */
	public void setArray(Array7 array7){
		for (int i = 0; i < array.length; i++) {
			array[i] = array7.getElement(i);
		}
	}

	/**
	 * Sets this array to the given int array. 
	 * @param array
	 */
	public void setArray(int[] array){
		int min = Math.min(array.length, this.array.length);
		boolean thisArrayBiggest = (this.array.length > array.length);

		//Loop controlled by smallest array to avoid IndexOutOfBounds
		for (int i = 0; i < min; i++) {
			this.array[i] = array[i];
		}

		//If this array is the biggest, the remaining positions get 0. 
		if (thisArrayBiggest) {
			for (int i = min+1; i < this.array.length; i++) {
				this.array[i] = 0;
			}
		}
	}

	/**
	 * Returns this array.
	 * @return This array. 
	 */
	public Array7 getArray(){
		return new Array7(this);
	}

	/**
	 * Returns this array as an int array. 
	 * @return This array as an int array. 
	 */
	public int[] toIntArray(){
		return array;
	}
}
