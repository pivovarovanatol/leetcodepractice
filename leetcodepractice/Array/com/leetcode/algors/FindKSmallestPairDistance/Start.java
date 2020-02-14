package com.leetcode.algors.FindKSmallestPairDistance;
// https://leetcode.com/problems/find-k-th-smallest-pair-distance/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution sl = new Solution();
		int[] nums = {23,45,22,1,5,8,11,16};
		int k = 5;
		int result = sl.smallestDistancePair(nums, k);
		
		System.out.print(result);
	}
}
