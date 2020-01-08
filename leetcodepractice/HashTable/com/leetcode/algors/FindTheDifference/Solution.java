package com.leetcode.algors.FindTheDifference;
// https://leetcode.com/problems/find-the-difference/

class Solution {
	
	// solved with array and count. O(t+s+26), where t,s - lengths of strings. 1ms(<98%) 35.9MB(<100%)
    public char findTheDifference(String s, String t) {
        // all lower case letters -> we can use array of 26 to count letters in each string.
    	// Count bigger string increasing the counts in the array. Then count for second string decreasing counts. 
    	// In the end go thru array and check what number left -> return that symbol.
        
        int[] arr = new int[26];
        
        for (char ch : t.toCharArray()){
            arr[ch-'a']++;
        }
        
        for (char ch : s.toCharArray()){
            arr[ch-'a']--;
        }
        
        for (int i=0;i<26;i++){
            if (arr[i]>0){
                return (char)('a'+i);
            }
        }
        
        return ' ';
    }
}