package com.leetcode.algors.MinimumPathSum;
// https://leetcode.com/problems/minimum-path-sum/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] grid = {{1,3,1},
						{1,5,1},
						{4,2,1}};
		int expected = 7;
		Solution sl = new Solution();
		int actual = sl.minPathSum(grid);
		System.out.println(actual + " = " + expected);
	}
}

