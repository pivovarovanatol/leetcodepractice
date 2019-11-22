package com.leetcode.algors.HouseRobber;
// https://leetcode.com/problems/house-robber/


class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0; 
        if(length == 1) return nums[0]; 
        if(length == 2) return Math.max(nums[0], nums[1]); 
        if( length ==3 ) return Math.max(nums[0] + nums[2] , nums[1]); 
 
        nums[2] = nums[0] + nums[2];
        int index = 3; 
        while(index< length){ 
            nums[index] = Math.max(nums[index-2], nums[index-3]) + nums[index];
            index++; 
        }
        return Math.max(nums[length-1], nums[length-2]);    
    }
}