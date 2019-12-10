package com.leetcode.algors.Search2DMatrix;
//https://leetcode.com/problems/search-a-2d-matrix/


public class Start {

	public static void main(String[] args) {
	    
		int[][] matrix = {
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
				};
		
	    boolean result = new Solution().searchMatrix(matrix, 30);
		System.out.println(result);
		
	}


}
