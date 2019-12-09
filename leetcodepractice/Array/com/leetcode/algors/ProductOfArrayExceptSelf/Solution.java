package com.leetcode.algors.ProductOfArrayExceptSelf;
// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
	 
	// From discussions. 1ms(<100%) 42.6MB(<96%) 
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) { // bad input
            return null;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}