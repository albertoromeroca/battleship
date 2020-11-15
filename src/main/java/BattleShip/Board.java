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
		
	public boolean isVisited(Square square) {
		boolean visited = false;
		for (int i = 0; i < this.board.size(); i++) {
			if(square.getLetter() == this.board.get(i).getLetter() && square.getNum() == this.board.get(i).getNum()) {
				if(board.get(i).getVisited()) {
					visited = true;
				}
			}
			
		}
		return visited;
	}
	
	public int getPosition(Square square) {
		boolean found = false;
		int i = 0;
		int position = 0;
		while(!found) {
			if(square.getLetter() == this.board.get(i).getLetter() && square.getNum() == this.board.get(i).getNum()) {
				position =  i;
				found = true;
			}else {
				i++;
			}
			
		}
		return position;
	}
	
	public boolean isOccupied(Square square) {
		boolean occupied = false;
		for (int i = 0; i < this.board.size(); i++) {
			if(square.getLetter() == this.board.get(i).getLetter() && square.getNum() == this.board.get(i).getNum()) {
				if(board.get(i).getOccupied()) {
					occupied = true;
				}
			}
			
		}
		return occupied;
	}
	
	public void setVisited(Square square) {
		for (int i = 0; i < this.board.size(); i++) {
			if(square.getLetter() == this.board.get(i).getLetter() && square.getNum() == this.board.get(i).getNum()) {
				board.get(i).setVisited();
			}
			
		}
	}
	
	public ArrayList<Square> getBoard() {
		return this.board;
	}
	
	public Square getSquareByPos(int pos) {
		return this.board.get(pos);
	}
	
	
}
