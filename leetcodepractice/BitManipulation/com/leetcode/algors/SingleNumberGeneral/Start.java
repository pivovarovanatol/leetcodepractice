package com.leetcode.algors.SingleNumberGeneral;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {7,1,2,1,3,2,5,6,6,7};
		
		Solution sl = new Solution();
		int[] result = sl.twoSingleNumbersAmoungDoubles(nums);
		
		System.out.println(result[0] + " " + result[1]);
	}
}

