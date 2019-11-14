package com.leetcode.algors.ToLowerCase;
// https://leetcode.com/problems/to-lower-case/

class Solution {
    public String toLowerCase(String str) {
     
        char[] arr = str.toCharArray();
        //int n = str.length();
        
        for (int i=0;i<arr.length;i++){
            if (arr[i] > 'z'){
                continue;
            }
            if (arr[i] < 'A'){
                continue;
            }

            arr[i] = arr[i] <= 'Z' ? (char) (arr[i]+32) : arr[i];
        }
        //String s = new String(arr);
        return (new String(arr));
        
    }
}