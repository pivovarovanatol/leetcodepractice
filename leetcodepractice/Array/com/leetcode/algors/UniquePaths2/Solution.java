package com.leetcode.algors.UniquePaths2;
// https://leetcode.com/problems/unique-paths-ii/

import java.util.HashMap;

class Solution {
	// from discussions: 0ms(<100%) 37.5MB(<100%)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}
	   
	
	
    // solved with DFS and DP - 1ms(<26%) 38MB(<100%)
    public int uniquePathsWithObstaclesMy(int[][] obstacleGrid) {

        return uniquePathsWithObstacles1(obstacleGrid);
    }
    
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // trying to solve it with DFS on Graph and DP to store info on cells already investigated.

        if (obstacleGrid==null || obstacleGrid.length == 0 || obstacleGrid[0].length==0) return 0;
        //HashMap<String, Integer> map = new HashMap<>();

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[m*n];
        
        return dfs2(obstacleGrid, 0, 0, m, n, dp);
    }
    
    
    int dfs2(int[][] obstacleGrid, int r, int c, int m, int n, int[] dp){
        
        if (r>=m){return 0;}
        if (c>=n){return 0;}
        //System.out.println(m + " | " + n + "=" + r + "|"+c);
        if (dp[r*n+c]!=0) return dp[r*n+c];
        
        if (obstacleGrid[r][c]==1){ return 0;}
        if (r==m-1 && c==n-1){ return 1;}
        int right = dfs2(obstacleGrid, r, c+1, m, n, dp);
        int top = dfs2(obstacleGrid, r+1, c, m, n, dp);
        dp[r*n+c] = right + top;
        return right + top;
    }
    
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        // trying to solve it with DFS on Graph

        if (obstacleGrid==null || obstacleGrid.length == 0 || obstacleGrid[0].length==0) return 0;
        //HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        return dfs1(obstacleGrid, 0, 0, m, n, map);
    }
    
    
    int dfs1(int[][] obstacleGrid, int r, int c, int m, int n, HashMap<Integer, Integer> map){
        int key = r*n+c;
        if (map.containsKey(key)) return map.get(key);
        
        if (r>=m){return 0;}
        if (c>=n){return 0;}
        if (obstacleGrid[r][c]==1){ return 0;}
        if (r==m-1 && c==n-1){ return 1;}
        int right = dfs1(obstacleGrid, r, c+1, m, n, map);
        int top = dfs1(obstacleGrid, r+1, c, m, n, map);
        map.put(key, right + top);
        return right + top;
    }
    
    
   
}

