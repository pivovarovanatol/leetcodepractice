package com.leetcode.contests.weekly182.problem1;


class Solution {
    public int findLucky(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int[] nums = new int[500];
        
        for (int i=0;i<arr.length;i++){
            nums[arr[i]]++;
        }
        
        for (int i=499;i>=0;i--){
            if (nums[i]==i && nums[i]>0) return i;
        }
        
        return -1;
    }
}