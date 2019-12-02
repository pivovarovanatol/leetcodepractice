package com.leetcode.algors.MissingNumber;
// https://leetcode.com/problems/missing-number/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {0,1,2,3,5,6,7};
		
		Solution sl = new Solution();
		int result = sl.missingNumber(arr);
		System.out.println(result);
	}
}

/* 
 * 000001
 *   1111
 * 010000
 * 
 * 
 * */
