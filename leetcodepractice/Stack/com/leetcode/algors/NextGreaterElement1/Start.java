package com.leetcode.algors.NextGreaterElement1;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sl = new Solution();
		int[] nums1 = {4,1,2,8};
		int[] nums2 = {1,3,4,2,8,5,6,7,11};
		
		int[] result = sl.nextGreaterElement(nums1, nums2);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
		
	}

}
