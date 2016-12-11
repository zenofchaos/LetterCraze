package playerFiles;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestPlayerWord extends TestCase{

	PlayerLetter m;
	PlayerLetter o;
	PlayerLetter u;
	PlayerLetter s;
	PlayerLetter e;
	PlayerLetter t;
	
	PlayerSquare M = new PlayerSquare(1,1);
	PlayerSquare O = new PlayerSquare(1,1);
	PlayerSquare U = new PlayerSquare(1,1);
	PlayerSquare S = new PlayerSquare(1,1);
	PlayerSquare E = new PlayerSquare(1,1);
	PlayerSquare T = new PlayerSquare(1,1);
	
	ArrayList<PlayerSquare> set = new ArrayList<PlayerSquare>();
	
	@Override
	public void setUp(){
		m = new PlayerLetter("M");
		o = new PlayerLetter("O");
		u = new PlayerLetter("U");
		s = new PlayerLetter("S");
		e = new PlayerLetter("E");
		t = new PlayerLetter("T");
		
		M.changeLetter(m);
		O.changeLetter(o);
		U.changeLetter(u);
		S.changeLetter(s);
		E.changeLetter(e);
		T.changeLetter(t);
		
		set.add(S);
		set.add(E);
		set.add(T);
	}
	
	//Tests building a word one letter at a time
	//Also tests getWord, getPointVal, and isValidWord
	//	at intermediate steps
	public void testWordMOUSE(){
		PlayerWord word = new PlayerWord(M);
		assertFalse(word.isValidWord());
		assertEquals(0, word.getPointVal());
		assertEquals("M",word.getWord());
		
		word.addSquare(E);
		assertEquals("ME",word.getWord());
		assertEquals(0, word.getPointVal());
		assertFalse(word.isValidWord());
		
		word.addSquare(O,1);
		word.addSquare(S,2);
		
		assertEquals("MOSE",word.getWord());
		assertEquals(16, word.getPointVal());
		assertFalse(word.isValidWord());
		
		word.addSquare(U,2);
		assertEquals("MOUSE",word.getWord());
		assertEquals(33, word.getPointVal());
		assertTrue(word.isValidWord());
	}
	
	//Tests PlayerWord constructor which builds the
	//	word from a given list
	public void testWordSET(){
		PlayerWord word = new PlayerWord(set);
		assertEquals("SET",word.getWord());
		assertEquals(4, word.getPointVal());
		assertTrue(word.isValidWord());
	}
	
	//Tests whether a word can be made with a square that has no letter
	//Should throw a null pointer exception
	public void testNullLetterSingleSquare(){
		PlayerSquare square = new PlayerSquare(1,1);
		try{
			PlayerWord word = new PlayerWord(square);
			assertTrue(false);
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
	}
	
	//Tests whether a word can be made when a square in the list has no letter
	//Should throw a null pointer exception
	public void testNullLetterInList(){
		PlayerSquare square = new PlayerSquare(1,1);
		set.add(2,square);
		try{
			PlayerWord word = new PlayerWord(set);
			assertTrue(false);
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
	}
	
	//Tests whether a word can be made when an element of the list is null
	//Should throw a null pointer exception
	public void testNullInList(){
		set.add(2,null);
		try{
			PlayerWord word = new PlayerWord(set);
			assertTrue(false);
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
	}
}
