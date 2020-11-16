package BattleShip;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

	@Test
	public void testSquare() {
		Square square = new Square('A',1);
		assertEquals( square.getNum(), 1);
		assertEquals( square.getLetter(), 'A');
		assertFalse(square.getOccupied());
		assertFalse(square.getVisited());
		assertFalse(square.getTouched());
		assertNotNull(square);
	}

	@Test
	public void testSetNum() {
		Square square = new Square('A',1);
		square.setNum(2);
		assertEquals(square.getNum(),2);
	}

	@Test
	public void testGetNum() {
		Square square = new Square('A',1);
		assertEquals( square.getNum(), 1);
		assertNotEquals( square.getNum(), 2);
	}

	@Test
	public void testSetLetter() {
		Square square = new Square('A',1);
		square.setLetter('B');
		assertEquals(square.getLetter(),'B');
	}

	@Test
	public void testGetLetter() {
		Square square = new Square('A',1);
		assertEquals(square.getLetter(), 'A');
		assertNotEquals(square.getLetter(),'B');
	}

	@Test
	public void testSetOccupied() {
		Square square = new Square('A',1);
		square.setOccupied();
		assertTrue(square.getOccupied());
	}

	@Test
	public void testGetOccupied() {
		Square square = new Square('A',1);
		assertFalse(square.getOccupied());
	}
	
	@Test
	public void testSetVisited() {
		Square square = new Square('A',1);
		square.setVisited();
		assertTrue(square.getVisited());
	}

	@Test
	public void testGetVisited() {
		Square square = new Square('A',1);
		assertFalse(square.getVisited());
	}
	
	@Test
	public void testSetTouched() {
		Square square = new Square('A',1);
		square.setTouched();
		assertTrue(square.getTouched());
	}

	@Test
	public void testGetTouched() {
		Square square = new Square('A',1);
		assertFalse(square.getTouched());
	}
}
