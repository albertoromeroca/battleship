package BattleShip;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class BoardTest {

	private Square square1 = new Square('A', 1);
	private Square square2 = new Square('A', 2);
	private Square square3 = new Square('B', 2);
	private Square square4 = new Square('B', 3);
	private ArrayList<Square> squares = new ArrayList<Square>();
	private Board board = new Board(squares);
	
	@Test
	public void testIsVisited() {
		
		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		squares.add(square4);
		
		square1.setVisited();
		square3.setVisited();
		
		assertTrue(board.isVisited(square1));
		assertTrue(board.isVisited(square3));
		assertFalse(board.isVisited(square2));
		assertFalse(board.isVisited(square4));
	}

	@Test
	public void testGetPosition() {

		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		squares.add(square4);
		
		assertEquals(board.getPosition(square1),0);
		assertEquals(board.getPosition(square2),1);
		assertEquals(board.getPosition(square3),2);
		assertEquals(board.getPosition(square4),3);
	}

	@Test
	public void testIsOccupied() {

		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		squares.add(square4);

		square1.setOccupied();
		square3.setOccupied();
		
		assertTrue(board.isOccupied(square1));
		assertTrue(board.isOccupied(square3));
		assertFalse(board.isOccupied(square2));
		assertFalse(board.isOccupied(square4));
	}

	@Test
	public void testSetVisited() {
		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		squares.add(square4);
		
		board.setVisited(square1);
		board.setVisited(square3);
			
		assertTrue(square1.getVisited());
		assertTrue(square3.getVisited());
		assertFalse(square2.getVisited());
		assertFalse(square4.getVisited());
	}

	@Test
	public void testGetBoard() {
		
		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		squares.add(square4);
		
		ArrayList<Square> board1 = board.getBoard();
		
		assertEquals(squares.get(0).getNum(), board1.get(0).getNum());
		assertEquals(squares.get(1).getNum(), board1.get(1).getNum());
		assertEquals(squares.get(2).getNum(), board1.get(2).getNum());
		assertEquals(squares.get(3).getNum(), board1.get(3).getNum());
		assertEquals(squares.get(0).getLetter(), board1.get(0).getLetter());
		assertEquals(squares.get(1).getLetter(), board1.get(1).getLetter());
		assertEquals(squares.get(2).getLetter(), board1.get(2).getLetter());
		assertEquals(squares.get(3).getLetter(), board1.get(3).getLetter());
	}

	@Test
	public void testGetSquareByPos() {
		
		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		squares.add(square4);
		
		assertEquals(board.getSquareByPos(0).getNum(),square1.getNum());
		assertEquals(board.getSquareByPos(1).getNum(),square2.getNum());
		assertEquals(board.getSquareByPos(2).getNum(),square3.getNum());
		assertEquals(board.getSquareByPos(3).getNum(),square4.getNum());	
		assertEquals(board.getSquareByPos(0).getLetter(),square1.getLetter());
		assertEquals(board.getSquareByPos(1).getLetter(),square2.getLetter());
		assertEquals(board.getSquareByPos(2).getLetter(),square3.getLetter());
		assertEquals(board.getSquareByPos(3).getLetter(),square4.getLetter());
	}
	
	@Test
	public void testBoard() {
		
		squares.add(square1);
		Board board = new Board(squares);
		assertEquals(squares, board.getBoard());
	}

	@Test
	public void testExists() {

		squares.add(square1);

		assertTrue(board.exists(square1));
		assertFalse(board.exists(square2));
		assertFalse(board.exists(square3));
		assertFalse(board.exists(square4));
	}

}
