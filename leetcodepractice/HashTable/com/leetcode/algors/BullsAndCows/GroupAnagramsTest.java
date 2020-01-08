package com.leetcode.algors.BullsAndCows;
//https://leetcode.com/problems/bulls-and-cows/


import org.junit.Assert;
import org.junit.Test;

public class GroupAnagramsTest {

	@Test
	public void getHintCase1() {
		// given
		String secret="1807";
		String guess="7810";
		
		// when
		String result = new Solution().getHint(secret, guess);
		String expected = "1A3B";
		
		// then
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void getHintCase2() {
		// given
		String secret="1123";
		String guess="0111";
		
		// when
		String result = new Solution().getHint(secret, guess);
		String expected = "1A1B";
		
		// then
		Assert.assertEquals(expected, result);
	}
		
}
