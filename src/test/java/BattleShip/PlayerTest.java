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

}
