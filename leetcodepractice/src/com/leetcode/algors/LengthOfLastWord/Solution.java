package com.leetcode.algors.LengthOfLastWord;

class Solution {
    public int lengthOfLastWord(String s) {
    	s = s.trim();
    	int n = s.length();
        char[] arr = s.toCharArray();
    	for (int i=n-1;i>=0;i--) {
    		if (arr[i]==' ') {
    			return (n-i-1);
    		}
    	}
        
    	return n;
    }
}