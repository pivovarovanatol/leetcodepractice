package com.leetcode.algors.MinimumSizeSubarraySum;
//  https://leetcode.com/problems/minimum-size-subarray-sum/

public class Start {

	public static void main(String[] args) {
		Solution sl = new Solution();
		int[] nums = {3, 1, 4, 1, 5};
		int s=7;
		
		int result = sl.minSubArrayLen(s, nums);
		System.out.println(result);

		result = sl.minSubArrayLen1(s, nums);
		System.out.println(result);
	}

}
