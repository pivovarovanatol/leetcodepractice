package com.leetcode.algors.CoinChange2;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {
	@Test
	public void testCoinChangeSet2() {
		int[] coins = {1,2,5};
		int amount = 5;
		int expected = 4;

		Solution sl = new Solution();
		int actual = sl.change(amount, coins);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCoinChangeSet3() {
		int[] coins = {2};
		int amount = 3;
		int expected = 0;
		Solution sl = new Solution();
		int actual = sl.change(amount, coins);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCoinChangeSet4() {
		int[] coins = {10};
		int amount = 10;
		int expected = 1;

		Solution sl = new Solution();
		int actual = sl.change(amount, coins);
		Assert.assertEquals(expected, actual);
	}
		
	
	
}
