package BattleShip;

import java.util.ArrayList;

public class Player {

	/*Attributes*/
	
	private String name;
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	
	/*Methods*/
	
	public Player(String name) { //Done
		this.name = name;
	}
	
	public void setName(String name) { //Done
		this.name = name;
	}
	
	public String getName() { //Done
		return this.name;
	}
	
	
	
	
}
