package connect.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConnectFour {
	public static void main(String args[]) throws IOException{
		Board board = new Board(8);		
		int row = 0;
		int col = 0;
		String piece;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		
		board.reset();
		board.drawBoard();
		
		while (! board.hasFour()) {			
			
			System.out.println ("Enter row: ");
			row = scanner.nextInt();
						
			board.addPiece(row, 0, Board.BLACK_PIECE);

			board.drawBoard();
		}
		System.out.println("We have a winner");
	}
}
