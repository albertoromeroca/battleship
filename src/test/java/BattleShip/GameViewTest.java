package BattleShip;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

public class GameViewTest {

	
	GameView view = new GameView();
	ArrayList<Square> squares = new ArrayList<Square>();
	Board board = new Board(squares);
	Player player = new Player("Noui", board);
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	public void testGameView() {
		assertNotNull(view);
	}

	@Test
	public void testRequestLetter() {
        System.setOut(new PrintStream(outContent));
        view.requestLetter(player.getName());
        String expectedOutput  = "Noui introduce a letter: ";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestNum() {
        System.setOut(new PrintStream(outContent));
        view.requestNum(player.getName());
        String expectedOutput  = "Noui introduce a num: ";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestName() {
        System.setOut(new PrintStream(outContent));
        view.requestName();
        String expectedOutput  = "Introduce your name: ";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testShipInformation() {
        System.setOut(new PrintStream(outContent));
        view.shipInformation(player);
        String expectedOutput  = ("Noui" + " has four ships: \n1- AirCraft carrier (length 5)\n" +
        															"2- Destroyer (length 4)\n" +
        															"3- Submarine (length 3)\n" + 
        															"4- Landing craft (length 2)\n");
        ;
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestAirCraftCarrier() {
		System.setOut(new PrintStream(outContent));
        view.requestAirCraftCarrier();
        String expectedOutput  = "Introduce AirCraft carrier(length 5) coordenates.\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestDestroyer() {
		System.setOut(new PrintStream(outContent));
        view.requestDestroyer();
        String expectedOutput  = "Introduce Destroyer (length 4) coordenates.\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestSubmarine() {
		System.setOut(new PrintStream(outContent));
        view.requestSubmarine();
        String expectedOutput  = "Introduce Submarine (length 3) coordenates.\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestLandingCraft() {
		System.setOut(new PrintStream(outContent));
        view.requestLandingCraft();
        String expectedOutput  = "Introduce Landing craft (length 2) coordenates.\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestFirstCoordinate() {
		System.setOut(new PrintStream(outContent));
        view.requestFirstCoordinate();
        String expectedOutput  = "Introduce the firsts coordinates\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testRequestLastCoordinate() {
		System.setOut(new PrintStream(outContent));
        view.requestLastCoordinate();
        String expectedOutput  = "Introduce the lasts coordinates\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testIsWater() {
		System.setOut(new PrintStream(outContent));
        view.isWater();
        String expectedOutput  = "Ups. You miss your target, is WATER.\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testIsTouched() {
		System.setOut(new PrintStream(outContent));
        view.isTouched();
        String expectedOutput  = "Whoa! We have reached de enemy, is TOUCHED.\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testIsDeath() {
		System.setOut(new PrintStream(outContent));
        view.isDeath();
        String expectedOutput  = "Congratulations! One of the enemy's ships is SUNKED.\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testWinner() {
		System.setOut(new PrintStream(outContent));
        view.winner(player);
        String expectedOutput  = "Congratulations Noui! You're the WINNER!!!\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

	@Test
	public void testError() {
		System.setOut(new PrintStream(outContent));
        view.error();
        String expectedOutput  = "Error. Try again.";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}
	
	@Test
	public void testStart() {
		System.setOut(new PrintStream(outContent));
        view.start();
        String expectedOutput  = "\n\nThe game has STARTED.\n\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
	}

}
