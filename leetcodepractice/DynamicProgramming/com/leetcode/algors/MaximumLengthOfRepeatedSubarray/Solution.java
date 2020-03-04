package com.leetcode.algors.MaximumLengthOfRepeatedSubarray;
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

class Solution {
	// Solved with one array. 34ms(<90%)
    public int findLength(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dp[j] = a[i] == b[j] ? 1 + dp[j + 1] : 0);
        return max;        
    }	
	
	// solved with DP: matrix as for longest common substring. 39ms(<75%) 53.4MB(<55%)
    public int findLength1(int[] A, int[] B) {
        int n = A.length;
        int m= B.length;
        int[][] matrix = new int[n+1][m+1];
        int max = 0;
        
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if (A[i-1]==B[j-1]){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                    max = Math.max(max, matrix[i][j]);
                }
            }
        }
        
        return max;
    }
}

