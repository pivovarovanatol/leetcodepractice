package com.leetcode.algors.UniquePaths;
// https://leetcode.com/problems/unique-paths/

class Solution {
	// solved by analogy with Unique PathsII. 0ms(<100%) 36.6MB(<5%)
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0]=1;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
	              if (j > 0)
	                dp[j] += dp[j - 1];
            }
        }
        return dp[n-1];
    }
    
}
