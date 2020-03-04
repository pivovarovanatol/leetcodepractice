package com.leetcode.algors.MaximumLengthOfRepeatedSubarray;
// https://leetcode.com/problems/climbing-stairs/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,7,8,9};
		int[] B = {10,9,8,7,1,2,3,4,5};
		
//		int[] A = {1,0,0,0,1};
//		int[] B = {1,0,0,1,1};
		
//		int[] A = {1,2,3,2,1};
//		int[] B = {3,2,1,4,7};

		int result = new Solution().findLength(A, B);
		System.out.println(result);

		int result2 = new Solution().findLength1(A, B);
		System.out.println(result2);
	
	}
}
