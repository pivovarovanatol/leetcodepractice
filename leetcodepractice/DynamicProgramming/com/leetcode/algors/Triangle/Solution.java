package com.leetcode.algors.Triangle;
// https://leetcode.com/problems/triangle/

import java.util.HashMap;
import java.util.List;

class Solution {
	
	// From discussions: DP Bottom-up. 2ms (<85%) 36.6MB(<96%)
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n - 1).get(i);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            int len = triangle.get(i).size();
            for (int j = 0; j < len; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
	
	// Solved recursively with DFS and HashMap for DP. 8ms (<6%) 40MB(<10%)
    public int minimumTotal1(List<List<Integer>> triangle) {
        // Looks like a tree -> DFS?
        // Lets try create a matrix and do DFS
        if (triangle.size() == 0){
            return 0;
        }
        // get the longest list to get the matrix size
        int n = 0;
        for (List<Integer> l : triangle){
            if (l.size() > n){
                n = l.size();
            }
        }
        
        // create and fill the matrix
        int[][] matrix = new int[triangle.size()][n];
        
        int i=0;
        for (List<Integer> l : triangle){
        int j=0;
            for (int k : l){
                matrix[i][j] = k;
                j++;
            }
        i++;
        }
        
        // DFS to get the shortest length + DP for intermediate results
        int path = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        
        int result = dfs(matrix, 0, 0, triangle.size(), n, map);
        return result;
        
    }
    
    int dfs(int[][] matrix, int i, int j, int height, int width, HashMap<String, Integer> map){
        
        if (i >= height || j >= width){
            return 0;
        }
        
        String key = i + "|"+j;
        if (map.containsKey(key)){
            return map.get(key);
        }
        
        int left = dfs(matrix, i+1, j, height, width, map);
        int right = dfs(matrix, i+1, j+1, height, width, map);
        int ret = left < right ? left : right;
        int value = matrix[i][j] + ret;
        map.put(key, value);
        return value;
        
    }
    
}
