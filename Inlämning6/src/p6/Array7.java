package p6;

public class Array7 {
	private int[] array = new int[7];

	public Array7(){
		for(int i = 0; i < array.length; i++){
			array[i] = 0;
		}
	}

	public Array7(Array7 array7){
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array7.array[i];
		}
	}

	public Array7(int[] array){
		setArray(array);
	}

	public void setElement(int pos, int value){
		array[pos] = value;
	}

	public int getElement(int pos){
		return array[pos];
	}

	public void setArray(Array7 array7){
		for (int i = 0; i < array.length; i++) {
			array[i] = array7.getElement(i);
		}
	}

	public void setArray(int[] array){
		int min = Math.min(array.length, this.array.length);
		boolean thisArrayBiggest = (this.array.length > array.length);

		for (int i = 0; i < min; i++) {
			this.array[i] = array[i];
		}

		if (thisArrayBiggest) {
			for (int i = min+1; i < this.array.length; i++) {
				this.array[i] = 0;
			}
		}
	}

	public Array7 getArray(){
		return new Array7(this);
	}

	public int[] toIntArray(){
		return array;
	}
}
