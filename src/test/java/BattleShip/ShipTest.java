package BattleShip;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShipTest {

	@Test
	public void testShip() {
		Ship ship = new Ship(2);
		assertEquals(ship.getLength(),2);
		assertFalse(ship.getDeath());
	}

	@Test
	public void testSetLength() {
		Ship ship = new Ship(2);
		ship.setLength(3);
		assertEquals(ship.getLength(),3);
	}

	@Test
	public void testGetLength() {
		Ship ship = new Ship(2);
		assertEquals(ship.getLength(),2);
	}

	@Test
	public void testSetDeath() {
		Ship ship = new Ship(2);
		ship.setDeath();
		assertTrue(ship.getDeath());
	}

	@Test
	public void testGetDeath() {
		Ship ship = new Ship(2);
		assertFalse(ship.getDeath());
	}

	@Test
	public void testSetExplosion() {
		Ship ship = new Ship(2);
		Square square1 = new Square("A", 1);
		Square square2 = new Square("A", 2);
		ship.addSquare(square1);
		ship.addSquare(square2);
		ship.setExplosion(square1);
		assertTrue(square1.getTouched());
		assertTrue(square1.getVisited());
		assertFalse(square2.getTouched());
		assertFalse(square2.getVisited());
		
	}
	
	@Test
	public void testGetSquareByCoord() {
		Ship ship = new Ship(2);
		Square square1 = new Square("A", 1);
		Square square2 = new Square("A", 2);
		Square square3 = new Square("B", 2);
		Square square4 = new Square("B", 3);
		ship.addSquare(square1);
		ship.addSquare(square2);
		assertEquals(ship.getSquareByCoord(square1),0);
		assertEquals(ship.getSquareByCoord(square2),1);
		assertEquals(ship.getSquareByCoord(square3),-1);
		assertEquals(ship.getSquareByCoord(square4),-1);
	}
}
