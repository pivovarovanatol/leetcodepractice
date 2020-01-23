package com.leetcode.algors.IslandPerimeter;
// https://leetcode.com/problems/island-perimeter/

public class Start {

	public static void main(String[] args) {
		
		int[][] grid = {{0,1,0,0},
						{1,1,1,0},
						{0,1,0,0},
						{1,1,0,0}
						}; 
		
		Solution sl = new Solution();
		int actual = sl.islandPerimeter(grid);
		System.out.println(actual);
	}

}
