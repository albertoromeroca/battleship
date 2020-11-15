package BattleShip;

import java.util.Scanner;

public class OurScanner implements ScannerInterface{

	private Scanner sc;
	
	public OurScanner(){
		this.sc = new Scanner(System.in); 
	}
	
	public String nextLine() {
		return this.sc.nextLine();
	}
	
	public int nextInt() {
		return this.sc.nextInt();
	}
	
	public char nextChar() {
		return this.sc.next().charAt(0);
	}
	
	public int nextInt2() {
		return this.sc.nextInt();
	}
	
	public char nextChar2() {
		return this.sc.next().charAt(0);
	}

	public void setLine(String name) {
		// TODO Auto-generated method stub	
	}

	public void setInt(int num) {
		// TODO Auto-generated method stub	
	}

	public void setChar(char letter) {
		// TODO Auto-generated method stub	
	}


	public void setInt2(int num) {
		// TODO Auto-generated method stub	
	}


	public void setChar2(char letter) {
		// TODO Auto-generated method stub	
	}
	
}
