package com.leetcode.algors.PlusOne;
// https://leetcode.com/problems/plus-one/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution sl = new Solution();
		int[] digits = {9};
		
		int[] result = sl.plusOne(digits);
		
		for (int i : result) {
			System.out.print(i+" ");
		}
		
		//System.out.println(result);
	}
}
