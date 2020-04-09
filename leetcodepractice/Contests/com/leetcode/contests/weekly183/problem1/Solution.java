package com.leetcode.contests.weekly183.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
    	Arrays.sort(nums);
    	int sum = 0;
    	for (int i=nums.length-1;i>=0;i--) {
    		sum += nums[i];
    	}
    	
    	List<Integer> result = new ArrayList<>();
    	int tmp = 0;
    	
    	for (int i=nums.length-1;i>=0;i--) {
    		tmp += nums[i];
    		result.add(nums[i]);
    		if (tmp > sum/2) break;
    	}
    	
    	return result;
    }
}