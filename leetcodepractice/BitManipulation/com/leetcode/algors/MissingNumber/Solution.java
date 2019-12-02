package com.leetcode.algors.MissingNumber;
// https://leetcode.com/problems/missing-number/


class Solution {
    public int missingNumber(int[] nums) {
     
        int n = nums.length;
        boolean[] arr = new boolean[n+1];
        
        // if (n ==0 ){
        //     return -1;
        // }
        
        
        for (int i=0;i<n;i++){
            arr[nums[i]] = true;
        }
        
        for (int i=0;i<n+1;i++){
            if (arr[i] == false) {
                return i;
            };
        }
        
        return -1;
    }
}

