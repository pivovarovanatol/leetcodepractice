package com.leetcode.algors.SingleNumber;

import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        
    	int n = nums.length;
    	// traverse thru array and add it to a hashmap
    	
    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	
    	for (int i=0;i<n;i++) {
    		if (hm.containsKey(nums[i])) {
    			int tmp = hm.get(nums[i]);
    			hm.put(nums[i], tmp + 1);
    		} else {
        		hm.put(nums[i], 1);
    		}
    	}

    	for(int i=0;i<n;i++) {
    		if (hm.get(nums[i]) == 1) {
    			return nums[i];
    		}
    	}
    	
    	return 0;
    }
    
}