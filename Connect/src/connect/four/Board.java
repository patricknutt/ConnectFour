package connect.four;
/**
 * 
 * @author Patrick
 */
public class Board {
	protected int[][] board;
	protected int size;
	public static final int EMPTY_PIECE = 0;
	
	public Board(int size) {
		this.size = size;
		board = new int[this.size][this.size];
	}
	
	public void addPiece(int row, int col, int piece) {
		if(isEmpty(row, col)) {
			board[row][col] = piece;
		}
		else {
			System.out.println("That spot is already taken");
		}
		nextPlayer();
	}
	
	public boolean isEmpty(int row, int col) {
		return board[row][col] == EMPTY_PIECE;
	}
	
	public int getSpotValue(int row, int col) {
		return board[row][col];
	}
	
	public void nextPlayer() {
		
	}
	
	public void drawBoard() {
		for (int r=0; r<size; r++) {
			String row = "";
			for(int c=0; c<size; c++) {
				row += " " + board[r][c] + " ";
			}
			System.out.println(row);
		}
	}
	
	public void reset() {
		// Initialize all spots to empty
		for (int r=0; r<size; r++) {
			for (int c=0; c<size; c++) {
				board[r][c] = EMPTY_PIECE;
			}
		} 				
	}
}
