package com.leetcode.algors.MinimumSizeSubarraySum;
// https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
	
	// trying to solve with the sliding window
    public int minSubArrayLen(int s, int[] A) {
        int i = 0, n = A.length, res = n + 1;
        for (int j = 0; j < n; ++j) {
            s -= A[j];
            while (s <= 0) {
                res = Math.min(res, j - i + 1);
                s += A[i++];
            }
        }
        return res % (n + 1);
    }	

	
	
	
    public int minSubArrayLen1(int s, int[] nums) {
        // brute force - compare sum for sub array and get the minimum length. 122ms (<6%)
        int n = nums.length;
        // pre-compute the sums - rolling sum from the first element
        int[] sums = new int[n+1];
        sums[0]=0;
        for (int i=1;i<=n;i++){
            sums[i] = nums[i-1]+sums[i-1];
        }
        
        // do two pointers to get the sum > s. Since nums has positive integers, then the first array reaching the sum would be the shortest, so no need to move left boundary.
        int right = 1;
        int left = 0;
        int len = Integer.MAX_VALUE;
        while (right <= n ){
            int sum = sums[right] - sums[left];
            if (sum >= s){
                len = Math.min(right - left, len);
                left++;
                right=left;
            } else {
                right++;
            }
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}

