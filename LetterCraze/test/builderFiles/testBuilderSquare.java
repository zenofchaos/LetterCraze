package builderFiles;

import junit.framework.TestCase;

public class testBuilderSquare extends TestCase{
	
	public void testSquare(){
		BuilderSquare square1 = new BuilderSquare(1,2);
		
		assertEquals(1, square1.getRow());
		assertEquals(2, square1.getCol());
		assertEquals(false, square1.getActive());
		
		square1.setActive(true);
		assertEquals(true, square1.getActive());
		
		square1.setCol(3);
		square1.setRow(5);
		
		assertEquals(5, square1.getRow());
		assertEquals(3, square1.getCol());
		
		assertEquals(false, square1.removeLetter());
		
		BuilderLetter letter = new BuilderLetter("a");
		BuilderLetter letter2 = new BuilderLetter("C");
		assertEquals(null, square1.changeLetter(letter));
		assertEquals(letter, square1.getLetter());
		assertEquals(letter, square1.changeLetter(letter2));
		assertEquals(letter2, square1.getLetter());
		assertEquals(true, square1.setLetter(letter));
		assertEquals(letter, square1.getLetter());
		assertEquals(true, square1.removeLetter());
		
		
	}

}
