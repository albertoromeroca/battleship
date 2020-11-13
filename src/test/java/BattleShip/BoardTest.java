package BattleShip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testBoard() {
		Square square = new Square("A", 1);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square);
		Board board = new Board(squares);
		assertEquals(squares, board.getBoard());
	}

	@Test
	public void testExists() {
		Square square = new Square("A", 1);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(square);
		Board board = new Board(squares);
		assertTrue(board.exists(square));
	}

}
