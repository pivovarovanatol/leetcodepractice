package com.leetcode.algors.RottingOranges;
// https://leetcode.com/problems/climbing-stairs/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		int expected = 4;
		
//		int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
//		int expected = -1;	
		
//		int[][] grid = {{2,1}};
//		int expected = 1;
		
//		int[][] grid = {{0,2},{0,1},{0,1},{1,1},{1,1},{1,1}};
//		int expected = 6;
		
		Solution sl = new Solution();
		int result = sl.orangesRotting(grid);
		System.out.println(result);
		System.out.println(expected);
	}
}

