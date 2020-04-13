package com.leetcode.contests.weekly184.problem1;
//https://leetcode.com/contest/weekly-contest-184/problems/string-matching-in-an-array/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i=0;i<words.length;i++){
            String word = words[i];
            
            for (int j=0; j<words.length;j++){
                if (i!=j){
                    //System.out.println("Checking string "+ word + " against " + words[j]);
                    boolean b = Pattern.matches(".*"+word+".*", words[j]);
                    if (b) {
                        result.add(word);
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}