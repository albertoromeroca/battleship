package BattleShip;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

	/*Attributes*/
	
	private Player player1;
	private Player player2;
	private Board board1;
	private Board board2;
	private int turn;
	private boolean win;
	private GameView view;
	
	/*Methods*/
	
	public GameController(Player player1, Player player2, GameView view) { //Done
		this.player1 = player1;
		this.player2 = player2;
		this.turn = 2;
		this.win = false;
		this.view = view;
	}
	
	public void turn(Player player) {
		//bucleTurno
		Scanner scanner = new Scanner(System.in);
		this.view.requestLetter(player.getName());
		char letter = scanner.next().charAt(0);
		this.view.requestNum(player.getName());
		int num = scanner.nextInt();
		Square square = new Square(letter, num);

	}
	
	public void play() {
		//bucleJuego
		do {
			if(turn%2 == 0) {
				turn(this.player1);
			}else {
				turn(this.player2);
			}
			turn++;
		}while(win);
	}
	
	
		
}
