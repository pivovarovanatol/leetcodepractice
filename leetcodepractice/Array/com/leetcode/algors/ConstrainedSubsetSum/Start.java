package com.leetcode.algors.ConstrainedSubsetSum;
// https://leetcode.com/problems/constrained-subset-sum/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {10,2,-10,5,20};
		int k= 2;
		Solution sl = new Solution();
		int result = sl.constrainedSubsetSum(nums, k);

		System.out.println(result);
		
	}
    
}

