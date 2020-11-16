package BattleShip;

import java.util.ArrayList;

public interface PlayerInterface {
	
	public void setName(String name);

	public void isShip(Square square);
	
	public ShipInterface getShipBySquare(Square square);

	public void addShip(ShipInterface ship);
	
	public ShipInterface getShip(int length);
	
	public ArrayList<ShipInterface> getArrayShips();
	
	public Board getBoard();
	
	public String getName();
}
