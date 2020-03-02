package com.leetcode.algors.CoinChange;
// https://leetcode.com/problems/climbing-stairs/

public class Start {

	public static void main(String[] args) {
//		int[] coins = {186,419, 83,408};
//		int amount = 6249;
//		int expected = 20;
		
//		int[] coins = {5,4,1};
//		int amount = 63;
//		int expected = 13;
		
//		int[] coins = {21,19,23};
//		int amount = 377;
//		int expected = 17;
		
//		int[] coins = {5,4,1};
//		int amount = 8;
//		int expected = 2;
		
//		int[] coins = {1,2,5};
//		int amount = 11;
//		int expected = 3;
		
		int[] coins = {470,18,66,301,403,112,360};
		int amount = 8235;
		int expected = 20;
		
		
		Solution sl = new Solution();
		int actual = sl.coinChange(coins, amount);
		System.out.println(actual);
		System.out.println(expected);
	}
}

