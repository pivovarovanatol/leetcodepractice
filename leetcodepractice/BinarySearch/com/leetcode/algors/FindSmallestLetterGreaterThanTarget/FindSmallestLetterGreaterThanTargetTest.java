package com.leetcode.algors.FindSmallestLetterGreaterThanTarget;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallestLetterGreaterThanTargetTest {

	@Test
	public void findSmallestLetterGreaterThanTargetCase1() {
		// having
		char[] letters = {'c', 'f', 'j'};
		char target = 'a';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'c';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findSmallestLetterGreaterThanTargetCase2() {
		// having
		char[] letters = {'c', 'f', 'j'};
		char target = 'c';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'f';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findSmallestLetterGreaterThanTargetCase3() {
		// having
		char[] letters = {'c', 'f', 'j'};
		char target = 'd';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'f';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findSmallestLetterGreaterThanTargetCase4() {
		// having
		char[] letters = {'c', 'f', 'j'};
		char target = 'g';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'j';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findSmallestLetterGreaterThanTargetCase5() {
		// having
		char[] letters = {'c', 'f', 'j'};
		char target = 'j';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'c';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void findSmallestLetterGreaterThanTargetCase6() {
		// having
		char[] letters = {'c', 'f', 'j'};
		char target = 'k';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'c';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findSmallestLetterGreaterThanTargetCase7() {
		// having
		char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
		char target = 'e';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'n';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void findSmallestLetterGreaterThanTargetCase8() {
		// having
		char[] letters = {'e','e','e','k','q','q','q','v','v','y'};
		char target = 'v';
		
		// when
		Solution sl = new Solution();
		char actual = sl.nextGreatestLetter(letters, target);
		char expected = 'y';
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
	
}
