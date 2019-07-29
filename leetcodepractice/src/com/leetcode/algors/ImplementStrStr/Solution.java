package com.leetcode.algors.ImplementStrStr;


class Solution {
    public int strStr(String haystack, String needle) {
        char[] arr = haystack.toCharArray();
        char[] example = needle.toCharArray();
        int n = arr.length;
        int len = example.length;
        int index = 0;
        
        if (n==0 && len==0) {return 0;}
        if (n==0) {return -1;}
        if (len==0) {return 0;}
        if (len > n) {return -1;}
        
        for (int i=0;i<n;i++) {
        	index=0;
        	while (arr[i+index]==example[index]) {
        		if (index==len-1) {
        			return i;
        		}
        		index++;
        		if (i+index>=n) {
        			return -1;
        		}
        	}
        }
    	return -1;
    }
}