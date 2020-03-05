package com.leetcode.algors.NextPermutation;
// https://leetcode.com/problems/plus-one/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2,3,1};

		Solution sl = new Solution();
		sl.nextPermutation(nums);
		
		for (int i : nums) {
			System.out.print(i+" ");
		}
		
	}
}
