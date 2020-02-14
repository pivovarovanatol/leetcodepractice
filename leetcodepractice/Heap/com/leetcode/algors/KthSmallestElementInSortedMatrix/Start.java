package com.leetcode.algors.KthSmallestElementInSortedMatrix;
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 6;
		int[][] matrix = {{1,2,3,4,5},
						  {1,3,5,7,9},
						  {1,4,7,10,13},
						  {1,5,9,13,17}};
		Solution sl = new Solution();
		System.out.println(sl.kthSmallest(matrix, k));
	}
    
}

