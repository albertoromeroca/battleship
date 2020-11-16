package BattleShip;

import java.util.ArrayList;

public class Player implements PlayerInterface {

	/*Attributes*/
	
	private String name;
	private ArrayList<ShipInterface> ships;
	private Board board;
	
	/*Methods*/
	
	public Player(String name, Board board) { //Done
		this.ships = new ArrayList<ShipInterface>();
		this.board = board;
		this.name = name;
		
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
	
	public ShipInterface getShipBySquare(Square square) {
		ShipInterface ship = null;
		for (int i = 0; i < this.ships.size(); i++) {
			if(this.ships.get(i).getSquareByCoord(square) >= 0) {
				ship = this.ships.get(i);
			}
		}
		return ship;
	}

	public void addShip(ShipInterface ship) {
		this.ships.add(ship);	
	}
	
	public ShipInterface getShip(int length) {
		ShipInterface ship = null;
		for (int i = 0; i < this.ships.size(); i++) {
			if(this.ships.get(i).getLength() == length) {
				ship = this.ships.get(i);
			}	
		}
		return ship;
	}
	
	public ArrayList<ShipInterface> getArrayShips() {
		return this.ships;
	}
	
	
	public Board getBoard() { //Done
		return this.board;
	}
		
}
