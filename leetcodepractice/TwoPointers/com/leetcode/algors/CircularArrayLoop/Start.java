package com.leetcode.algors.CircularArrayLoop;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] nums = {-2,1,-1,-2,-2}; // false
//		int[] nums = {-1,-2,-3,-4,-5}; // false
//		int[] nums = {2,-1,1,2,2}; // true
//		int[] nums = {-1,2}; // false
//		int[] nums = {3,1,2}; // false
		int[] nums = {-2,-3,-9}; // false
		
		Solution sl = new Solution();
		
		boolean result;
		result = sl.circularArrayLoop(nums);
		
		System.out.println(result);
		
		
	}

}
