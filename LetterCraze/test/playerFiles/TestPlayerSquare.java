package playerFiles;

import junit.framework.TestCase;

public class TestPlayerSquare extends TestCase{

	//Tests to ensure that the constructor properly generates square objects
	public void testConstructor(){
		int row = 1;
		int col = 2;
		
		PlayerSquare square = new PlayerSquare(row,col);
		assertEquals(row,square.getRow());
		assertEquals(col,square.getCol());
		assertFalse(square.hasLetter());
		try{ //getPoints should throw a NullPointerException when square has no letter
			square.getPoints();
			assertTrue(false);
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
		
		try{ //toString should throw a NullPointerException when square has no letter
			square.toString();
			assertTrue(false);
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
	}
	
	//Tests the ChangeLetter method of PlayerSquare
	public void testChangeLetter(){
		int row = 1;
		int col = 2;
		
		PlayerSquare square = new PlayerSquare(row,col);
		PlayerLetter anA = new PlayerLetter("A");
		PlayerLetter Qu = new PlayerLetter("Qu");
		
		assertEquals(null,square.changeLetter(anA));
		assertEquals(anA.getLetter(),square.toString());
		
		assertEquals(anA,square.changeLetter(Qu));
		assertEquals(Qu.getLetter(),square.toString());
		
		assertEquals(Qu,square.changeLetter(null));
		assertEquals(null,square.getLetter());
	}
	
	//Tests the RemoveLetter method of PlayerSquare
	public void testRemoveLetter(){
		int row = 1;
		int col = 2;
		
		PlayerSquare square = new PlayerSquare(row,col);
		PlayerLetter anA = new PlayerLetter("A");
		
		assertEquals(null,square.removeLetter());
		assertEquals(null,square.getLetter());
		
		square.changeLetter(anA);
		assertEquals(anA.getLetter(),square.toString());
		assertEquals(anA,square.removeLetter());
		assertEquals(null,square.getLetter());
	}
	
	//Tests changing whether a square is active
	public void testSetActive(){
		int row = 1;
		int col = 2;
		
		PlayerSquare square = new PlayerSquare(row,col);
		assertFalse(square.isActive());
		square.setActive(true);
		assertTrue(square.isActive());
	}
	
	//Tests the isNeighbor function of PlayerSquare
	public void testIsNeighbor(){
		PlayerSquare topLeft = new PlayerSquare(1,1);
		PlayerSquare topCenter = new PlayerSquare(1,2);
		PlayerSquare topRight = new PlayerSquare(1,3);
		PlayerSquare centerLeft = new PlayerSquare(2,1);
		PlayerSquare centerCenter = new PlayerSquare(2,2);
		PlayerSquare centerRight = new PlayerSquare(2,3);
		PlayerSquare bottomLeft = new PlayerSquare(3,1);
		PlayerSquare bottomCenter = new PlayerSquare(3,2);
		PlayerSquare bottomRight = new PlayerSquare(3,3);
		
		assertTrue(centerCenter.isNeighbor(topLeft));
		assertTrue(centerCenter.isNeighbor(topCenter));
		assertTrue(centerCenter.isNeighbor(topRight));
		assertTrue(centerCenter.isNeighbor(centerLeft));
		assertTrue(centerCenter.isNeighbor(centerRight));
		assertTrue(centerCenter.isNeighbor(bottomLeft));
		assertTrue(centerCenter.isNeighbor(bottomCenter));
		assertTrue(centerCenter.isNeighbor(bottomRight));
		
		assertFalse(centerCenter.isNeighbor(centerCenter));
		assertFalse(topLeft.isNeighbor(topRight));
		assertFalse(bottomLeft.isNeighbor(centerRight));
	}
}
