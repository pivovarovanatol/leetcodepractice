package com.leetcode.algors.CoinChange;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {
	@Test
	public void testCoinChangeSet1() {
		int[] coins = {470,18,66,301,403,112,360};
		int amount = 8235;
		int expected = 20;
		Solution sl = new Solution();
		int actual = sl.coinChange(coins, amount);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCoinChangeSet2() {
		int[] coins = {1,2,5};
		int amount = 11;
		int expected = 3;

		Solution sl = new Solution();
		int actual = sl.coinChange(coins, amount);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCoinChangeSet3() {
		int[] coins = {186,419, 83,408};
		int amount = 6249;
		int expected = 20;
		Solution sl = new Solution();
		int actual = sl.coinChange(coins, amount);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCoinChangeSet4() {
		int[] coins = {5,4,1};
		int amount = 63;
		int expected = 13;

		Solution sl = new Solution();
		int actual = sl.coinChange(coins, amount);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCoinChangeSet5() {
		int[] coins = {21,19,23};
		int amount = 377;
		int expected = 17;
		Solution sl = new Solution();
		int actual = sl.coinChange(coins, amount);
		Assert.assertEquals(expected, actual);
	}
		
	
	
}
