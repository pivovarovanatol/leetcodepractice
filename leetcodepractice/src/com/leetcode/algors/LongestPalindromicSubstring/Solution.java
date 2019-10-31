package com.leetcode.algors.LongestPalindromicSubstring;

import java.util.HashMap;

class Solution {
    public String longestPalindrome(String s) {
        
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
    
}
