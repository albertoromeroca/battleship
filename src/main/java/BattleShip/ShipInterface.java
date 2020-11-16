package BattleShip;

import java.util.ArrayList;

public interface ShipInterface {
	
	public void setLength(int length);
	
	public int getLength();
	
	public void setDeath();
	
	public boolean getDeath();
	
	public void addSquares(ArrayList<Square> squares);
	
	public int getSquareByCoord(Square square);
		
	public void setExplosion(Square square);
	
	public boolean isAllTouched();
}
