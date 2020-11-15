package BattleShip;

import java.util.Scanner;

public class MockScanner implements ScannerInterface {

	private String name;
	private int num;
	private int num2;
	private char letter;
	private char letter2;
	
	public MockScanner(){
		 
	}
	
	public String nextLine() {
		return this.name;
	}
	
	public int nextInt() {
		return this.num;
	}
	
	public char nextChar() {
		return this.letter;
	}
	
	public int nextInt2() {
		return this.num2;
	}
	
	public char nextChar2() {
		return this.letter2;
	}
	
	public void setLine(String name) {
		this.name = name;
	}
	
	public void setInt(int num) {
		this.num = num;
	}
	
	public void setInt2(int num) {
		this.num2 = num;
	}
	
	public void setChar(char letter) {
		this.letter = letter;
	}
	
	public void setChar2(char letter) {
		this.letter2 = letter;
	}
}
