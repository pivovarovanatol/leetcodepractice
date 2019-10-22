package com.leetcode.algors.ExcelSheetColumnTitle;
//https://leetcode.com/problems/sqrtx/

class Solution {
	

    public String convertToTitle(int n) {
     
    	int level1 = 26;
    	int level2 = level1 * level1;
    	int level3 = level2 * level1;
    	int level4 = level3 * level1;
    	int level5 = level4 * level1;
    	
    	
    	char letter5 = 0;
    	char letter4 = 0;
    	char letter3 = 0;
    	char letter2 = n > level1 ? (char)(64 + (n/level1)% 26) : ' ';
    	char letter1 = (char) (64 + (n % 27));
    	
    	System.out.println(String.valueOf(letter5) + String.valueOf(letter4) + String.valueOf(letter3) + String.valueOf(letter2) + String.valueOf(letter1));
    	
    	
    	return null;
    }
}