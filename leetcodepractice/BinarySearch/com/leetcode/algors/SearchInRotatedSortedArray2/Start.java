package com.leetcode.algors.SearchInRotatedSortedArray2;
//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Start {

	public static void main(String[] args) {
		int[] nums = {2,5,6,0,0,1,2};
		int target = 0;
		
		boolean actual = new Solution().search(nums, target);
		
		System.out.println(actual);
	}
	

}
