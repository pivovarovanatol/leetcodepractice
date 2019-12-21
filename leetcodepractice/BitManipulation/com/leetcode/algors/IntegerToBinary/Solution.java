package com.leetcode.algors.IntegerToBinary;

public class Solution {
	public String intToBinary(int n) {
		StringBuilder sb = new StringBuilder();
		boolean negative = n < 0;
		while (n != 0) {
			if (n%2 == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			n = n >>> 1;
		}
		String result = sb.reverse().toString();
		
		if (negative) {
			result = result.substring(0,result.length()-1)+"1";
		}
		
		return result;
	}
}