package BattleShip;

public class Square {

	/*Attributes*/
	
	private char letter;
	private int num;
	private boolean occupied;
	private boolean visited;
	private boolean touched;
	
		
	/*Methods*/
	
	public Square(char letter, int num) { //Done
		this.num = num;
		this.letter = letter;
		this.occupied = false;
		this.visited = false;
		this.touched = false;
	}
	
	public void setNum(int num) { //Done
		this.num = num;
	}
	
	public int getNum() { //Done
		return this.num;
	}
	
	public void setLetter(char letter) { //Done
		this.letter = letter;
	}
	
	public char getLetter() { //Done
		return this.letter;
	}
	
	public void setOccupied() { //Done
		this.occupied = true;
	}
	
	public boolean getOccupied() { //Done
		return this.occupied;
	}
	
	public void setVisited() { //Done
		this.visited = true;
	}
	
	public boolean getVisited() { //Done
		return this.visited;
	}
	
	public void setTouched() { //Done
		this.touched = true;
	}
	
	public boolean getTouched() { //Done
		return this.touched;
	}
	
}
