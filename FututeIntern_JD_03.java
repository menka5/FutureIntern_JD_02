package FutureIntern_JD_02;


import java.util.Random;
import java.util.Scanner;

public class FututeIntern_JD_03 {
	static char[][] board;

	public FututeIntern_JD_03() {
		board = new char[3][3];

		initBoard();
		// i dont want null character inside so i initialised the
	}

	void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// now initialized
				board[i][j] = ' ';
			}
		}
	}

	// display bord
	static void dispBoard() {

		System.out.println("-------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	static void placeMark(int row, int col, char mark) {

		// check row col valid or not
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			board[row][col] = mark;
		} else {
			System.out.println("Invalid position");
		}

	}

	static boolean checkColWin() {
		for (int j = 0; j <= 2; j++)
			if (board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
				return true;
			}
		return false;
	}

	static boolean checkRowWin() {
		for (int i = 0; i <= 2; i++) {
			if (board[i][0]!=' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	static boolean checkDiagWin() {
		
		//for empty character board[0][0]!=' ' space check
		if (board[0][0]!=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
				|| board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		} else {
			return false;
		}
	}
	static boolean isDraw() {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
		
	}
}
abstract class Player{
	String name;
	char mark;
	abstract void makeMove();

	// need row and column
	boolean isValidMove(int row, int col) {
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
//really move paste or not
			if (FututeIntern_JD_03.board[row][col] == ' ') {
				return true;
			}
		}
		return false;
	}
}

class HumanPlayer extends Player{


	// intialised this name and mark has part
	HumanPlayer(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	// before make mark that move valid or not should check
	void makeMove() {
		Scanner scan = new Scanner(System.in);
		// take row and column
		int row;
		int col;

		// check the valid move
		// check is empty
		// as long as invalid move he want to give chance
		// when its valid move stop and move further so puts do while loop

		do {
			System.out.println("Enter the row and column");
			// accept input
			row = scan.nextInt();
			col = scan.nextInt();
		} while (!isValidMove(row, col));
		
		FututeIntern_JD_03.placeMark(row, col, mark);
	}


}

class AIPlayer extends Player {
	
	// intialised this name and mark has part
	AIPlayer(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	// before make mark that move valid or not should check
	void makeMove() {
		Scanner scan = new Scanner(System.in);
		// take row and column
		int row;
		int col;

		// check the valid move
		// check is empty
		// as long as invalid move he want to give chance
		// when its valid move stop and move further so puts do while loop

		do {
			Random r = new Random();//random class its inbuild class rabdom objech inside that randome method 
			//here its have randome method next int every object 
			row = r.nextInt(3);//3 becase its generate randome integer upto 3 set but  boundy 0 to 3 but 3 not include 
			col = r.nextInt(3);
			
		} while (!isValidMove(row, col));
		
		FututeIntern_JD_03.placeMark(row, col, mark);
	}

	

}

class LaunchGame {
	public static void main(String[] args) {
		FututeIntern_JD_03 t = new FututeIntern_JD_03();
		HumanPlayer p1=new HumanPlayer("Mayuri",'O');
		//HumanPlayer p2=new HumanPlayer("Chetana",'X');
		AIPlayer p2 = new AIPlayer("TAI",'X');
		
		
		Player cp;//parent type ref
		cp = p1;
		while(true) {
			System.out.println(cp.name+" turn");
			cp.makeMove();
			FututeIntern_JD_03.dispBoard();
			if(FututeIntern_JD_03.checkColWin()|| FututeIntern_JD_03.checkRowWin()||FututeIntern_JD_03.checkDiagWin()) {
				System.out.println(cp.name+" has won");
				break;
			}
			else if(FututeIntern_JD_03.isDraw()) {
				System.out.println("Game is Draw");
				break;
			}
			else {
				if(cp == p1) {
					cp = p2;//here not convert human player to ai player error"cannot convert from AIPlayer to HumanPlayer"
					//crete ref cp ref both object
					//parent ref 
					//create parent class player
					//is a relationship
					//code reuseibility
					
					
				}
				else {
					cp = p1;
				}
			}
		}
		
	//repeat this
	}
}
	
	
/*
 * 
 * 
 * 
 * //class create human player // and ai plyaer class //there two class has does
 * part has name String mark char does makeMove() - valid move invalid move
 * isValidMove()
 * 
 * AIPlayer same
 */

