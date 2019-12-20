package com.leetcode.algors.BitManipulationGeneral;


public class Start {

	public static void main(String[] args) {
		
		
	}
	
	static int binaryToInt(String s) {
		
		int res=0;
		char[] arr = s.toCharArray();
		
		for (int i=s.length()-1;i>=0;i--) {
			if (arr[i]=='1') {
				res = res + (int) Math.pow(2, s.length()-i-1);
			}
			
		}
		
		return res;
	}
}

