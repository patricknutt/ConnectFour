public class Board {
	private String[][] board;
	
	public Board() {
		board = new String[8][8];
	}
	
	public void addPiece(int row, int col, String value) {
		board[row][col] = value;
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
		for (int r=0; r<8; r++) {
			for(int c=0; c<5; c++) {
				if(board[r][c] != "Empty"
					&& board[r][c]==board[r][c+1]
					&& board[r][c+1]==board[r][c+2]
					&& board[r][c+2]==board[r][c+3]) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean testVertical() {
		// Returns true if 4 of the same color are in a column
		for (int r=0; r<5; r++) {
			for(int c=0; c<8; c++) {
				if(board[r][c]!="Empty" 
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
				if(board[r][c]!="Empty"
					&& board[r][c]==board[r+1][c+1]
					&& board[r+1][c+1]==board[r+2][c+2]
					&& board[r+2][c+2]==board[r+3][c+3]) {
					return true;
				}
			}
			for(int c=3; c<8; c++) {	
				//Test Diagonal Right to Left Down
				if(board[r][c]!="Empty"
					&& board[r][c]==board[r+1][c-1]
					&& board[r+1][c-1]==board[r+2][c-2]
					&& board[r+2][c-2]==board[r+3][c-3]) {
					return true;
				}
			}			
		}
		return false;
	}
	
	public void reset() {
		// Initialize all spots to empty
		for (int r=0; r<8; r++) {
			for (int c=0; c<8; c++) {
				addPiece(r,c, "Empty");
			}
		} 				
	}
}
