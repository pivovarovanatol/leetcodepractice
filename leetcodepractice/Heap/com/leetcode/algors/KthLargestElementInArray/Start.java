package com.leetcode.algors.KthLargestElementInArray;
// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 2;
		int[] nums = {3,2,1,5,6,4};
		Solution sl = new Solution();
		System.out.println(sl.findKthLargest(nums, k));
		System.out.println(sl.findKthLargest1(nums, k));
		System.out.println(sl.findKthLargest2(nums, k));
		System.out.println(sl.findKthLargest3(nums, k));
		System.out.println(sl.findKthLargest4(nums, k));
	}
    
}

