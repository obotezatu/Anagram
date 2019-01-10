package com.foxminded.obotezatu;

import java.util.Arrays;
import java.util.Scanner;
import static java.util.stream.Collectors.joining;
import static java.lang.Character.isAlphabetic;

public class Anagram {

	private static final String DELIMITER = " ";

	public static void main(String[] args) {
		String text=null;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Input a phrase: ");
			text = scanner.nextLine();
		}
		System.out.println(reverseText(text));
	}

	public static String reverseText(String text) {
		if(text == null) {
			throw new IllegalArgumentException("Function argument is null!");
		}
		return Arrays.stream(text.split(DELIMITER)).map(Anagram::reverseWord).collect(joining(DELIMITER));
	}

	private static String reverseWord(String word) {
		char[] chars = word.toCharArray();
		int leftIndex = 0;
		int rightIndex = chars.length - 1;
		while (leftIndex < rightIndex) {
			if (!isAlphabetic(chars[leftIndex])) {
				leftIndex++;
			} else if (!isAlphabetic(chars[rightIndex])) {
				rightIndex--;
			} else {
				char leftChar = chars[leftIndex];
				chars[leftIndex] = chars[rightIndex];
				chars[rightIndex] = leftChar;
				leftIndex++;
				rightIndex--;
			}
		}
		return new String(chars);
	}
}