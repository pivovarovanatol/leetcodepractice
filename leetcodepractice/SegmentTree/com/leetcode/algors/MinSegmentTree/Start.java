package com.leetcode.algors.MinSegmentTree;
// https://leetcode.com/problems/sum-of-subarray-minimums/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,2,5};
		int lower=2;
		int upper=4;
		int expected=2;

		Solution sl = new Solution();
		int result = sl.getMinRange(arr, lower, upper);
		System.out.println(result);
		
		System.out.println(expected);
		
	}

}
