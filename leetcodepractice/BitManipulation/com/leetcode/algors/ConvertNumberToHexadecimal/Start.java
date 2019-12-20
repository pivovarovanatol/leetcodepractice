package com.leetcode.algors.ConvertNumberToHexadecimal;
//https://leetcode.com/problems/convert-a-number-to-hexadecimal/

public class Start {

	public static void main(String[] args) {
		int n = 777;
		
		Solution sl = new Solution(); 
		String actual = sl.toHex(n);
		System.out.println(actual);

	}
	
}

