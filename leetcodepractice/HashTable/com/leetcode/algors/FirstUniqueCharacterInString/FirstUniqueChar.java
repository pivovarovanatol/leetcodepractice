package com.leetcode.algors.FirstUniqueCharacterInString;
//https://leetcode.com/problems/first-unique-character-in-a-string/

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqueChar {

	@Test
	public void firstUniqueCharCase1() {
		// given
		String input = "leetcode";
		
		// when
		int expected = 0;
		int result = new Solution().firstUniqChar(input);

		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void firstUniqueCharCase2() {
		// given
		String input = "c";
		
		// when
		int expected = 0;
		int result = new Solution().firstUniqChar(input);

		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void firstUniqueCharCase3() {
		// given
		String input = "cc";
		
		// when
		int expected = -1;
		int result = new Solution().firstUniqChar(input);

		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void firstUniqueCharCase4() {
		// given
		String input = "aadadaad";
		
		// when
		int expected = -1;
		int result = new Solution().firstUniqChar(input);

		// then
		Assert.assertEquals(expected, result);
	}
	
	
}
