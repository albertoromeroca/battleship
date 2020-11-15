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
	
	public void addSquares(ArrayList<Square> squares) { //Done
		for (int i = 0; i < squares.size(); i++) {
				squares.get(i).setOccupied();
				this.squares.add(squares.get(i));
		}
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
		for (int i = 0; i < this.squares.size(); i++) {
			if(square.getLetter() == this.squares.get(i).getLetter() && square.getNum() == this.squares.get(i).getNum()) {
				this.squares.get(i).setTouched();
				this.squares.get(i).setVisited();
			}
			
		}
	}
	
	public boolean isAllTouched(){
		boolean death = false;
		int aux = 0;
		for(int i = 0; i < this.squares.size(); i++) {
			if(this.squares.get(i).getTouched()) {
				aux++;
			}
		}
		if(aux == this.getLength()) {
			death = true;
		}
		return death;
	}
	
}

