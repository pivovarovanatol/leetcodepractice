package com.leetcode.algors.UniquePaths2;
// https://leetcode.com/problems/unique-paths-ii/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution sl = new Solution();
		int[][] obstacleGrid = {{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0}};
		
		int result = sl.uniquePathsWithObstacles(obstacleGrid);
		
		System.out.print(result);
		
		//System.out.println(result);
	}
}
