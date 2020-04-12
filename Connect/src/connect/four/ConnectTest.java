package connect.four;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectTest {
	
	private static ConnectBoard testBoard;

	@BeforeClass
	public static void setUp() throws Exception {
		testBoard = new ConnectBoard(8);		
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
				testBoard.addPiece(r,c, ConnectBoard.BLACK_PIECE);
			}
		}		
		assertTrue(testBoard.hasFour());
	}

	@Test
	public void testFourInRow() {
		// One row has four consecutive black pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(0, 1, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(0, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(0, 3, ConnectBoard.BLACK_PIECE);		
		assertTrue(testBoard.hasFour());
	}

	@Test
	public void testThreeInRow() {
		// One row has three consecutive black pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(0, 1, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(0, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(0, 3, ConnectBoard.RED_PIECE);		
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourInColumn() {
		// One column has four consecutive red pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(1,0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(2, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(3,0, ConnectBoard.RED_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeInColumn() {
		// One column has three consecutive red pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(1,0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(2, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(3, 0, ConnectBoard.BLACK_PIECE);
		assertFalse(testBoard.hasFour());
	}	
	
	@Test
	public void testFourConsecutiveTopRightToLeftDownDiagonal() {
		// One diagonal in the top half has four consecutive black pieces from right to left
		testBoard.reset();
		testBoard.addPiece(0, 7, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(1, 6, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(2, 5, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(3, 4, ConnectBoard.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}	
	
	@Test
	public void testThreeConsecutiveTopRightToLeftDownDiagonal() {
		// One diagonal in the top half has three consecutive black pieces from right to left
		testBoard.reset();
		testBoard.addPiece(0, 7, ConnectBoard.RED_PIECE);
		testBoard.addPiece(1, 6, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(2, 5, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(3, 4, ConnectBoard.BLACK_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourConsecutiveTopLeftToRightDownDiagonal() {
		// One diagonal in the top half has four consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(0, 0, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(1, 1, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(2, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(3, 3, ConnectBoard.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeConsecutiveTopLeftToRightDownDiagonal() {
		// One diagonal in the top half has three consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(0, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(1, 1, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(2, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(3, 3, ConnectBoard.BLACK_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourBottomLeftToRightUpDiagonal() {
		// One diagonal in the bottom half has four consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(7, 0, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(6, 1, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(5, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(4, 3, ConnectBoard.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testFourBottomRightToLeftUpDiagonal() {
		// One diagonal in the bottom half has four consecutive red pieces from right to left
		testBoard.reset();
		testBoard.addPiece(7, 7, ConnectBoard.RED_PIECE);
		testBoard.addPiece(6, 6, ConnectBoard.RED_PIECE);
		testBoard.addPiece(5, 5, ConnectBoard.RED_PIECE);
		testBoard.addPiece(4, 4, ConnectBoard.RED_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeBottomLeftToRightUpDiagonal() {
		// One diagonal in the bottom half has three consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(7, 0, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(6, 1, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(5, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(4, 3, ConnectBoard.RED_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testThreeBottomRightToLeftUpDiagonal() {
		// One diagonal in the bottom half has three consecutive red pieces from right to left
		testBoard.reset();
		testBoard.addPiece(7, 7, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(6, 6, ConnectBoard.RED_PIECE);
		testBoard.addPiece(5, 5, ConnectBoard.RED_PIECE);
		testBoard.addPiece(4, 4, ConnectBoard.RED_PIECE);
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testSpotAlreadyTaken() {
		testBoard.reset();
		testBoard.addPiece(1, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(1, 2, ConnectBoard.RED_PIECE);
		assertFalse(testBoard.getSpotValue(1, 2) == ConnectBoard.RED_PIECE);
	}
	
	@Test
	public void testActualGame() {
		// Results of a simulated game between black and red, where black has won, are tested
		testBoard.reset();
		testBoard.addPiece(7, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(7, 1, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(6, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(7, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(6, 1, ConnectBoard.RED_PIECE);
		testBoard.addPiece(7, 3, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(7, 4, ConnectBoard.RED_PIECE);
		testBoard.addPiece(6, 2, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(5, 2, ConnectBoard.RED_PIECE);
		testBoard.addPiece(6, 3, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(5, 0, ConnectBoard.RED_PIECE);
		testBoard.addPiece(5, 4, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(6, 4, ConnectBoard.RED_PIECE);
		testBoard.addPiece(4, 0, ConnectBoard.BLACK_PIECE);
		testBoard.addPiece(5, 3, ConnectBoard.RED_PIECE);
		testBoard.addPiece(5, 1, ConnectBoard.BLACK_PIECE);
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testActualGameBlackWins() {
		// Results of a simulated game between black and red, where black has won, are tested
		testBoard.reset();
		while (! testBoard.hasFour()) {
			testBoard.addPiece(7, 0);
			testBoard.addPiece(6, 0);
			testBoard.addPiece(7, 1);
			testBoard.addPiece(6, 1);
			testBoard.addPiece(7, 2);
			testBoard.addPiece(6, 2);
			testBoard.addPiece(7, 3);
		}
		assertTrue(testBoard.getWinner()=="Black");
	}
	
	@Test
	public void testActualGameRedWins() {
		// Results of a simulated game between black and red, where red has won, are tested
		testBoard.reset();
		while (! testBoard.hasFour()) {
			testBoard.addPiece(6, 0);
			testBoard.addPiece(7, 0);
			testBoard.addPiece(6, 1);			
			testBoard.addPiece(7, 1);
			testBoard.addPiece(6, 2);			
			testBoard.addPiece(7, 2);
			testBoard.addPiece(6, 5);
			testBoard.addPiece(7, 3);
		}
		assertTrue(testBoard.getWinner()=="Red");
	}
}
