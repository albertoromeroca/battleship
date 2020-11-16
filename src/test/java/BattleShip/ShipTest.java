package BattleShip;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class ShipTest {

	private Ship ship = new Ship(2);
	private Ship ship2 = new Ship(3);
	private Square square1 = new Square('A', 1);
	private Square square2 = new Square('A', 2);
	private Square square3 = new Square('B', 2);
	private Square square4 = new Square('A', 3);
	private Square square5 = new Square('A', 5);
	private ArrayList<Square> squares = new ArrayList<Square>();
	private ArrayList<Square> squares2 = new ArrayList<Square>();
	
	@Test
	public void testShip() {

		assertEquals(ship.getLength(),2);
		assertFalse(ship.getDeath());
	}

	@Test
	public void testSetLength() {

		ship.setLength(3);
		assertEquals(ship.getLength(),3);
	}

	@Test
	public void testGetLength() {

		assertEquals(ship.getLength(),2);
	}

	@Test
	public void testSetDeath() {

		ship.setDeath();
		assertTrue(ship.getDeath());
	}

	@Test
	public void testGetDeath() {

		assertFalse(ship.getDeath());
	}

	@Test
	public void testSetExplosion() {

		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		ship2.addSquares(squares);
		ship2.setExplosion(square1);
		assertTrue(square1.getTouched());
		assertTrue(square1.getVisited());
		assertFalse(square2.getTouched());
		assertFalse(square2.getVisited());
		assertFalse(square3.getTouched());
		assertFalse(square3.getVisited());
		
		
	}
	
	@Test
	public void testGetSquareByCoord() {

		squares.add(square1);
		squares.add(square2);
		
		ship.addSquares(squares);
		assertEquals(ship.getSquareByCoord(square1),0);
		assertEquals(ship.getSquareByCoord(square2),1);
		assertEquals(ship.getSquareByCoord(square3),-1);
		assertEquals(ship.getSquareByCoord(square4),-1);
	}
	
	@Test
	public void testIsAllTouched() {
		
		squares.add(square1);
		squares.add(square2);
		ship.addSquares(squares);
		ship.setExplosion(square1);
		ship.setExplosion(square2);
		
		squares2.add(square3);
		squares2.add(square4);
		squares2.add(square5);
		ship2.addSquares(squares2);
		
		assertTrue(ship.isAllTouched());
		assertFalse(ship2.isAllTouched());
	}
	
	@Test
	public void testAddSquares() {
		
		squares.add(square1);
		squares.add(square2);
		ship.addSquares(squares);
		ship.setExplosion(square1);
		
		assertTrue(square1.getTouched());
		assertTrue(square1.getVisited());
		assertFalse(square2.getTouched());
		assertFalse(square2.getVisited());
	}
	
}
