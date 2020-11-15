package BattleShip;

import java.util.ArrayList;

public class Player {

	/*Attributes*/
	
	private String name;
	private ArrayList<Ship> ships;
	private Board board;
	
	/*Methods*/
	
	public Player(String name, Board board) { //Done
		this.name = name;
		this.ships = new ArrayList<Ship>();
		this.board = board;
		
	}
	
	public void setName(String name) { //Done
		this.name = name;
	}
	
	public String getName() { //Done
		return this.name;
	}

	public void isShip(Square square) {
		for (int i = 0; i < this.ships.size(); i++) {
			if(this.ships.get(i).getSquareByCoord(square) >= 0) {
				this.ships.get(i).setExplosion(square);
			}
		}
	}
	
	public Ship getShipBySquare(Square square) {
		Ship ship = null;
		for (int i = 0; i < this.ships.size(); i++) {
			if(this.ships.get(i).getSquareByCoord(square) >= 0) {
				ship = this.ships.get(i);
			}
		}
		return ship;
	}

	public void addShip(Ship ship) {
		this.ships.add(ship);	
	}
	
	public Ship getShip(int length) {
		Ship ship = null;
		for (int i = 0; i < this.ships.size(); i++) {
			if(this.ships.get(i).getLength() == length) {
				ship = this.ships.get(i);
			}	
		}
		return ship;
	}
	
	public ArrayList<Ship> getArrayShips() {
		return this.ships;
	}
	
	
	public Board getBoard() { //Done
		return this.board;
	}
		
}
