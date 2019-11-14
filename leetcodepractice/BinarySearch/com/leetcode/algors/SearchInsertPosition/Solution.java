package com.leetcode.algors.SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
    	
        int n = nums.length;
        if (n==0) {return -1;}
        
        for (int i=0;i<n;i++) {
        	if (nums[i]>=target) {
        		return i;
        	}
        }
        
    	return n;
    }
}