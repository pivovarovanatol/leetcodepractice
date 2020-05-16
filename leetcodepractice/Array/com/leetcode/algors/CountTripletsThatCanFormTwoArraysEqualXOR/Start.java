package com.leetcode.algors.CountTripletsThatCanFormTwoArraysEqualXOR;
//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = {2,3,1,6,7};
//		int expected= 4;
		
//		int[] arr = {7,11,12,9,5,2,7,17,22};
//		int expected= 8;
		
		int[] arr = {1,1,1,1,1};
		int expected= 10;
		
		Solution sl = new Solution();
		int result = sl.countTriplets(arr);

		System.out.println(result + " = " + expected);
		
	}
    
}

