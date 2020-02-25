package com.leetcode.algors.PalindromicSubstrings;

import org.junit.Assert;
import org.junit.Test;


public class PalindromicSubstringTest {

	@Test
	public void testPalindromicSubstringsSentence() {
		// Given
		String s = "A man, a plan, a canal: Panama";
		Solution sl = new Solution();
		
		// When
		int actual = sl.countSubstrings(s);
		int expected = 35;
		
		// Then
		Assert.assertEquals("Testing number of substrings: ", expected, actual);
	}

	@Test
	public void testPalkindromicSubstringsThreeLetters() {
		// Given
		String s = "abc";
		Solution sl = new Solution();
		
		// When
		int actual = sl.countSubstrings(s);
		int expected = 3;
		
		// Then
		Assert.assertEquals("Testing number of substrings: ", expected, actual);
	}

	@Test
	public void testPalkindromicSubstringsThrepleLetter() {
		// Given
		String s = "aaa";
		Solution sl = new Solution();
		
		// When
		int actual = sl.countSubstrings(s);
		int expected = 6;
		
		// Then
		Assert.assertEquals("Testing number of substrings: ", expected, actual);
	}
	
	
}
