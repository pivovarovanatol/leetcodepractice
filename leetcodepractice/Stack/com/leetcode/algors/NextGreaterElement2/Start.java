package com.leetcode.algors.NextGreaterElement2;
//https://leetcode.com/problems/next-greater-element-ii/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sl = new Solution();
		int[] nums1 = {5,4,3,2,1};
		
		int[] result = sl.nextGreaterElements(nums1);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
		
	}

}
