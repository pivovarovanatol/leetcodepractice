package com.leetcode.algors.SetMismatch;
// https://leetcode.com/problems/set-mismatch/

import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        // Solution using array as cache and 2 traversals. 2ms(<98%)
        
        int[] result = new int[2];
        int n = nums.length;
        if (n==0) return result;
        boolean[] lookup = new boolean[10002];
        
        int max =-1;
        for (int i=0;i<n;i++){
            if (!lookup[nums[i]]){
                lookup[nums[i]]=true;
            } else {
                result[0]=nums[i];
            }
            if (nums[i]>max){
                max =nums[i];
            }
        }
        if (!lookup[1]){
            result[1]=1;
        } else {
            for (int i=0;i<n;i++){
                if (!lookup[nums[i]+1] && nums[i]!=max){
                    result[1]=nums[i]+1;
                    break;
                }
            }

            if (result[1]==0){
                result[1]=max+1;
            }
        }
        
        return result;
    }



    public int[] findErrorNums2(int[] nums) {
        // brute force to find missing and duplicate number -> sort and then traverse thru array and add them. 10ms(<45%)
        int[] result = new int[2];
        int n = nums.length;
        if (n==0) return result;
        int prev = 0;
        Arrays.sort(nums);
        for (int i=0;i<n;i++){
            if (nums[i]==prev){
                // found duplicate - add to result
                result[0]=nums[i];
            } else if (nums[i]-prev >1){
                // found missing - add to result
                result[1]=nums[i]-1;
            }
            prev = nums[i];
        }
        // Edge case when duplicate is last symbol. 
        if (result[1]==0 && result[0]>0){
            result[1]=n;
        }
        return result;
    }

}
