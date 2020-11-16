package BattleShip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {

	private Square square1 = new Square('A', 1);
	private Square square2 = new Square('A', 2);
	private Square square3 = new Square('A', 3);
	private Square square4 = new Square('A', 4);
	private Square square5 = new Square('A', 5);
	private ArrayList<Square> squares = new ArrayList<Square>();
	private ArrayList<Square> squares2 = new ArrayList<Square>();
	private Board board = new Board(squares);
	private Player player = new Player("Lucas", board);
	private Ship ship1 = new Ship(2);
	private Ship ship2 = new Ship(3);
	private Ship ship3 = new Ship(4);
	
	@Test
	public void testPlayer() {

		squares.add(square1);
		squares.add(square2);
		
		assertEquals( player.getName(), "Lucas");
	}

	@Test
	public void testGetName() {

		squares.add(square1);
		squares.add(square2);
		
		assertEquals( player.getName(), "Lucas");
	}
	
	@Test
	public void testSetName() {

		squares.add(square1);
		squares.add(square2);

		player.setName("Jose");
		assertEquals(player.getName(),"Jose");
	}
	
	@Test
	public void TestGetShip() {

		squares.add(square1);
		squares.add(square2);
		player.addShip(ship1);
		player.addShip(ship2);
		player.addShip(ship3);
		
		assertEquals(player.getShip(2).getLength(),2);
		assertEquals(player.getShip(3).getLength(),3);
		assertEquals(player.getShip(4).getLength(),4);
	}
	
	@Test
	public void testAddShip() {

		squares.add(square1);
		squares.add(square2);
		player.addShip(ship1);
		player.addShip(ship2);
		player.addShip(ship3);
		
		assertEquals(player.getShip(2).getLength(),2);
		assertEquals(player.getShip(3).getLength(),3);
		assertEquals(player.getShip(4).getLength(),4);
	}
	
	@Test
	public void TestIsShip() {

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
			player.isShip(square1);
			assertFalse(square1.getTouched());
			assertFalse(square2.getTouched());
			assertFalse(square3.getTouched());
			assertFalse(square4.getTouched());
			assertFalse(square5.getTouched());
		}
		
		squares.add(square1);
        squares.add(square2);
        player.addShip(ship1);
        ship1.addSquares(squares);
        player.isShip(square1);
        player.isShip(square2);
        player.isShip(square3);

        assertTrue(square1.getTouched());
        assertTrue(square2.getTouched());
        assertFalse(square3.getTouched());
	}
	
	@Test
	public void testGetBoard() {

		squares.add(square1);
		squares.add(square2);

		assertEquals( player.getBoard(), board);
	}
	
	@Test
	public void testGetArrayShips() {

		squares.add(square1);
		squares.add(square2);
		squares2.add(square3);
		squares2.add(square4);
		squares2.add(square5);
		ship1.addSquares(squares);
		ship2.addSquares(squares2);
		player.addShip(ship1);
		player.addShip(ship2);
		
		assertEquals( player.getArrayShips().get(0).getLength(), 2);
		assertEquals( player.getArrayShips().get(1).getLength(), 3);
		
	}
	
	@Test
	public void testGetShipBySquare() {

		squares.add(square1);
		squares.add(square2);
		player.addShip(ship1);
		ship1.addSquares(squares);
		
		assertEquals(player.getShipBySquare(square1).getLength(),2);
		assertEquals(player.getShipBySquare(square3),null);
	}

}
