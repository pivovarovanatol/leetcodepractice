package com.leetcode.algors.ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
    	
    	// Corner cases - empty string
    	if (s.length()==0) {
    		return true;
    	}
    	
    	// Remove everything except letters and number and convert to lower case
    	s = s.toLowerCase();
    	char[] arr = new char[s.length()];
    	int n=0;

    	for (char ch : s.toCharArray()) {
    		if ((ch >='a' && ch <= 'z')) {
    			arr[n] = ch;
    			n++;
    		} else if ((ch >='0' && ch <= '9')) {
    			arr[n] = ch;
    			n++;
    		}

    	}
    	 
    	// Compare from beginning and end to the middle. If not equal -> return false
    	for (int i=0;i<n/2;i++) {
    		
    		if (arr[i] != arr[n-i-1]) {
    			return false;
    		}
    	}
    	//System.out.println(arr);
    	return true;
    }
}