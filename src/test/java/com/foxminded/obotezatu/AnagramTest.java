package com.foxminded.obotezatu;

import static org.junit.Assert.*;
import org.junit.Test;

public class AnagramTest {

	@Test
	public void testReverseTextWithEmptyString() {
		String reversedText = Anagram.reverseText("");
		assertEquals( "", reversedText);
	}
	
	@Test
	public void testReverseTextOnlyNumbers() {
		String reversedText = Anagram.reverseText("123456");
		assertEquals("123456", reversedText);
	}
	
	@Test
	public void testReverseTextWithNumber() {
		String reversedText = Anagram.reverseText("He2llo Wor4ld");
		assertEquals("ol2leH dlr4oW", reversedText);
	}

	@Test
	public void testReverseTextWithNumbersAndSpecChar() {
		String reversedText = Anagram.reverseText("In12put a phr!!ase:");
		assertEquals("tu12pnI a esa!!rhp:", reversedText);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testReverseTextWithNullArg() {
		Anagram.reverseText(null);
	}
}
