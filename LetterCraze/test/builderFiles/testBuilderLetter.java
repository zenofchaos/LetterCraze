package builderFiles;

import junit.framework.TestCase;

public class testBuilderLetter extends TestCase{
	
	public void testBuilderLetterValid(){
		String toSet = "A";
		BuilderLetter letter = new BuilderLetter(toSet);
		
		assertEquals("A",letter.getLetter());
		assertEquals(2,letter.getPoints());
		
		String toSet2 = "b";
		BuilderLetter letter2 = new BuilderLetter(toSet2);
		
		assertEquals("B",letter2.getLetter());
		assertEquals(4,letter2.getPoints());
		
		String toSet3 = "Qu";
		BuilderLetter letter3 = new BuilderLetter(toSet3);
		
		assertEquals("Qu",letter3.getLetter());
		assertEquals(11,letter3.getPoints());
		
		String toSet4 = "QU";
		BuilderLetter letter4 = new BuilderLetter(toSet4);
		
		assertEquals("Qu",letter4.getLetter());
		assertEquals(11,letter4.getPoints());
		
		String toSet5 = "qu";
		BuilderLetter letter5 = new BuilderLetter(toSet5);
		
		assertEquals("Qu",letter5.getLetter());
		assertEquals(11,letter5.getPoints());
		
		String toSet6 = "Z";
		BuilderLetter letter6 = new BuilderLetter(toSet6);
		
		assertEquals("Z",letter6.getLetter());
		assertEquals(8,letter6.getPoints());
		
		String toSet7 = "c";
		BuilderLetter letter7 = new BuilderLetter(toSet7);
		
		assertEquals("C",letter7.getLetter());
		assertEquals(3,letter7.getPoints());
		
		String toSet8 = "D";
		BuilderLetter letter8 = new BuilderLetter(toSet8);
		
		assertEquals("D",letter8.getLetter());
		assertEquals(3,letter8.getPoints());
		
		String toSet9 = "E";
		BuilderLetter letter9 = new BuilderLetter(toSet9);
		
		assertEquals("E",letter9.getLetter());
		assertEquals(1,letter9.getPoints());
		
		String toSet10 = "F";
		BuilderLetter letter10 = new BuilderLetter(toSet10);
		
		assertEquals("F",letter10.getLetter());
		assertEquals(4,letter10.getPoints());
		
		String toSet11 = "G";
		BuilderLetter letter11 = new BuilderLetter(toSet11);
		
		assertEquals("G",letter11.getLetter());
		assertEquals(4,letter11.getPoints());
		
		String toSet12 = "H";
		BuilderLetter letter12 = new BuilderLetter(toSet12);
		
		assertEquals("H",letter12.getLetter());
		assertEquals(2,letter12.getPoints());
		
		String toSet13 = "I";
		BuilderLetter letter13 = new BuilderLetter(toSet13);
		
		assertEquals("I",letter13.getLetter());
		assertEquals(2,letter13.getPoints());
		
		String toSet14 = "J";
		BuilderLetter letter14 = new BuilderLetter(toSet14);
		
		assertEquals("J",letter14.getLetter());
		assertEquals(7,letter14.getPoints());
		
		String toSet15 = "K";
		BuilderLetter letter15 = new BuilderLetter(toSet15);
		
		assertEquals("K",letter15.getLetter());
		assertEquals(5,letter15.getPoints());
		
		String toSet16 = "L";
		BuilderLetter letter16 = new BuilderLetter(toSet16);
		
		assertEquals("L",letter16.getLetter());
		assertEquals(3,letter16.getPoints());
		
		String toSet17 = "M";
		BuilderLetter letter17 = new BuilderLetter(toSet17);
		
		assertEquals("M",letter17.getLetter());
		assertEquals(3,letter17.getPoints());
		
		String toSet18 = "n";
		BuilderLetter letter18 = new BuilderLetter(toSet18);
		
		assertEquals("N",letter18.getLetter());
		assertEquals(2,letter18.getPoints());
		
		String toSet19 = "o";
		BuilderLetter letter19 = new BuilderLetter(toSet19);
		
		assertEquals("O",letter19.getLetter());
		assertEquals(2,letter19.getPoints());
		
		String toSet20 = "P";
		BuilderLetter letter20 = new BuilderLetter(toSet20);
		
		assertEquals("P",letter20.getLetter());
		assertEquals(4,letter20.getPoints());
		
		String toSet21 = "S";
		BuilderLetter letter21 = new BuilderLetter(toSet21);
		
		assertEquals("S",letter21.getLetter());
		assertEquals(2,letter21.getPoints());
		
		String toSet22 = "R";
		BuilderLetter letter22 = new BuilderLetter(toSet22);
		
		assertEquals("R",letter22.getLetter());
		assertEquals(2,letter22.getPoints());
		
		String toSet23 = "T";
		BuilderLetter letter23 = new BuilderLetter(toSet23);
		
		assertEquals("T",letter23.getLetter());
		assertEquals(1,letter23.getPoints());
		
		String toSet24 = "U";
		BuilderLetter letter24 = new BuilderLetter(toSet24);
		
		assertEquals("U",letter24.getLetter());
		assertEquals(3,letter24.getPoints());
		
		String toSet25 = "V";
		BuilderLetter letter25 = new BuilderLetter(toSet25);
		
		assertEquals("V",letter25.getLetter());
		assertEquals(5,letter25.getPoints());
		
		String toSet26 = "W";
		BuilderLetter letter26 = new BuilderLetter(toSet26);
		
		assertEquals("W",letter26.getLetter());
		assertEquals(3,letter26.getPoints());
		
		String toSet27 = "X";
		BuilderLetter letter27 = new BuilderLetter(toSet27);
		
		assertEquals("X",letter27.getLetter());
		assertEquals(7,letter27.getPoints());
		
		String toSet28 = "Y";
		BuilderLetter letter28 = new BuilderLetter(toSet28);
		
		assertEquals("Y",letter28.getLetter());
		assertEquals(4,letter28.getPoints());
		
		
	}
	
	public void testBuilderLetterInvalid(){

		String toSet29 = "Q";
		BuilderLetter letter29 = new BuilderLetter(toSet29);
		assertEquals(null,letter29.getLetter());
		assertEquals(0,letter29.getPoints());
		
		String toSet30 = "q";
		BuilderLetter letter30 = new BuilderLetter(toSet30);
		assertEquals(null,letter30.getLetter());
		assertEquals(0,letter30.getPoints());
		
		String toSet31 = "]";
		BuilderLetter letter31 = new BuilderLetter(toSet31);
		assertEquals(null,letter31.getLetter());
		assertEquals(0,letter31.getPoints());
		
		String toSet32 = "que";
		BuilderLetter letter32 = new BuilderLetter(toSet32);
		assertEquals(null,letter32.getLetter());
		assertEquals(0,letter32.getPoints());
	}
	
	public void testWithoutInput(){
		for (int i = 0; i < 10000; i++){
			BuilderLetter letter = new BuilderLetter();
			assertTrue(letter.isValid(letter.getLetter()));
		}
	}
}
