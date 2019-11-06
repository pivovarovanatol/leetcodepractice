package com.leetcode.algors.IsomorphicStrings;
//https://leetcode.com/problems/isomorphic-strings/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int len = s.length();
        
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        
        char prev1 = 0;
        char prev2 = 0;
        
        int index1 = -1;
        int index2 = -1;
        
        for (int i=0;i<len;i++){
            if (chars1[i]==prev1){
                arr1[index1]++;
            } else {
                prev1 = chars1[i];
                index1++;
                arr1[index1]++;
            }

            if (chars2[i]==prev2){
                arr2[index2]++;
            } else {
                prev2 = chars2[i];
                index2++;
                arr2[index2]++;
            }

        }
        
        for (int i=0;i<len;i++){
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        
        return true;
    }
}