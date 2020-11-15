package BattleShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameController {

	/*Attributes*/
	
	private Player player1;
	private Player player2;
	private int turn;
	private boolean win;
	private GameView view;
	private ScannerInterface scanner;
	
	/*Methods*/
	
	public GameController(Player player1, Player player2, GameView view, ScannerInterface scanner ) { //Done
		this.player1 = player1;
		this.player2 = player2;
		this.turn = 2;
		this.win = false;
		this.view = view;
		this.scanner = scanner;
	}
	
	public ScannerInterface getScanner() { //Done
		return this.scanner;
	}
	
	public void turn(Player player, Player player2) {
		//bucleTurno
		Square square;
		boolean aux = false;
		do{
			if(aux){ 
				this.view.error();
			}
			square = this.requestSquare(player2);
			aux = true;
		}while(player.getBoard().isVisited(square));
		
		if(!player.getBoard().isOccupied(square)) {
			player.getBoard().setVisited(square);
			this.view.isWater();
		}else {
			player.isShip(square);
			this.view.isTouched();
			if(player.getShipBySquare(square).isAllTouched()) {
				player.getShipBySquare(square).setDeath();
				this.view.isDeath();
				int sunkedShips = 0;
				for(int i = 0; i<player.getArrayShips().size(); i++){
					if(player.getArrayShips().get(i).getDeath()) {
						sunkedShips++;
					}
				if(sunkedShips == 4) {
					this.view.winner(player2);
					this.win=true;
				}
				}
			}
		}

	}
		
	public void setDataPlayerName(Player player) {
		String name;
		do {
			this.view.requestName();
			name = this.scanner.nextLine();
		}while( this.checkName(name) && !this.checkSecondName(this.player1, name));
		
		player.setName(name);
		
		view.shipInformation(player);
	}
	
	public void setDataPlayerAirCraftCarrier(Player player) {
		//view.requestAirCraftCarrier();
		ArrayList<Square> squares1 = this.requestShip(player, 5);
		Ship ship1 = new Ship(5);
		ship1.addSquares(squares1);
		player.addShip(ship1);
	}
	
	public void setDataPlayerDestroyer(Player player) {
		view.requestDestroyer();
		ArrayList<Square> squares1 = this.requestShip(player, 4);
		Ship ship1 = new Ship(4);
		ship1.addSquares(squares1);
		player.addShip(ship1);
	}
	
	public void setDataPlayerSubmarine(Player player) {
		view.requestSubmarine();
		ArrayList<Square> squares1 = this.requestShip(player, 3);
		Ship ship1 = new Ship(3);
		ship1.addSquares(squares1);
		player.addShip(ship1);
	}
	
	public void setDataPlayerLandingCraft(Player player) {
		view.requestLandingCraft();
		ArrayList<Square> squares1 = this.requestShip(player, 2);
		Ship ship1 = new Ship(2);
		ship1.addSquares(squares1);
		player.addShip(ship1);
	}
	
	
	public void play() {
		//bucleJuego
		this.view.start();
		do {
			if(turn%2 == 0) {
				turn(this.player2, this.player1); // juega player1 se mirara data del player2
			}else {
				turn(this.player1, this.player2); // juega player2 se mirara data del player1
			}
			turn++;
		}while(!this.win);
	}
	
	public boolean checkLetter(char letter) {
		if(letter == 'A' || letter == 'B'|| letter == 'C'|| letter == 'D'|| letter == 'E'|| letter == 'F') {
			return true;
		}else {
			this.view.error();
			return false;
		}
	}
	
	public boolean checkNum(int num) {
		if(num >= 1 && num <= 6){
			return true;
		}else {
			this.view.error();
			return false;
		}
	}
	
	public boolean checkName(String name) {
		if(name.length() <= 10 && name.length() >= 1){
			return true;
		}else {
			this.view.error();
			return false;
		}
	}
	
	public boolean checkSecondName(Player player1, String name2 ) {
		if(player1.getName() != name2){
			return true;
		}else {
			this.view.error();
			return false;
		}
	}
	
	public Square requestSquare(Player player){ //Pairwise testing
		char letter;
		int num; 
		do{
			this.view.requestLetter(player.getName());
			letter = this.scanner.nextChar();
		}while(!this.checkLetter(letter));
		do {
			this.view.requestNum(player.getName());
			num = this.scanner.nextInt(); 
		}while(!this.checkNum(num));

		Square square = new Square(letter, num);		
		return square;
		
	}
	
	public ArrayList<Square> requestShip(Player player, int length){
		
		char letter1;
		int num1;
		char letter2;
		int num2;
		this.view.requestFirstCoordinate();
		do{
			this.view.requestLetter(player.getName());
			letter1 = this.scanner.nextChar();
		}while(!this.checkLetter(letter1));
		
		do {
			this.view.requestNum(player.getName());
			num1 = this.scanner.nextInt(); 
		}while(!this.checkNum(num1));
		
		
		
		this.view.requestLastCoordinate();
		do{
			this.view.requestLetter(player.getName());
			letter2 = this.scanner.nextChar2();
		}while(!this.checkLetter(letter2));
		
		do {
			this.view.requestNum(player.getName());
			num2 = this.scanner.nextInt2(); 
		}while(!this.checkNum(num2));
		
		
		Square firstSquare;
		Square lastSquare;
		
		char aux[] = {letter1,letter2};
		char sorted[] = {letter1,letter2};
		Arrays.sort(sorted);
		
		boolean vertical = false;
		
		if(num1 < num2) { //horizontal
			firstSquare = new Square(letter1, num1);
			lastSquare = new Square(letter2, num2);
		}else if(num1 > num2){
			firstSquare = new Square(letter2, num2);
			lastSquare = new Square(letter1, num1);
		}else { //vertical
			vertical = true;
			if(aux[0] == sorted[0]) {
				firstSquare = new Square(letter1, num1);
				lastSquare = new Square(letter2, num2);
			}else {
				firstSquare = new Square(letter2, num2);
				lastSquare = new Square(letter1, num1);
			}
		}
		
		boolean correct = true;
		if (num1 != num2 && letter1 != letter2) { correct = false;}
		
		int cont = 2;
		if(!player.getBoard().isOccupied(firstSquare) && !player.getBoard().isOccupied(lastSquare)) {
			if(vertical) {
				for(int i = player.getBoard().getPosition(firstSquare) + 1; i < player.getBoard().getPosition(lastSquare); i++) {
					if(player.getBoard().getSquareByPos(i).getOccupied() ) {
						correct = false;
					}
					cont++;
					}
			}else{
				for(int i = player.getBoard().getPosition(firstSquare) + 6; i < player.getBoard().getPosition(lastSquare); i += 6) {
					if(player.getBoard().getSquareByPos(i).getOccupied() ) {
						correct = false;
					}
					cont++;
					}
				}
		}else{
			correct = false;
		}
		
		if( cont != length) {correct = false;}

		ArrayList<Square> squares = new ArrayList<Square>();
		if (correct) {
			if(vertical) {
				for(int i = player.getBoard().getPosition(firstSquare); i <= player.getBoard().getPosition(lastSquare); i++) {
					if(!player.getBoard().getSquareByPos(i).getOccupied() ) {
						squares.add(player.getBoard().getSquareByPos(i));
					}
					}
			}else{
				for(int i = player.getBoard().getPosition(firstSquare); i <= player.getBoard().getPosition(lastSquare); i = i + 6) {
					if(!player.getBoard().getSquareByPos(i).getOccupied() ) {
						squares.add(player.getBoard().getSquareByPos(i));
					}
					}
				}
		}else {
			this.view.error();
			this.requestShip(player, length);
		}
		return squares;
	}

}
