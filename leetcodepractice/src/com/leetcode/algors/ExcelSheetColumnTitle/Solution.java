package com.leetcode.algors.ExcelSheetColumnTitle;
//https://leetcode.com/problems/sqrtx/

class Solution {
    public String convertToTitle(int n) {

    	if (n <= 26) {
    		return Character.toString((char) (64 + n));
    	}
    	int full = n/26;
    	int currChar = n - full * 26;
    	
        if (n%26==0) {
            full--;
            currChar=26-currChar % 26;
        }
    	return convertToTitle(full) + Character.toString((char) (64 + currChar));
    }

}