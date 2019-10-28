package com.leetcode.algors.MajorityElement;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

// https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement2(int[] nums) {
        
    	int n = nums.length;
        int result = 0;

        SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for (int i=0;i<n;i++){
        	int key = nums[i];
        	int value = map.containsKey(key) ? map.get(key) + 1 : 1;
        	map.put(key, value);
        }
        
        int max = 0;
        for (int key : map.keySet()) {
        	int currValue = map.get(key);
        	if (currValue > max) {
        		max = currValue;
        		result = key;
        	} 
        }
        
        return result;
    }


    public int majorityElement(int[] nums) {
    	
    	Arrays.sort(nums);
    	
        if(nums == null || nums.length == 0) return 0;
        int preVal = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == preVal) count++;
            else {
                count--;
                if(count == 0) {
                    preVal = nums[i];
                    count = 1;
                }
            }
        }
        return preVal;
    }

}