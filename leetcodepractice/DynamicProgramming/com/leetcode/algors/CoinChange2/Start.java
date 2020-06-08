package com.leetcode.algors.CoinChange2;
// https://leetcode.com/problems/climbing-stairs/

public class Start {

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 3;
		int expected = 4;
		
		
		Solution sl = new Solution();
		int actual = sl.change(amount, coins);
		System.out.println(actual);
		System.out.println(expected);
	}
}

