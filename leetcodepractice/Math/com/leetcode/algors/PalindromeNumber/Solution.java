package com.leetcode.algors.PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        
        String str = Integer.toString(x);
        char[] arr = str.toCharArray();
        
        int n = arr.length;
        
        for(int i=0;i<n/2;i++){
            if (arr[i]!=arr[n-i-1]){
                return false;
            }
        }
        
        
        return true;
    }
}