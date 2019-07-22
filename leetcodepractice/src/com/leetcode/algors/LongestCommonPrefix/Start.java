package com.leetcode.algors.LongestCommonPrefix;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"Test","Tester","Testicles","Testdriven"};

		int n= arr.length;
		
		Solution sl = new Solution();
		String result = sl.longestCommonPrefix(arr, n);
		System.out.println(result);
	}

}
