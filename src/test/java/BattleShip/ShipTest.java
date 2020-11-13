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

}
