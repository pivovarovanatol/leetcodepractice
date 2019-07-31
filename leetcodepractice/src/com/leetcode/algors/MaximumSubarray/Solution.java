package com.leetcode.algors.MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
    	int s=0, ans = Integer.MIN_VALUE;
    	int n= nums.length;
    	for (int i=0;i<n;i++) {
    		s += nums[i];
    		ans = Math.max(ans, s);
    		s = Math.max (s, 0);
    	}
    	return ans;
    }
}