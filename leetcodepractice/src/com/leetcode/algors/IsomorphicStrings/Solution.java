package com.leetcode.algors.IsomorphicStrings;
//https://leetcode.com/problems/isomorphic-strings/

import java.util.ArrayList;
import java.util.LinkedHashMap;

class Solution {
	
    public boolean isIsomorphic(String s1, String s2) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        LinkedHashMap firstStrig = new LinkedHashMap();
        LinkedHashMap secondString = new LinkedHashMap();

        if(sc1.length == sc2.length){
            for(int i=0; i<sc1.length; i++){
                firstStrig.put(sc1[i], i);
                secondString.put(sc2[i], i);
            }
        
            if(new ArrayList<>( firstStrig.values() ).equals(new ArrayList<>( secondString.values() ))){
                return true;
            }
        }
        return false;
    }
	
	
    public boolean isIsomorphic2(String s, String t) {
        
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