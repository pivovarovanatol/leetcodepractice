package com.leetcode.algors.ZigzagConversion;
// https://leetcode.com/problems/zigzag-conversion/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,7,9,3,1};

		// int n= arr.length;
		Solution sl = new Solution();
		String result = sl.convert("PAYPALISHIRING", 3);
		System.out.println(result);
	}

}
