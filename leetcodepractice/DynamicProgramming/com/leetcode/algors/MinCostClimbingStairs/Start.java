package com.leetcode.algors.MinCostClimbingStairs;
// https://leetcode.com/problems/maximal-square/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

		Solution sl = new Solution();
		int result = sl.minCostClimbingStairs(cost);
		System.out.println(result);
	}

}
