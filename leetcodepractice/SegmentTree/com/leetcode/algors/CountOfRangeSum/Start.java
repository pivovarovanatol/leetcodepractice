package com.leetcode.algors.CountOfRangeSum;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] nums = {-2,5,-1};
//		int lower=-2;
//		int upper=2;
		
//		int[] nums = {-2147483647,0,-2147483647,2147483647};
//		int lower=-564;
//		int upper=3864;
//		int expected=3;

		int[] nums = {-5,4,-3,2,-1,0,1,-2,3,-4,5};
		int lower=-1;
		int upper=1;
		int expected=3;

//		int[] nums = {1,2,3};
//		int lower=1;
//		int upper=3;
//		int expected=3;

		Solution sl = new Solution();
		int result = sl.countRangeSum(nums, lower, upper);
		System.out.println(result);

		result = sl.countRangeSum2(nums, lower, upper);
		System.out.println(result);

		//System.out.println(expected);
		
		
	}

}
