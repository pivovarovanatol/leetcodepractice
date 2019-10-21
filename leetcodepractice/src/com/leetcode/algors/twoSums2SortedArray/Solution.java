package com.leetcode.algors.twoSums2SortedArray;

import java.util.HashMap;

public class Solution {

	
    public int[] twoSum2(int[] nums, int target) {
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
            		result[0] = i+1;
            		result[1] = index+1;
            		return result;
        		}
        	}
        }
        
        return result;
    }
    

	
    public int[] twoSum(int[] nums, int target) {

    	int index1 = 0;
    	int index2 = nums.length-1;
    	
    	
    	while (true) {
    		int x = nums[index1] + nums[index2];
    		
    		if (x == target) {
    			break;
    		}
    		
    		if (x<target) {
    			index1++;
    		}
    		
    		if (x>target) {
    			index2--;
    		}
    		
    	}
    	
    	int[] result = new int[2];
    	result[0] = index1+1;
    	result[1] = index2+1;
        return result;
    }
    
	
}
