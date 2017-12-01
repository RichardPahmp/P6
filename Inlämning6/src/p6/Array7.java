package p6;

public class Array7 {
	private int[] array = new int[7];
	
	public Array7(){
		for(int i = 0; i < array.length; i++){
			array[i] = 0;
		}
	}
	
	public Array7(Array7 array7){
		this.array = array7.array;
	}
	
	public Array7(int[] array){
		this.array = array;
	}
	
	public void setElement(int pos, int value){
		array[pos] = value;
	}
	
	public int getElement(int pos){
		return array[pos];
	}
	
	public void setArray(Array7 array7){
		this.array = array7.array;
	}
	
	public void setArray(int[] array){
		this.array = array;
	}
	
	public Array7 getArray(){
		return new Array7(this);
	}
	
}
