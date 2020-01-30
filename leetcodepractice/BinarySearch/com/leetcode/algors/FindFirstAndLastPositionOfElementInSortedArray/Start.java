package com.leetcode.algors.FindFirstAndLastPositionOfElementInSortedArray;

public class Start {

	public static void main(String[] args) {
		
		int[] nums = {5,7,7,8,8,10};
		int target=7;
		int[] expected= {1,2};
		
		Solution sl = new Solution();
		int[] actual = sl.searchRange(nums, target);
		
		System.out.println(actual[0] + " " + actual[1]);

	}

    

}
