package BattleShip;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Ship {

	/*Attributes*/
	
	private int length;
	private boolean death;
	private ArrayList<Square> squares;
	
	
	/*Methods*/
	
	public Ship(int length) { //Done
		this.length = length;
		this.death = false;
		this.squares = new ArrayList<Square>();
	}
	
	public void setLength(int length) { //Done
		this.length = length;
	}
	
	public int getLength() { //Done
		return this.length;
	}
	
	public void setDeath() { //Done
		this.death = true;
	}
	
	public boolean getDeath() { //Done
		return this.death;
	}
	
	public void addSquare(Square square) { //Done
		this.squares.add(square);
	}
	
	
	public int getSquareByCoord(Square square) {
		int position = -1;
		for (int i = 0; i < this.squares.size(); i++) {
			if(square.getLetter() == this.squares.get(i).getLetter() && square.getNum() == this.squares.get(i).getNum()) {
				position = i;
			}
			
		}
		return position;
	}
		
	public void setExplosion(Square square) { //Done
		square.setTouched();
		square.setVisited();
	}
	
	
}

