package com.leetcode.algors.LongestDuplicateSubstring;
//https://leetcode.com/problems/longest-duplicate-substring/

import java.util.HashMap;
import java.util.Map;

class Solution {
	
	// from discussions: Binary Search + Rabin-Karp algorithm. 273ms (<93%)
    public String longestDupSubstring(String S) {
        int l = 0;
        int r = S.length() - 1;
        
        while (l < r) {
            int m = l + ((r - l + 1) >> 1);
            
            if (isDuplicatePresent(S, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return findDuplicate(S, l);
    }
    
    private boolean isDuplicatePresent(String S, int length) {
        if (length == 0)
            return true;
        
        return findDuplicate(S, length) != null;
    }
    
    private String findDuplicate(String S, int length) {        
        long hash = 0;
        long prime = 29;
        long firstEntryPower = 1;
        for (int i = 0; i < length; i++) {
            firstEntryPower *= prime;
            hash = hash * prime + (S.charAt(i) - 'a');
        }
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(hash, 0);
        
        for (int i = length; i < S.length(); i++) {
            hash = hash * prime + (S.charAt(i) - 'a');
            hash -= firstEntryPower * (S.charAt(i - length) - 'a');
            
            if (map.containsKey(hash)) {
                int index = map.get(hash);
                return S.substring(index, index + length);
            }
            
            map.put(hash, i - length + 1);
        }
        
        return null;
    }
	
	
	
	// brute force: iterate over all substrings from longest to smallest and check if exists. Return if found. TLE.
    public String longestDupSubstring2(String S) {
        int l=S.length();
        if (S==null || S.length()==0) return "";
        for (int i=l-1;i>=1;i--){
            //System.out.println("Current len is: " + i);
            for (int j=0;j<l-i;j++){
                String sub = S.substring(j, j+i);
                //System.out.println("Sub is: "+sub);
                if (S.indexOf(sub, j+1)!=-1) return sub;
            }
        }
        return "";        
    }
}
