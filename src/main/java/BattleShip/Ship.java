package BattleShip;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Ship {

	/*Attributes*/
	
	private int length;
	private boolean death;
	private Square[] squares;
	
	
	/*Methods*/
	
	public Ship(int length) { //Done
		this.length = length;
		this.death = false;
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
	
}
