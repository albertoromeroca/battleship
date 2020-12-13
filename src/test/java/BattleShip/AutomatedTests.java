package BattleShip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

public class AutomatedTests {

	public static void main(String[] args) throws IOException {
		Reader myTest1 = new Reader("src/Tests/test1.txt");
		
		ArrayList<Square> squaresOne = new ArrayList<Square>();
		ArrayList<Square> squaresTwo = new ArrayList<Square>();
		
		Board board1 = new Board(squaresOne);
		Board board2 = new Board(squaresTwo);
	
		GameView view = new GameView();
		ScannerInterface sc = new MockScanner();
		
		PlayerInterface player1 = new MockPlayer(myTest1.getElement(), board1);
		PlayerInterface player2 = new MockPlayer(myTest1.getElement(), board2);
		
		GameController game = new GameController(player1, player2, view, sc);
		
		ArrayList<Square> squares1 = new ArrayList<Square>();
		ArrayList<Square> squares2 = new ArrayList<Square>();
		
		
		for(int i=0; i<(myTest1.getNumElements()/2)-1; i++) {
			game.getScanner().setChar(myTest1.getElement().charAt(0));
			game.getScanner().setInt(Integer.parseInt(myTest1.getElement()));
			
			if(i%2==0) {
				game.turn(player1, player2);
			} else {
				game.turn(player2, player1);
			}
			
		}
		
		//System.out.println(game.getWin());
	}

}
