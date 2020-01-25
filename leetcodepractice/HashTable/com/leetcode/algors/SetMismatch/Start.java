package com.leetcode.algors.SetMismatch;
// https://leetcode.com/problems/island-perimeter/

public class Start {

	public static void main(String[] args) {
		
		int[] nums = {1,2,2,4}; 
		
		Solution sl = new Solution();
		int[] actual = sl.findErrorNums(nums);
		System.out.println(actual[0]);
		System.out.println(actual[1]);
	}

}
