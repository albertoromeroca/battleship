package BattleShip;

import java.util.ArrayList;

public class Board {

	/*Attributes*/
	
	private ArrayList<Square> board = new ArrayList<Square>();	
	
		
	/*Methods*/
	
	public Board(ArrayList<Square> board) { //Done
		this.board = board;
	}
	
	public boolean exists(Square square) {
		boolean exists = false;
		for (int i = 0; i < this.board.size(); i++) {
			if(square.getLetter() == this.board.get(i).getLetter() && square.getNum() == this.board.get(i).getNum()) {
				exists = true;
			}
			
		}
		return exists;
	}
	
	public ArrayList<Square> getBoard() {
		return this.board;
	}
	
}
