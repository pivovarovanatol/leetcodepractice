package com.leetcode.algors.LongestCommonSubsequence;
// https://leetcode.com/problems/longest-common-subsequence/


class Solution {
	// sovled with DP in 7ms (<94%)
    public int longestCommonSubsequence(String text1, String text2) {
        int max = 0;
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        
        int[][] res = new int[str1.length][str2.length];
        
        for (int i=0;i<str1.length;i++) {
        	for (int j=0;j<str2.length;j++) {
        		char ch1 = str1[i];
        		char ch2 = str2[j];
        		
        		if (str1[i]==str2[j]) {
        			int up = i > 0 ? res[i-1][j] : 0;
        			int left = j > 0 ? res[i][j-1] : 0;
        			int diag = (j > 0 && i > 0) ? res[i-1][j-1] : 0;
        			int t = Math.max(Math.max(up, left), diag);
        			t = diag;
        			res[i][j]=t+1;
        		} else {
        			int up = i > 0 ? res[i-1][j] : 0;
        			int left = j > 0 ? res[i][j-1] : 0;
        			int t = Math.max(up, left);
        			res[i][j]=t;
        		}
        		
        	}
        }
        
//        for (int i=0;i<str1.length;i++) {
//        	for (int j=0;j<str2.length;j++) {
//        		System.out.print(res[i][j] + ",");;
//        	}
//        	System.out.println();
//        }
        
        max = res[str1.length-1][str2.length-1];
        return max;
    }
	
	
	
    public int longestCommonSubsequence2(String text1, String text2) {
        // trying to solve with brute force
        int max = 0;
        
        for (int j=0;j<text1.length();j++) {
            int res = 0;
            int pointer =0;
            String str2 = text2;
            char[] str1 = text1.toCharArray();
            
            for (int i=0;i<str1.length;i++){
                int next = str2.indexOf(str1[i]);
                if (next > -1 ) {
                    res++;
                    pointer = next;
                    if (str2.length() > 1) str2 = str2.substring(next+1, str2.length());
                }
            }
            max = Math.max(max, res);
            if (text1.length() > 2) text1 = text1.substring(2, text1.length());
        }
        
        return max;
    }
}