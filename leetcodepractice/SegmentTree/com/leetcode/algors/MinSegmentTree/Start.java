package com.leetcode.algors.MinSegmentTree;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,2,5};
		int lower=3;
		int upper=5;
		int expected=3;

		Solution sl = new Solution();
		int result = sl.getMinRange(arr, lower, upper);
		System.out.println(result);
		
		
	}

}
