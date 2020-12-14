package BattleShip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AutomatedTests {

	public static void main(String[] args) throws IOException {
		String[] pathnames;
		File f = new File("src/Tests");
		pathnames = f.list();
		
		int totalTests = pathnames.length;
		int correctTest = 0;
		
		for(int j=0; j<totalTests; j++) {
			System.out.println("//////////////Starting Test "+pathnames[j]+"//////////////");
		
			Reader myTest1 = new Reader("src/Tests/"+pathnames[j]);
			
			ArrayList<Square> squaresOne = new ArrayList<Square>();
			ArrayList<Square> squaresTwo = new ArrayList<Square>();
			
			Board board1 = new Board(squaresOne);
			Board board2 = new Board(squaresTwo);
		
			GameView view = new GameView();
			ScannerInterface sc = new MockScanner();
			
			PlayerInterface player1 = new MockPlayer(myTest1.getElement(), board1);
			PlayerInterface player2 = new MockPlayer(myTest1.getElement(), board2);
			
			GameController game = new GameController(player1, player2, view, sc);
			
			
			for(int i=0; i<(myTest1.getNumElements()/2)-1; i++) {
				game.getScanner().setChar(myTest1.getElement().charAt(0));
				game.getScanner().setInt(Integer.parseInt(myTest1.getElement()));
				
				if(i%2==0) {
					game.turn(player1, player2);
				} else {
					game.turn(player2, player1);
				}
				
			}
			
			System.out.println("//////////////Test '"+pathnames[j]+"' passed//////////////\n");
			correctTest++;
		}
		
		System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("//////////////[Total successful tests: "+correctTest+"/"+totalTests+"]//////////////");
		System.out.println("/////////////////////////////////////////////////////////");
	}

}
