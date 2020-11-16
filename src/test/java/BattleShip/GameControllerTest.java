package BattleShip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class GameControllerTest{

	ArrayList<Square> squares1 = new ArrayList<Square>();
	ArrayList<Square> squares2 = new ArrayList<Square>();
	
	Board board1 = new Board(squares1);
	Board board2 = new Board(squares2);
	
	Player player1 = new Player("NOUI", board1);
	Player player2 = new Player("", board2);
	
	GameView view = new GameView();
	
	private ScannerInterface sc = new MockScanner();
	
	GameController game = new GameController(player1, player2, view, sc);
	
	@Test
	public void testGameController() {
		assertNotNull(game);
	}

	@Test
	public void testCheckLetter() {
		assertTrue(game.checkLetter('A'));
		assertTrue(game.checkLetter('B'));
		assertTrue(game.checkLetter('C'));
		assertTrue(game.checkLetter('D'));
		assertTrue(game.checkLetter('E'));
		assertTrue(game.checkLetter('F'));
		assertFalse(game.checkLetter('9'));
	}

	@Test
	public void testCheckNum() {
		assertTrue(game.checkNum(3));
		assertFalse(game.checkNum(7));
		assertFalse(game.checkNum(0));
		assertTrue(game.checkNum(1));
		assertTrue(game.checkNum(6));
		assertFalse(game.checkNum(70));
	}

	@Test
	public void testCheckName() {
		assertTrue(game.checkName("XXXXX"));
		assertFalse(game.checkName("XXXXXXXXXXX"));
		assertFalse(game.checkName(""));
		assertTrue(game.checkName("X"));
		assertTrue(game.checkName("XXXXXXXXXX"));
	}

	@Test
	public void testCheckSecondName() {
		assertTrue(game.checkSecondName(player1, "CREUS"));
		assertFalse(game.checkSecondName(player1, "NOUI"));
	}

	@Test
	public void testRequestSquare() { 
		
		
		game.getScanner().setChar('A');
		game.getScanner().setInt(1);

		
		Square square = game.requestSquare(player1);
		
		assertEquals(square.getLetter(), 'A');
		assertEquals(square.getNum(), 1);
		assertNotEquals(square.getLetter(), 'Y');
		assertNotEquals(square.getNum(), 0);
		
	}

	@Test
	public void testRequestShip() {

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
		
		Player playerAux = new Player("LUCAS", boardAux);

		GameController gameAux = new GameController(playerAux, player2, view, sc);
		
		gameAux.getScanner().setChar('A');
		gameAux.getScanner().setInt(1);
		gameAux.getScanner().setChar2('C');
		gameAux.getScanner().setInt2(1);
	
		ArrayList<Square> squaresTest = game.requestShip(playerAux, 3);

		assertEquals(squaresTest.get(0).getLetter(),'A');
		assertEquals(squaresTest.get(0).getNum(),1);
		assertEquals(squaresTest.get(1).getLetter(),'B');
		assertEquals(squaresTest.get(1).getNum(),1);
		assertEquals(squaresTest.get(2).getLetter(),'C');
		assertEquals(squaresTest.get(2).getNum(),1);
		
		gameAux.getScanner().setChar('A');
		gameAux.getScanner().setInt(2);
		gameAux.getScanner().setChar2('A');
		gameAux.getScanner().setInt2(4);
	
		ArrayList<Square> squaresTest2 = game.requestShip(playerAux, 3);
		
		assertEquals(squaresTest2.get(0).getLetter(),'A');
		assertEquals(squaresTest2.get(0).getNum(),2);
		assertEquals(squaresTest2.get(1).getLetter(),'A');
		assertEquals(squaresTest2.get(1).getNum(),3);
		assertEquals(squaresTest2.get(2).getLetter(),'A');
		assertEquals(squaresTest2.get(2).getNum(),4);
		
		gameAux.getScanner().setChar('F');
		gameAux.getScanner().setInt(1);
		gameAux.getScanner().setChar2('D');
		gameAux.getScanner().setInt2(1);
	
		ArrayList<Square> squaresTest3 = game.requestShip(playerAux, 3);
		
		assertEquals(squaresTest3.get(0).getLetter(),'D');
		assertEquals(squaresTest3.get(0).getNum(),1);
		assertEquals(squaresTest3.get(1).getLetter(),'E');
		assertEquals(squaresTest3.get(1).getNum(),1);
		assertEquals(squaresTest3.get(2).getLetter(),'F');
		assertEquals(squaresTest3.get(2).getNum(),1);
		
		gameAux.getScanner().setChar('B');
		gameAux.getScanner().setInt(4);
		gameAux.getScanner().setChar2('B');
		gameAux.getScanner().setInt2(2);
	
		ArrayList<Square> squaresTest4 = game.requestShip(playerAux, 3);
		
		assertEquals(squaresTest4.get(0).getLetter(),'B');
		assertEquals(squaresTest4.get(0).getNum(),2);
		assertEquals(squaresTest4.get(1).getLetter(),'B');
		assertEquals(squaresTest4.get(1).getNum(),3);
		assertEquals(squaresTest4.get(2).getLetter(),'B');
		assertEquals(squaresTest4.get(2).getNum(),4);	
	}
	
	@Test
	public void testSetDataPlayerName() { 

		game.getScanner().setLine("LUCAS");
		game.setDataPlayerName(player1);
		
		assertEquals(player1.getName(),"LUCAS");
	}
	
	@Test
	public void testSetDataPlayerAirCraftCarrier() { 

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
		
		Player playerAux = new Player("LUCAS", boardAux);

		GameController gameAux = new GameController(playerAux, player2, view, sc);
		
		gameAux.getScanner().setChar('A');
		gameAux.getScanner().setInt(1);
		gameAux.getScanner().setChar2('A');
		gameAux.getScanner().setInt2(5);
		
		game.setDataPlayerAirCraftCarrier(playerAux);
		
		assertEquals(playerAux.getArrayShips().get(0).getLength(),5);
	}
	
	@Test
	public void testSetDataPlayerDestroyer() { 

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
		
		Player playerAux = new Player("LUCAS", boardAux);

		GameController gameAux = new GameController(playerAux, player2, view, sc);
		
		gameAux.getScanner().setChar('B');
		gameAux.getScanner().setInt(1);
		gameAux.getScanner().setChar2('B');
		gameAux.getScanner().setInt2(4);
		
		game.setDataPlayerDestroyer(playerAux);
		
		assertEquals(playerAux.getArrayShips().get(0).getLength(),4);
	}
	
	@Test
	public void testSetDataPlayerSubmarine() { 

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
		
		Player playerAux = new Player("LUCAS", boardAux);

		GameController gameAux = new GameController(playerAux, player2, view, sc);
		
		gameAux.getScanner().setChar('C');
		gameAux.getScanner().setInt(1);
		gameAux.getScanner().setChar2('C');
		gameAux.getScanner().setInt2(3);
		
		game.setDataPlayerSubmarine(playerAux);
		
		assertEquals(playerAux.getArrayShips().get(0).getLength(),3);
	}
	
	@Test
	public void testSetDataPlayerLandingCraft() { 

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
		
		Player playerAux = new Player("LUCAS", boardAux);

		GameController gameAux = new GameController(playerAux, player2, view, sc);
		
		gameAux.getScanner().setChar('D');
		gameAux.getScanner().setInt(1);
		gameAux.getScanner().setChar2('D');
		gameAux.getScanner().setInt2(2);
		
		game.setDataPlayerLandingCraft(playerAux);
		
		assertEquals(playerAux.getArrayShips().get(0).getLength(),2);
	}
	
	@Test
	public void testTurn() {
		
		ArrayList<Square> squares1 = new ArrayList<Square>();
		Board board1 = new Board(squares1);
		PlayerInterface player1 = new MockPlayer("NOEL", board1);
		
		ArrayList<Square> squares2 = new ArrayList<Square>();
		Board board2 = new Board(squares2);
		PlayerInterface player2 = new MockPlayer("LUCAS", board2);
		
		game.getScanner().setChar('D');
		game.getScanner().setInt(1);
		Square squareAux = new Square('D',1);

		game.turn(player2, player1);
		
		assertTrue(player2.getBoard().isOccupied(squareAux));
			
		game.getScanner().setChar('F');
		game.getScanner().setInt(6);
		Square squareAux2 = new Square('F',6);

		game.turn(player2, player1);
		
		assertFalse(player2.getBoard().isOccupied(squareAux2));
		
		game.getScanner().setChar('D');
		game.getScanner().setInt(2);
		Square squareAux3 = new Square('D',2);

		game.turn(player2, player1);
		
		assertTrue(player2.getShipBySquare(squareAux).getDeath());
	}

	@Test
	public void testTurnWin() {
		
		ArrayList<Square> squares1 = new ArrayList<Square>();
		Board board1 = new Board(squares1);
		PlayerInterface player1 = new MockPlayer("NOEL", board1);
		
		ArrayList<Square> squares2 = new ArrayList<Square>();
		Board board2 = new Board(squares2);
		PlayerInterface player2 = new MockPlayer("LUCAS", board2);
		
		game.getScanner().setChar('D');
		game.getScanner().setInt(1);

		game.turn(player2, player1);
		
		game.getScanner().setChar('D');
		game.getScanner().setInt(2);

		game.turn(player2, player1);
		
		game.getScanner().setChar('C');
		game.getScanner().setInt(1);

		game.turn(player2, player1);
		
		game.getScanner().setChar('C');
		game.getScanner().setInt(2);

		game.turn(player2, player1);
		
		game.getScanner().setChar('C');
		game.getScanner().setInt(3);

		game.turn(player2, player1);
		
		game.getScanner().setChar('B');
		game.getScanner().setInt(1);

		game.turn(player2, player1);
		
		game.getScanner().setChar('B');
		game.getScanner().setInt(2);

		game.turn(player2, player1);
		
		game.getScanner().setChar('B');
		game.getScanner().setInt(3);

		game.turn(player2, player1);
		
		game.getScanner().setChar('D');
		game.getScanner().setInt(1);

		game.turn(player2, player1);
		
		game.getScanner().setChar('B');
		game.getScanner().setInt(4);

		game.turn(player2, player1);
		
		game.getScanner().setChar('D');
		game.getScanner().setInt(1);

		game.turn(player2, player1);
		
		game.getScanner().setChar('A');
		game.getScanner().setInt(1);

		game.turn(player2, player1);
		
		assertFalse(game.getWin());
		
		game.getScanner().setChar('A');
		game.getScanner().setInt(2);

		game.turn(player2, player1);
		
		game.getScanner().setChar('A');
		game.getScanner().setInt(3);

		game.turn(player2, player1);
		
		game.getScanner().setChar('A');
		game.getScanner().setInt(4);

		game.turn(player2, player1);
		
		game.getScanner().setChar('A');
		game.getScanner().setInt(5);

		game.turn(player2, player1);
		
		assertTrue(game.getWin());
	
	}
	
	@Test
	public void testGetWin() { 
		assertFalse(game.getWin());
	}
}
