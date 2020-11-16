package BattleShip;

import java.util.ArrayList;

public class MockPlayer implements PlayerInterface{
	
	private String name;
	private ArrayList<ShipInterface> ships;
	private Board board;
	
	public MockPlayer(String name, Board board) { 
		
		this.name = name;
		
		ArrayList<Square> squaresAux = new ArrayList<Square>();
		
		for(int i = 1; i < 7; i++) {
			Square square1 = new Square('A',i);
			Square square2 = new Square('B',i);
			Square square3 = new Square('C',i);
			Square square4 = new Square('D',i);
			Square square5 = new Square('E',i);
			Square square6 = new Square('F',i);
			squaresAux.add(square1);
			squaresAux.add(square2);
			squaresAux.add(square3);
			squaresAux.add(square4);
			squaresAux.add(square5);
			squaresAux.add(square6);
		}
		
		Board boardAux = new Board(squaresAux);
		boardAux.getSquareByPos(3).setOccupied();
		boardAux.getSquareByPos(9).setOccupied();
		boardAux.getSquareByPos(2).setOccupied();
		boardAux.getSquareByPos(8).setOccupied();
		boardAux.getSquareByPos(14).setOccupied();
		boardAux.getSquareByPos(1).setOccupied();
		boardAux.getSquareByPos(7).setOccupied();
		boardAux.getSquareByPos(13).setOccupied();
		boardAux.getSquareByPos(19).setOccupied();
		boardAux.getSquareByPos(0).setOccupied();
		boardAux.getSquareByPos(6).setOccupied();
		boardAux.getSquareByPos(12).setOccupied();
		boardAux.getSquareByPos(18).setOccupied();
		boardAux.getSquareByPos(24).setOccupied();
		
		
		this.board = boardAux;
		
		MockShip ship1 = new MockShip(2);
		MockShip ship2 = new MockShip(3);
		MockShip ship3 = new MockShip(4);
		MockShip ship4 = new MockShip(5);
		
		ArrayList<ShipInterface> shipsAux = new ArrayList<ShipInterface>();
		
		shipsAux.add(ship1);
		shipsAux.add(ship2);
		shipsAux.add(ship3);
		shipsAux.add(ship4);

		this.ships = shipsAux;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	public ShipInterface getShip(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ShipInterface> getArrayShips() {
		return this.ships;
	}

	public Board getBoard() {
		return this.board;
	}


	public String getName() {
		return this.name;
	}
	
}
