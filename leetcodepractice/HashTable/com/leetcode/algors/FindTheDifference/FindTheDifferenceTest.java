package com.leetcode.algors.FindTheDifference;
//https://leetcode.com/problems/find-the-difference/


import org.junit.Assert;
import org.junit.Test;

public class FindTheDifferenceTest {

	@Test
	public void findDifferenceTestCase1() {
		// given
		String s="a";
		String t="aa";
		
		// when
		char result = new Solution().findTheDifference(s, t);
		char expected = 'a';
		
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void findDifferenceTestCase2() {
		// given
		String s="anatoliy";
		String t="anatoyliy";
		
		// when
		char result = new Solution().findTheDifference(s, t);
		char expected = 'y';
		
		// then
		Assert.assertEquals(expected, result);
	}
		
}
