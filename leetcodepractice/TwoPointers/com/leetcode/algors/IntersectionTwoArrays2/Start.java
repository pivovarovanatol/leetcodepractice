package com.leetcode.algors.IntersectionTwoArrays2;
// https://leetcode.com/problems/sort-colors/


public class Start {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sl = new Solution();
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		
		int[] result = sl.intersect(nums1, nums2);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
		
	}

}
