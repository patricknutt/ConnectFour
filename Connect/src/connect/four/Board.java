package connect.four;
/**
 * 
 * @author Patrick
 * TODO: change constants to integers
 * TODO: add current piece value (Black or Red)
 */
public class Board {
	private String[][] board;
	private int size;
	public static String BLACK_PIECE = "B";
	public static String RED_PIECE = "R";
	public static String EMPTY_PIECE = "E";
	
	public Board(int size) {
		this.size = size;
		board = new String[this.size][this.size];
	}
	
	public void addPiece(int row, int col, String value) {
		if(isEmpty(row, col) || value == EMPTY_PIECE) {
			board[row][col] = value;
		}
		else {
			System.out.println("That spot is already taken");
		}
	}
	
	public boolean isEmpty(int row, int col) {
		return board[row][col] == EMPTY_PIECE;
	}
	
	public String getSpotValue(int row, int col) {
		return board[row][col];
	}
	
	public boolean hasFour() {
		if (testHorizontal() || testVertical() || testDiagonal()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean testHorizontal() {
		// Returns true if 4 of the same color are in a row
		for (int r=0; r<size; r++) {
			for(int c=0; c<5; c++) {
				if(! isEmpty(r, c)
					&& board[r][c].equals(board[r][c+1])
					&& board[r][c+1].equals(board[r][c+2])
					&& board[r][c+2].equals(board[r][c+3])) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean testVertical() {
		// Returns true if 4 of the same color are in a column
		for (int r=0; r<5; r++) {
			for(int c=0; c<size; c++) {
				if(! isEmpty(r, c)
					&& board[r][c].equals(board[r+1][c])
					&& board[r+1][c].equals(board[r+2][c])
					&& board[r+2][c].equals(board[r+3][c])) {
					return true;
				}
			} 
		}
		return false;
	}
	
	private boolean testDiagonal() {
		// Returns true is 4 of the same color are in a diagonal
		for (int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				//Test Diagonal Left to Right Down
				if(! isEmpty(r, c)
					&& board[r][c].equals(board[r+1][c+1])
					&& board[r+1][c+1].equals(board[r+2][c+2])
					&& board[r+2][c+2].equals(board[r+3][c+3])) {
					return true;
				}
			}
			for(int c=3; c<size; c++) {	
				//Test Diagonal Right to Left Down
				if(! isEmpty(r, c)
					&& board[r][c].equals(board[r+1][c-1])
					&& board[r+1][c-1].equals(board[r+2][c-2])
					&& board[r+2][c-2].equals(board[r+3][c-3])) {
					return true;
				}
			}			
		}
		return false;
	}
	
	public void reset() {
		// Initialize all spots to empty
		for (int r=0; r<size; r++) {
			for (int c=0; c<size; c++) {
				addPiece(r,c, EMPTY_PIECE);
			}
		} 				
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
}
