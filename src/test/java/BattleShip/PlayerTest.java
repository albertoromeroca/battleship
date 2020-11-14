package BattleShip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		squares.add(square2);
		Board board = new Board(squares);
		Player player = new Player("Lucas", board);
		assertEquals( player.getName(), "Lucas");
	}

	@Test
	public void testGetName() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		squares.add(square2);
		Board board = new Board(squares);
		Player player = new Player("Lucas", board);
		assertEquals( player.getName(), "Lucas");
	}
	
	@Test
	public void testSetName() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		squares.add(square2);
		Board board = new Board(squares);
		Player player = new Player("Lucas", board);
		player.setName("Jose");
		assertEquals(player.getName(),"Jose");
	}
	
	@Test
	public void TestGetShip() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		squares.add(square2);
		Board board = new Board(squares);
		Player player = new Player("Lucas", board);
		Ship ship1 = new Ship(2);
		Ship ship2 = new Ship(3);
		Ship ship3 = new Ship(4);
		player.addShip(ship1);
		player.addShip(ship2);
		player.addShip(ship3);
		assertEquals(player.getShip(2).getLength(),2);
		assertEquals(player.getShip(3).getLength(),3);
		assertEquals(player.getShip(4).getLength(),4);
	}
	
	@Test
	public void testAddShip() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		squares.add(square2);
		Board board = new Board(squares);
		Player player = new Player("Lucas", board);
		Ship ship1 = new Ship(2);
		Ship ship2 = new Ship(3);
		Ship ship3 = new Ship(4);
		player.addShip(ship1);
		player.addShip(ship2);
		player.addShip(ship3);
		assertEquals(player.getShip(2).getLength(),2);
		assertEquals(player.getShip(3).getLength(),3);
		assertEquals(player.getShip(4).getLength(),4);
	}
	
	@Test
	public void TestIsShip() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		Square square3 = new Square('A',3);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		squares.add(square2);
		Board board = new Board(squares);
		Player player = new Player("Lucas", board);
		Ship ship1 = new Ship(2);
		player.addShip(ship1);
		
		ship1.addSquare(square1);
		ship1.addSquare(square2);
		player.isShip(square1);
		player.isShip(square3);
		assertTrue(square1.getTouched());
		assertFalse(square3.getTouched());
	}
	
	@Test
	public void testGetBoard() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		squares.add(square2);
		Board board = new Board(squares);
		Player player = new Player("Lucas", board);
		assertEquals( player.getBoard(), board);
	}

}
