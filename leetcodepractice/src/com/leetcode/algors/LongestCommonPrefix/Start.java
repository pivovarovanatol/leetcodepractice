package com.leetcode.algors.LongestCommonPrefix;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"flower","flow","flight"};

		int n= arr.length;
		
		Solution sl = new Solution();
		String result = sl.longestCommonPrefix(arr);
		System.out.println(result);
	}

}
