package com.leetcode.algors.DFS.NumberOfIslands;
// https://leetcode.com/problems/number-of-islands/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] arr = {{'1','1','0', '0'},
					{'0','0','0','1'},
					{'1','1','0','0'}};
		
		Solution sl = new Solution();
		int result = sl.numIslands(arr);
		System.out.println(result);
	}
}
