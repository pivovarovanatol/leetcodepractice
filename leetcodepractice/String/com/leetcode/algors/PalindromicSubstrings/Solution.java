package com.leetcode.algors.PalindromicSubstrings;
// https://leetcode.com/problems/palindromic-substrings/


// solved. 1ms(<100%) 
class Solution {
    public int countSubstrings(String s) {
       
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;
        int center = 0;
        
        // count odd palindromic substrings
        while (center <= n-1){
            int left = center, right = center; 
            while (left >=0 && right <= n-1 && chars[left]==chars[right]){
                count++;
                left--;
                right++;
            }
            center++;
        }
        center = 0;
        // count even palindrome
        while (center <= n-2){
            int left = center, right = center+1; 
            while (left >=0 && right <= n-1 && chars[left]==chars[right]){
                count++;
                left--;
                right++;
            }
            center++;
        }        
        
        return count;
    }
}
