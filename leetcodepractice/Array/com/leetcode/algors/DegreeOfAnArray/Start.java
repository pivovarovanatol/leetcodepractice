package com.leetcode.algors.DegreeOfAnArray;
// https://leetcode.com/problems/degree-of-an-array/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1, 2, 2, 3, 1};

		Solution sl = new Solution();
		int result = sl.findShortestSubArray(arr1);

		System.out.println(result);
		System.out.print(" ");
	}
    
}

