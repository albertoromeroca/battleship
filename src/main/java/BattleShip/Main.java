package BattleShip;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Square> squares1 = new ArrayList<Square>();
		ArrayList<Square> squares2 = new ArrayList<Square>();
		
		for(int i = 1; i < 7; i++) {
			Square square1 = new Square('A',i);
			Square square2 = new Square('B',i);
			Square square3 = new Square('C',i);
			Square square4 = new Square('D',i);
			Square square5 = new Square('E',i);
			Square square6 = new Square('F',i);
			squares1.add(square1);
			squares1.add(square2);
			squares1.add(square3);
			squares1.add(square4);
			squares1.add(square5);
			squares1.add(square6);
		}
		
		for(int i = 1; i < 7; i++) {
			Square square1 = new Square('A',i);
			Square square2 = new Square('B',i);
			Square square3 = new Square('C',i);
			Square square4 = new Square('D',i);
			Square square5 = new Square('E',i);
			Square square6 = new Square('F',i);
			squares2.add(square1);
			squares2.add(square2);
			squares2.add(square3);
			squares2.add(square4);
			squares2.add(square5);
			squares2.add(square6);
		}
		
		Board board1 = new Board(squares1);
		Board board2 = new Board(squares2);
		
		Player player1 = new Player("", board1);
		Player player2 = new Player("", board2);
		
		GameView view = new GameView();
		
		ScannerInterface scanner = new OurScanner();
		
		GameController game = new GameController(player1, player2, view, scanner);
		
		game.setDataPlayerName(player1);
		game.setDataPlayerAirCraftCarrier(player1);
		game.setDataPlayerDestroyer(player1);
		game.setDataPlayerSubmarine(player1);
		game.setDataPlayerLandingCraft(player1);
		game.setDataPlayerName(player2);
		game.setDataPlayerAirCraftCarrier(player2);
		game.setDataPlayerDestroyer(player2);
		game.setDataPlayerSubmarine(player2);
		game.setDataPlayerLandingCraft(player2);
		
		game.play();
	}

}
