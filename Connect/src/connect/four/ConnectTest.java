package connect.four;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectTest {
	
	private static Board testBoard;

	@BeforeClass
	public static void setUp() throws Exception {
		testBoard = new Board(8);		
	}
	
	@Test
	public void testNoConsecutive() {
		// All spots are empty, so a call to hasFour() should return false
		testBoard.reset();
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testAllBlack() {
		// All spots are filled with black pieces so it should always be true
		testBoard.reset();
		for (int r=0; r<8; r++) {
			for (int c=0; c<8; c++) {
				testBoard.addPiece(r,c, Board.BLACK_PIECE);
			}
		}		
		assertTrue(testBoard.hasFour());
	}

	@Test
	public void testFourInRow() {
		// One row has four consecutive black pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, Board.BLACK_PIECE);
		testBoard.addPiece(0, 1, Board.BLACK_PIECE);
		testBoard.addPiece(0, 2, Board.BLACK_PIECE);
		testBoard.addPiece(0, 3, Board.BLACK_PIECE);		
		assertTrue(testBoard.hasFour());
	}

	@Test
	public void testThreeInRow() {
		// One row has three consecutive black pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, Board.BLACK_PIECE);
		testBoard.addPiece(0, 1, Board.BLACK_PIECE);
		testBoard.addPiece(0, 2, Board.BLACK_PIECE);
		testBoard.addPiece(0, 3, Board.RED_PIECE);		
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourInColumn() {
		// One column has four consecutive red pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, Board.RED_PIECE);
		testBoard.addPiece(1,0, Board.RED_PIECE);
		testBoard.addPiece(2, 0, Board.RED_PIECE);
		testBoard.addPiece(3,0, Board.RED_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeInColumn() {
		// One column has three consecutive red pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, Board.RED_PIECE);
		testBoard.addPiece(1,0, Board.RED_PIECE);
		testBoard.addPiece(2, 0, Board.RED_PIECE);
		testBoard.addPiece(3, 0, Board.BLACK_PIECE);
		assertFalse(testBoard.hasFour());
	}	
	
	@Test
	public void testFourConsecutiveTopRightToLeftDownDiagonal() {
		// One diagonal in the top half has four consecutive black pieces from right to left
		testBoard.reset();
		testBoard.addPiece(0, 7, Board.BLACK_PIECE);
		testBoard.addPiece(1, 6, Board.BLACK_PIECE);
		testBoard.addPiece(2, 5, Board.BLACK_PIECE);
		testBoard.addPiece(3, 4, Board.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}	
	
	@Test
	public void testThreeConsecutiveTopRightToLeftDownDiagonal() {
		// One diagonal in the top half has three consecutive black pieces from right to left
		testBoard.reset();
		testBoard.addPiece(0, 7, Board.RED_PIECE);
		testBoard.addPiece(1, 6, Board.BLACK_PIECE);
		testBoard.addPiece(2, 5, Board.BLACK_PIECE);
		testBoard.addPiece(3, 4, Board.BLACK_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourConsecutiveTopLeftToRightDownDiagonal() {
		// One diagonal in the top half has four consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(0, 0, Board.BLACK_PIECE);
		testBoard.addPiece(1, 1, Board.BLACK_PIECE);
		testBoard.addPiece(2, 2, Board.BLACK_PIECE);
		testBoard.addPiece(3, 3, Board.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeConsecutiveTopLeftToRightDownDiagonal() {
		// One diagonal in the top half has three consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(0, 0, Board.RED_PIECE);
		testBoard.addPiece(1, 1, Board.BLACK_PIECE);
		testBoard.addPiece(2, 2, Board.BLACK_PIECE);
		testBoard.addPiece(3, 3, Board.BLACK_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourBottomLeftToRightUpDiagonal() {
		// One diagonal in the bottom half has four consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(7, 0, Board.BLACK_PIECE);
		testBoard.addPiece(6, 1, Board.BLACK_PIECE);
		testBoard.addPiece(5, 2, Board.BLACK_PIECE);
		testBoard.addPiece(4, 3, Board.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testFourBottomRightToLeftUpDiagonal() {
		// One diagonal in the bottom half has four consecutive red pieces from right to left
		testBoard.reset();
		testBoard.addPiece(7, 7, Board.RED_PIECE);
		testBoard.addPiece(6, 6, Board.RED_PIECE);
		testBoard.addPiece(5, 5, Board.RED_PIECE);
		testBoard.addPiece(4, 4, Board.RED_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeBottomLeftToRightUpDiagonal() {
		// One diagonal in the bottom half has three consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(7, 0, Board.BLACK_PIECE);
		testBoard.addPiece(6, 1, Board.BLACK_PIECE);
		testBoard.addPiece(5, 2, Board.BLACK_PIECE);
		testBoard.addPiece(4, 3, Board.RED_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testThreeBottomRightToLeftUpDiagonal() {
		// One diagonal in the bottom half has three consecutive red pieces from right to left
		testBoard.reset();
		testBoard.addPiece(7, 7, Board.BLACK_PIECE);
		testBoard.addPiece(6, 6, Board.RED_PIECE);
		testBoard.addPiece(5, 5, Board.RED_PIECE);
		testBoard.addPiece(4, 4, Board.RED_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testSpotAlreadyTaken() {
		testBoard.reset();
		testBoard.addPiece(1, 2, Board.BLACK_PIECE);
		testBoard.addPiece(1, 2, Board.RED_PIECE);
		assertFalse(testBoard.getSpotValue(1, 2) == Board.RED_PIECE);
	}
	
	@Test
	public void testActualGame() {
		// Results of a simulated game between black and red, where black has won, are tested
		testBoard.reset();
		testBoard.addPiece(7, 0, Board.RED_PIECE);
		testBoard.addPiece(7, 1, Board.BLACK_PIECE);
		testBoard.addPiece(6, 0, Board.RED_PIECE);
		testBoard.addPiece(7, 2, Board.BLACK_PIECE);
		testBoard.addPiece(6, 1, Board.RED_PIECE);
		testBoard.addPiece(7, 3, Board.BLACK_PIECE);
		testBoard.addPiece(7, 4, Board.RED_PIECE);
		testBoard.addPiece(6, 2, Board.BLACK_PIECE);
		testBoard.addPiece(5, 2, Board.RED_PIECE);
		testBoard.addPiece(6, 3, Board.BLACK_PIECE);
		testBoard.addPiece(5, 0, Board.RED_PIECE);
		testBoard.addPiece(5, 4, Board.BLACK_PIECE);
		testBoard.addPiece(6, 4, Board.RED_PIECE);
		testBoard.addPiece(4, 0, Board.BLACK_PIECE);
		testBoard.addPiece(5, 3, Board.RED_PIECE);
		testBoard.addPiece(5, 1, Board.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}
}
