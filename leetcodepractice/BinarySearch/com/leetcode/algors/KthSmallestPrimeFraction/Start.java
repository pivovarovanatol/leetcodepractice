package com.leetcode.algors.KthSmallestPrimeFraction;
//https://leetcode.com/problems/k-th-smallest-prime-fraction/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,3,5,7,11, 13};
		int k = 5;
		Solution sl = new Solution();
		int[] result = sl.kthSmallestPrimeFraction2(nums, k);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		result = sl.kthSmallestPrimeFraction(nums, k);
		System.out.println(result[0]);
		System.out.println(result[1]);

		
	}
	
	
    
}

