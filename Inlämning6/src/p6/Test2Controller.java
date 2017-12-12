package p6;

public class Test2Controller {
	private Array7x7 array;
	private Test1UI ui;
	private Array7 leftColumn;
	private Array7 rightColumn;

	public Test2Controller() {
		array = new Array7x7(Signs.X);
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
		//lagrar vänsterspaltens värden
		Array7 temp = leftColumn.getArray();

		//sätter första kolumnen som vänsterspalten
		leftColumn = array.getCol(0);

		//går genom andra till sista kolumnen och flyttar till vänster
		for (int i = 0; i < 6; i++) {
			array.setCol(i, array.getCol(i+1));
		}
		
		//sätter högerspalten in i sista kolumnen
		array.setCol(6, rightColumn.getArray());
		
		//lägger vänsterspaltens gamla värden i högerkolumnen
		rightColumn = temp;
	}

	public void moveRight() {
		//lagrar högerspaltens värden
		Array7 temp = rightColumn.getArray();
		
		//sätter sista kolumnen som högerspalt
		rightColumn = array.getCol(6);
		
		//går genom nästsista till första kolumnen och flyttar ett steg till höger
		for (int i = 6; i > 0; i--) {
			array.setCol(i, array.getCol(i-1));
		}
		
		//sätter vänsterspalten i första kolumnen
		array.setCol(0, leftColumn.getArray());
		
		//lägger högerspaltens gamla värden i vänster
		leftColumn = temp;

	}
}