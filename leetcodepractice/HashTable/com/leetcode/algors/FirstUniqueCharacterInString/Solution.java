package com.leetcode.algors.FirstUniqueCharacterInString;
//https://leetcode.com/problems/first-unique-character-in-a-string/

import java.util.HashMap;

class Solution {
    
    // From discussions. 1ms(<100%) 37.8MB(<99%)
    public int firstUniqChar(String s) {
        int res = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) res = Math.min(res, index);
        }

        return res == s.length() ? -1 : res;
    }
    
    // Naive approach with HashMap 28ms(<50%) 37MB(<100%)
    public int firstUniqChar2(String s) {
        
        char[] arr=  s.toCharArray();
        int index = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i], -1);
            } else {
                map.put(arr[i],i);
            }
        }
        
        for (int i : map.values()){
            if (i >-1){
                if (index == -1){
                    index = i;
                } else if (i<index) {
                    index = i; 
                }
                    
            }
        }
        
        return index;
    }
}