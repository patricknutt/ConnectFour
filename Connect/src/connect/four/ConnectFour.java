package connect.four;

import java.io.IOException;
import java.util.Scanner;

public class ConnectFour {
	public static void main(String args[]) throws IOException{
		ConnectBoard board = new ConnectBoard(8);		
		int row;
		int col;
	
		Scanner scanner = new Scanner(System.in);
		
		board.reset();
		board.drawBoard();
		
		while (! board.hasFour()) {	
			System.out.println("Current piece is " +  board.currentPiece());
			
			System.out.println ("Enter row: ");
			row = scanner.nextInt();
			
			System.out.println ("Enter column: ");
			col = scanner.nextInt();
			
			board.addPiece(row, col);
			board.drawBoard();
		}
		System.out.println(board.getWinner() + " wins!!");
		scanner.close();
	}
}
