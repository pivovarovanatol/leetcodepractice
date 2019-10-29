package com.leetcode.algors.RotateArray;

class Solution {
    public void rotate(int[] nums, int k) {
        
        int len = nums.length;
        int[] modifiedArray = new int[len];

        for (int j=0;j<k;j++){
            int tmp = nums[len-1];
            for (int i=len-1;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0]=tmp;
        }
        
    }
}