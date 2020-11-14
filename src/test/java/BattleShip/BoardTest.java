package BattleShip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testBoard() {
		Square square = new Square('A', 1);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square);
		Board board = new Board(squares);
		assertEquals(squares, board.getBoard());
	}

	@Test
	public void testExists() {
		Square square1 = new Square('A', 1);
		Square square2 = new Square('A', 2);
		Square square3 = new Square('B', 2);
		Square square4 = new Square('B', 3);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square1);
		Board board = new Board(squares);
		assertTrue(board.exists(square1));
		assertFalse(board.exists(square2));
		assertFalse(board.exists(square3));
		assertFalse(board.exists(square4));
		
		
	}

}
