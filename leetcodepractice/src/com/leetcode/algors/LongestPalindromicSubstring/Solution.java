package com.leetcode.algors.LongestPalindromicSubstring;

import java.util.HashMap;

class Solution {
    public String longestPalindrome4(String s) {
        
        // String test = "a";
        char[] arr = s.toCharArray();
        HashMap<String, Boolean> isPal = new HashMap<String, Boolean>();
        int maxLen = 0;
        String maxStr = "";
        int n = arr.length;
        String tmp  = null;
        
        //System.out.println(n);
        
        for (int i=0;i<n;i++) {
            for (int j=i;j<n;j++){
                //Check if current substr len is less tham current max palindrome Len. If yes - skip the substring, because it won't be bigger.
                
                if (j-i < maxLen){
                    continue;
                }
                
                // Get the new substring
                tmp = new String(arr, i, j-i+1);
                //System.out.println(tmp);
                //Check if already was analysed. If yes -> no need to analyze again
                if (isPal.containsKey(tmp)) {
                    // continue;
                } else {
                    // Check if the substr is a palindrome and put that in the HashMap
                    boolean isPalindrome = isPalindrome(arr, i,j);
                    isPal.put(tmp, isPalindrome);
                    // if subsr is a palindrome -> check the len and if it's higher than max -> set new max
                    if (isPalindrome){
                        int len = j-i+1;
                        if (len > maxLen){
                            maxLen = len;
                            maxStr = tmp;
                        }
                    }
                }
            }
        }
        
        return maxStr;
    }
    
    
    boolean isPalindrome(char[] arr, int start, int end){
        
        if (start == end) {
            return true;
        }
        
        if (start > end) {
            return true;
        }
        
        if (arr[start]!=arr[end]){
            return false;
        } else {
            return isPalindrome(arr, start+1, end-1);
        }
    }

    
    // solved in 227ms (<11%) 50MB(<6%)
    public String longestPalindrome2(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max = Integer.MIN_VALUE;
        String output = "";
        for(int i=0;i<s.length();i++){
            dp[i][i] = 1;
            output = s.substring(i,i+1);
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)){
                dp[i][i-1] = 1;
                output = s.substring(i-1,i+1);
            }
        }
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<i-1;j++){
                if(s.charAt(i) == s.charAt(j) && dp[i-1][j+1] == 1){
                    String temp = s.substring(j,i+1);
                    if(temp.length() > max){
                        max = i-j+1;
                        output = temp;
                    }
                    dp[i][j] = 1;
                }
            }
        }
        return output;
    }

    
    // 27ms (<50%) 37MB(<92%)
    public String longestPalindrome3(String s) {
    	  if (s == null || s.length() == 0) {
    	    return "";
    	  }
    	  int n = s.length();
    	  boolean[][] dp = generateDP(s);
    	  // Check each substring
    	  int maxLen = 0;
    	  int[] maxIdx = new int[] { 0, 0 };
    	  for (int i = 0; i < n; ++i) {
    	    for (int j = i; j < n; ++j) {
    	      if (dp[i][j] == true) {
    	        if (j - i + 1 > maxLen) {
    	          maxLen = j - i + 1;
    	          maxIdx[0] = i;
    	          maxIdx[1] = j;
    	        }
    	      }
    	    }
    	  }
    	  return s.substring(maxIdx[0], maxIdx[1] + 1);
    	}

    	private boolean[][] generateDP(String s) {
    	  int n = s.length();
    	  boolean[][] dp = new boolean[n][n];
    	  // Init
    	  for (int i = 0; i < n; ++i) { // diagonal
    	    dp[i][i] = true;
    	  }
    	  for (int i = 0; i < n - 1; ++i) { // one line below diagonal
    	    dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
    	  }
    	  // DP
    	  for (int i = n - 3; i >= 0; --i) {
    	    for (int j = i + 2; j < n; ++j) {
    	      dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
    	    }
    	  }
    	  return dp;
    	}    
    	
    	
    	// Manacher Algorithm
    	// 25ms (<51%) 36.6MB(<100%)
        public String longestPalindrome(String s) {
            if(s.length() <= 1)
                return s;
             String sb = "$#";
             for(char c : s.toCharArray())
             {
                 sb+=c;
                 sb+="#";
             }
             sb+="@";
             int[] p = new int[sb.length()];
             int mx = 0 ; 
             int id = 0;
             int resLen = 0;
             int resCenter = 0;
             for(int i = 1; i < p.length-1;i++)
             {
                 p[i] = mx > i ? Math.min(p[2*id-i],mx-i) : 1;
                 while(sb.charAt(i + p[i] ) == sb.charAt(i - p[i] )) p[i]++;
                 if(mx < i + p[i])
                 {
                     mx = i + p[i];
                     id = i;
                 }
                 if(resLen < p[i]){
                     resLen = p[i];
                     resCenter = i;
                 }
             }
             return s.substring((resCenter-resLen)/2,(resCenter-resLen)/2+resLen-1);
         }
    	
    
}
