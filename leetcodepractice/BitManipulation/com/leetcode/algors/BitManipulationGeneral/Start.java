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

/*
 * 
x & (x-1) will clear the lowest set bit of x
x & ~(x-1) extracts the lowest set bit of x (all others are clear). Pretty patterns when applied to a linear sequence.
x & (x + (1 << n)) = x, with the run of set bits (possibly length 0) starting at bit n cleared.
x & ~(x + (1 << n)) = the run of set bits (possibly length 0) in x, starting at bit n.
x | (x + 1) = x with the lowest cleared bit set.
x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set).
x | (x - (1 << n)) = x, with the run of cleared bits (possibly length 0) starting at bit n set.
x | ~(x - (1 << n)) = the lowest run of cleared bits (possibly length 0) in x, starting at bit n are the only clear bits.

*/
