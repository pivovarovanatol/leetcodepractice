package com.leetcode.algors.ExcelSheetColumnTitle;
//https://leetcode.com/problems/sqrtx/

class Solution {
	
    public String convertToTitle(int n) throws InterruptedException {
        
    	int level1 = 26;
    	int level2 = level1 * level1;
    	int level3 = level2 * level1;
    	int level4 = level3 * level1;
    	int level5 = level4 * level1;
    	int tmp=0;
    	
    	char letter5=' ';
    	char letter4=' ';
    	char letter3=' ';
    	char letter2=' ';
    	char letter1=' ';
    	
    	for (int i=16380;i<=16385;i++) {
    		
    		letter1 = (char) (65 + (i % 26));
    		
    		if (i > 25) {
    			letter2 = (char) (65 + ((i/26-1) % 26));
    		}

    		if (i > 701) {
    			tmp = i/(702);
    			letter3 = (char) (65 + ((tmp-1) % 26));
    		}
    		
    		System.out.println(i + " + " + letter3 + letter2 + letter1);
    		//Thread.sleep(20);
    	}
    	
    	
    	
    	//System.out.println(String.valueOf(letter5) + String.valueOf(letter4) + String.valueOf(letter3) + String.valueOf(letter2) + String.valueOf(letter1));
    	
    	
    	return null;
    }
	
	
    public String convertToTitle2(int n) {
     
    	int level1 = 26;
    	int level2 = level1 * level1;
    	int level3 = level2 * level1;
    	int level4 = level3 * level1;
    	int level5 = level4 * level1;
    	int tmp=0;
    	
    	char letter5 = 0;
    	tmp = (n/(26*26*26 + 26*26 + 26))-1;
    	char letter4 = tmp >= 0 ? (char) (65 + (tmp % 26)) : ' ';
    	tmp = (n/(26*26 + 26))-1;
    	char letter3 = tmp >= 0 ? (char) (65 + (tmp % 26)) : ' ';
    	tmp = (n/26)-1;
    	char letter2 = tmp >= 0 ? (char) (65 + (tmp % 26)) : ' ';
    	char letter1 = (char) (65 + (n % 26));
    	
    	System.out.println(String.valueOf(letter5) + String.valueOf(letter4) + String.valueOf(letter3) + String.valueOf(letter2) + String.valueOf(letter1));
    	
    	
    	return null;
    }
}