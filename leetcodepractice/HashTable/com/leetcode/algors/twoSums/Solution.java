package com.leetcode.algors.twoSums;

import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> numsHashes = new HashMap<Integer,Integer>();
        int n= nums.length;
        int result[] = {-1,-1};
        for (int i=0;i<n;i++){
            numsHashes.put(nums[i], i);
        }
    
        int diff = 0;
        for (int i=0;i<n;i++) {
        	diff = target - nums[i];
        	
        	if(numsHashes.containsKey(diff)) {
        		int index = numsHashes.get(diff);
        		if (index != i) {
            		result[0] = i;
            		result[1] = index;
            		return result;
        		}
        	}
        }
        
        return result;
    }
    
	
}
