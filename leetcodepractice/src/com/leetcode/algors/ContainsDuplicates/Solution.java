package com.leetcode.algors.ContainsDuplicates;
// https://leetcode.com/problems/contains-duplicate/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if ((n) == 0 ){
            return false;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        
        for (int i=1;i<n;i++){
            if (nums[i] == prev) {
                return true;
            }
            prev = nums[i];
        }
            
        return false;
    }
	
	
    public boolean containsDuplicate2(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        
        return false;
    }
}

