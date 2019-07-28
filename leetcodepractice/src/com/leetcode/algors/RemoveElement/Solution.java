package com.leetcode.algors.RemoveElement;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        
    	int index=0;
    	if (nums.length==0) {
    		return 0;
    		}
    	
    	for(int i=0;i<nums.length;i++) {
    		if (nums[i]==val) {
    			nums[i]=Integer.MAX_VALUE;
    			index++;
    		}
    	}
    	
    	Arrays.sort(nums);
    	
    	return nums.length - index;
    }
}