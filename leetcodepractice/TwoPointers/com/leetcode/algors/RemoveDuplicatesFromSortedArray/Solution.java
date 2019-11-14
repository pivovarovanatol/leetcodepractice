package com.leetcode.algors.RemoveDuplicatesFromSortedArray;


class Solution {
    public int removeDuplicates(int[] nums) {
    	int n = nums.length;
    	int index = 1;
    	
    	if (n==0) {
    		return 0;
    	} else {
    		
    		for (int i = 1; i<n; i++) {
    			if (nums[i]!=nums[i-1]) {
    				nums[index]=nums[i];
    				index++;
    			}
    		}
    		
    	}
    	return index;
    }
}