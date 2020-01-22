package com.leetcode.algors.SearchInRotatedSortedArray;
//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Start {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		
		int actual = new Solution().search(nums, target);
		
		System.out.println(actual);
	}
	

}
