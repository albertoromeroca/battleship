package BattleShip;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player("Lucas");
		assertEquals( player.getName(), "Lucas");
	}

	@Test
	public void testGetName() {
		Player player = new Player("Lucas");
		assertEquals( player.getName(), "Lucas");
	}
	
	@Test
	public void testSetName() {
		Player player = new Player("Lucas");
		player.setName("Jose");
		assertEquals(player.getName(),"Jose");
	}
	
	@Test
	public void TestGetShip() {
		Player player = new Player("Lucas");
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
		Player player = new Player("Lucas");
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
		Player player = new Player("Lucas");
		Ship ship1 = new Ship(2);
		player.addShip(ship1);
		Square square1 = new Square("A",1);
		Square square2 = new Square("A",2);
		Square square3 = new Square("A",3);
		ship1.addSquare(square1);
		ship1.addSquare(square2);
		player.isShip(square1);
		player.isShip(square3);
		assertTrue(square1.getTouched());
		assertFalse(square3.getTouched());
	}

}
