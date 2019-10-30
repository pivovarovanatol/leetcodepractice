package com.leetcode.algors.LongestStringNoRepeatChars;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
	
class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] string = s.toCharArray();
        int len = string.length;
        int max = 0;
        
        if (len ==0 || len == 1 ){
            return len;
        }

        for (int i=0;i<len-1;i++){
            int[] chars = new int[126];
            int count = 1;
            chars[string[i]-1]++;
            
            for (int j=i+1;j<len;j++) {
                if (chars[string[j]-1] > 0) {
                    break;
                } else {
                    chars[string[j]-1]++;
                    count++;
                }
            }
            
            if (count>max){
                max = count;
            }
            
        }
        
        return max;
    }
}
