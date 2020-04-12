import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectTest {
	
	private static Board testBoard;

	@BeforeClass
	public static void setUp() throws Exception {
		testBoard = new Board();		
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
				testBoard.addPiece(r,c, "Black");
			}
		}		
		assertTrue(testBoard.hasFour());
	}

	@Test
	public void testFourInRow() {
		// One row has four consecutive black pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, "Black");
		testBoard.addPiece(0, 1, "Black");
		testBoard.addPiece(0, 2, "Black");
		testBoard.addPiece(0, 3, "Black");		
		assertTrue(testBoard.hasFour());
	}

	@Test
	public void testThreeInRow() {
		// One row has three consecutive black pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, "Black");
		testBoard.addPiece(0, 1, "Black");
		testBoard.addPiece(0, 2, "Black");
		testBoard.addPiece(0, 3, "Red");		
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourInColumn() {
		// One column has four consecutive red pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, "Red");
		testBoard.addPiece(1,0, "Red");
		testBoard.addPiece(2, 0, "Red");
		testBoard.addPiece(3,0, "Red");
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeInColumn() {
		// One column has three consecutive red pieces
		testBoard.reset();
		testBoard.addPiece(0, 0, "Red");
		testBoard.addPiece(1,0, "Red");
		testBoard.addPiece(2, 0, "Red");
		testBoard.addPiece(3, 0, "Black");
		assertFalse(testBoard.hasFour());
	}	
	
	@Test
	public void testFourConsecutiveTopRightToLeftDownDiagonal() {
		// One diagonal in the top half has four consecutive black pieces from right to left
		testBoard.reset();
		testBoard.addPiece(0, 7, "Black");
		testBoard.addPiece(1, 6, "Black");
		testBoard.addPiece(2, 5, "Black");
		testBoard.addPiece(3, 4, "Black");
		assertTrue(testBoard.hasFour());
	}	
	
	@Test
	public void testThreeConsecutiveTopRightToLeftDownDiagonal() {
		// One diagonal in the top half has three consecutive black pieces from right to left
		testBoard.reset();
		testBoard.addPiece(0, 7, "Red");
		testBoard.addPiece(1, 6, "Black");
		testBoard.addPiece(2, 5, "Black");
		testBoard.addPiece(3, 4, "Black");
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourConsecutiveTopLeftToRightDownDiagonal() {
		// One diagonal in the top half has four consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(0, 0, "Black");
		testBoard.addPiece(1, 1, "Black");
		testBoard.addPiece(2, 2, "Black");
		testBoard.addPiece(3, 3, "Black");
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeConsecutiveTopLeftToRightDownDiagonal() {
		// One diagonal in the top half has three consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(0, 0, "Red");
		testBoard.addPiece(1, 1, "Black");
		testBoard.addPiece(2, 2, "Black");
		testBoard.addPiece(3, 3, "Black");
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testFourBottomLeftToRightUpDiagonal() {
		// One diagonal in the bottom half has four consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(7, 0, "Black");
		testBoard.addPiece(6, 1, "Black");
		testBoard.addPiece(5, 2, "Black");
		testBoard.addPiece(4, 3, "Black");
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testFourBottomRightToLeftUpDiagonal() {
		// One diagonal in the bottom half has four consecutive red pieces from right to left
		testBoard.reset();
		testBoard.addPiece(7, 7, "Red");
		testBoard.addPiece(6, 6, "Red");
		testBoard.addPiece(5, 5, "Red");
		testBoard.addPiece(4, 4, "Red");
		assertTrue(testBoard.hasFour());
	}
	
	@Test
	public void testThreeBottomLeftToRightUpDiagonal() {
		// One diagonal in the bottom half has three consecutive black pieces from left to right
		testBoard.reset();
		testBoard.addPiece(7, 0, "Black");
		testBoard.addPiece(6, 1, "Black");
		testBoard.addPiece(5, 2, "Black");
		testBoard.addPiece(4, 3, "Red");
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testThreeBottomRightToLeftUpDiagonal() {
		// One diagonal in the bottom half has three consecutive red pieces from right to left
		testBoard.reset();
		testBoard.addPiece(7, 7, "Black");
		testBoard.addPiece(6, 6, "Red");
		testBoard.addPiece(5, 5, "Red");
		testBoard.addPiece(4, 4, "Red");
		assertFalse(testBoard.hasFour());
	}
	
	@Test
	public void testActualGame() {
		// Results of a simulated game between black and red, where black has won, are tested
		testBoard.reset();
		testBoard.addPiece(7, 0, "Red");
		testBoard.addPiece(7, 1, "Black");
		testBoard.addPiece(6, 0, "Red");
		testBoard.addPiece(7, 2, "Black");
		testBoard.addPiece(6, 1, "Red");
		testBoard.addPiece(7, 3, "Black");
		testBoard.addPiece(7, 4, "Red");
		testBoard.addPiece(6, 2, "Black");
		testBoard.addPiece(5, 2, "Red");
		testBoard.addPiece(6, 3, "Black");
		testBoard.addPiece(5, 0, "Red");
		testBoard.addPiece(5, 4, "Black");
		testBoard.addPiece(6, 4, "Red");
		testBoard.addPiece(4, 0, "Black");
		testBoard.addPiece(5, 3, "Red");
		testBoard.addPiece(5, 1, "Black");
		assertTrue(testBoard.hasFour());
	}
}
