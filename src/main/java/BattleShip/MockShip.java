package BattleShip;

import java.util.ArrayList;

public class MockShip implements ShipInterface {

	/*Attributes*/
	
	private int length;
	private boolean death;
	private ArrayList<Square> squares;
	
	
	/*Methods*/
	
	public MockShip(int length) { //Done
		
		this.length = length;
		
		this.death = false;
		
		this.squares = new ArrayList<Square>();
		
		if(this.length == 5) {
			Square square1 = new Square('A', 1);
			Square square2 = new Square('A', 2);
			Square square3 = new Square('A', 3);
			Square square4 = new Square('A', 4);
			Square square5 = new Square('A', 5);
			this.squares.add(square1);
			this.squares.add(square2);
			this.squares.add(square3);
			this.squares.add(square4);
			this.squares.add(square5);
		}
		
		if(this.length == 4) {
			Square square1 = new Square('B', 1);
			Square square2 = new Square('B', 2);
			Square square3 = new Square('B', 3);
			Square square4 = new Square('B', 4);
			this.squares.add(square1);
			this.squares.add(square2);
			this.squares.add(square3);
			this.squares.add(square4);
		}
		
		if(this.length == 3) {
			Square square1 = new Square('C', 1);
			Square square2 = new Square('C', 2);
			Square square3 = new Square('C', 3);
			this.squares.add(square1);
			this.squares.add(square2);
			this.squares.add(square3);
		}

		if(this.length == 2) {
			Square square1 = new Square('D', 1);
			Square square2 = new Square('D', 2);
			square1.setOccupied();
			square2.setOccupied();
			this.squares.add(square1);
			this.squares.add(square2);
		}
		
	}



	public void setLength(int length) {
		// TODO Auto-generated method stub
		
	}


	public int getLength() {
		return this.length;
	}


	public void setDeath() {
		this.death = true;
		
	}


	public boolean getDeath() {
		return this.death;
	}


	public void addSquares(ArrayList<Square> squares) {
		
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


	public void setExplosion(Square square) {
		for (int i = 0; i < this.squares.size(); i++) {
			if(square.getLetter() == this.squares.get(i).getLetter() && square.getNum() == this.squares.get(i).getNum()) {
				this.squares.get(i).setTouched();
				this.squares.get(i).setVisited();
			}
			
		}
	}


	public boolean isAllTouched() {
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
