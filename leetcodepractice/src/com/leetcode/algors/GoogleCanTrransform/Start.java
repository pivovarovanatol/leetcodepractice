package com.leetcode.algors.GoogleCanTrransform;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution sl = new Solution();
//		String source = "abcdefghijklmnopqrstuvwxyz";
//		String destination = "zyxwvutsrqponmlkjihgfedcba";
		
//		String source = "abcdefghijklmnopqrstuvwxyz";
//		String destination = "bcdefghijklmnopqrstuvwxyza";

		String source = "ab";
		String destination = "aa";
		
		
		boolean result = sl.canTransform(source, destination);
		
		System.out.println(result);
		
		
	}
}
