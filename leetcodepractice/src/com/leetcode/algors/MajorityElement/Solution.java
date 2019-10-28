package com.leetcode.algors.MajorityElement;

import java.util.SortedMap;
import java.util.TreeMap;

// https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        
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
}