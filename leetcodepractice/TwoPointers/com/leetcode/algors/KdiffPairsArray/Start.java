package com.leetcode.algors.KdiffPairsArray;
// https://leetcode.com/problems/sort-colors/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sl = new Solution();
		int[] nums = {3, 1, 4, 1, 5};
		int k=2;
		int result = sl.findPairs(nums, k);
		System.out.println(result);
	}

}
