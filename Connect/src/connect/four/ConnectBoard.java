package connect.four;
/**
 * 
 * @author Patrick
 * TODO: Only allow plays on the bottom row or on top of another already played piece
 *
 */
public class ConnectBoard extends Board{
	public static final int BLACK_PIECE = 1; 
	public static final int RED_PIECE = 2;
	private int currentPiece;
	private String winner;

	public ConnectBoard(int size) {
		super(size);
		this.currentPiece = BLACK_PIECE;
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
					&& board[r][c]==board[r][c+1]
					&& board[r][c+1]==board[r][c+2]
					&& board[r][c+2]==board[r][c+3]) {
					setWinner(board[r][c]);
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
					&& board[r][c]==board[r+1][c]
					&& board[r+1][c]==board[r+2][c]
					&& board[r+2][c]==board[r+3][c]) {
					setWinner(board[r][c]);
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
					&& board[r][c]==board[r+1][c+1]
					&& board[r+1][c+1]==board[r+2][c+2]
					&& board[r+2][c+2]==board[r+3][c+3]) {
					setWinner(board[r][c]);
					return true;
				}
			}
			for(int c=3; c<size; c++) {	
				//Test Diagonal Right to Left Down
				if(! isEmpty(r, c)
					&& board[r][c]==board[r+1][c-1]
					&& board[r+1][c-1]==board[r+2][c-2]
					&& board[r+2][c-2]==board[r+3][c-3]) {
					setWinner(board[r][c]);
					return true;
				}
			}			
		}
		return false;
	}
	
	public String currentPiece() {
		String response = "";
		switch(currentPiece) {
		case BLACK_PIECE:
			response = "Black";
			break;
		case RED_PIECE:
			response = "Red";
			break;
		}
		return response;
	}

	public void addPiece(int row, int col) {
		if(isEmpty(row, col)) {
			board[row][col] = currentPiece;
		}
		else {
			System.out.println("That spot is already taken");
		}
		nextPlayer();
	}
	
	private void setWinner(int piece) {
		switch(piece) {
		case BLACK_PIECE:
			winner = "Black";
			break;
		case RED_PIECE:
			winner = "Red";
			break;
		}
	}
	
	public String getWinner() {
		return winner;
	}

	@Override 
	public void nextPlayer() {
		switch(currentPiece) { 
		case BLACK_PIECE:
			currentPiece = RED_PIECE;
			break;
		case RED_PIECE:
			currentPiece = BLACK_PIECE;
			break;
		}
	}
	
	@Override
	public void reset() {
		// Initialize all spots to empty
		for (int r=0; r<size; r++) {
			for (int c=0; c<size; c++) {
				board[r][c] = EMPTY_PIECE;
				currentPiece = BLACK_PIECE;
			}
		} 				
	}
}
