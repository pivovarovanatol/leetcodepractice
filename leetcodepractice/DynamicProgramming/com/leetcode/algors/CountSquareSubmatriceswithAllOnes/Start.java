package com.leetcode.algors.CountSquareSubmatriceswithAllOnes;
// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[][] matrix = {
//				  {0,1,1,1},
//				  {1,1,1,1},
//				  {0,1,1,1}
//				};
//		int expected = 15;

//		int[][] matrix = {
//				  {1,0,1},
//				  {1,1,0},
//				  {1,1,0}
//				};
//		int expected = 7;
		
		int[][] matrix = {
				  {1,1,1},
				  {1,0,1},
				  {1,1,1}
				};
		int expected = 8;
		
//		int[][] matrix = {
//				  {0,0,0},
//				  {0,1,0},
//				  {0,1,0},
//				  {1,1,1},
//				  {1,1,0}
//				};
//		int expected = 8;

		Solution sl = new Solution();
		int result = sl.countSquares(matrix);
		System.out.println("Actual: " + result);
		System.out.println("Expected: " + expected);
	}
}
