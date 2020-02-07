package com.leetcode.algors.LetterCombinationsOfPhoneNumber;
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;


class Solution {
	// solved with recursion and char[]. 0ms(<100%) 38.6MB(<6%)
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits==null || digits.length()==0) return result;
        
        char[] nums = digits.toCharArray();
        char[] res = new char[nums.length];
        getCombinations(nums, 0, result, res);
        
        return result;
    }
    
    void getCombinations(char[] nums, int index, List<String> result, char[] sb){
        if (index==nums.length){
            String str = new String(sb);
            result.add(str);
            return;
        }
        
        int n = nums[index]-'0';
        char[] letters = mapToChars(n);
        
        for (char ch : letters){
            sb[index]=ch;
            getCombinations(nums, index+1, result, sb);
        }
        return;
    }
    
    char[] mapToChars(int n){
        char[] arr1={};
        char[] arr2={'a','b','c'};
        char[] arr3={'d','e','f'};
        char[] arr4={'g','h','i'};
        char[] arr5={'j','k','l'};
        char[] arr6={'m','n','o'};
        char[] arr7={'p','q','r','s'};
        char[] arr8={'t','u','v'};
        char[] arr9={'w','x','y','z'};
        
        if (n==1){ return arr1;}
        if (n==2){ return arr2;}
        if (n==3){ return arr3;}
        if (n==4){ return arr4;}
        if (n==5){ return arr5;}
        if (n==6){ return arr6;}
        if (n==7){ return arr7;}
        if (n==8){ return arr8;}
        if (n==9){ return arr9;}
        return arr1;
    }
    
}