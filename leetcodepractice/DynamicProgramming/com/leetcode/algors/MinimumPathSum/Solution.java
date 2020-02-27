package com.leetcode.algors.MinimumPathSum;
// https://leetcode.com/problems/minimum-path-sum/

class Solution {
	// solved with DP. 2ms(<89%) 
    public int minPathSum2(int[][] grid) {
        // go over the matrix and for each cell calculate the best incoming path
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i==0 && j==0){
                    continue;
                } else {
                int top = i == 0 ? Integer.MAX_VALUE : grid[i-1][j];
                int left = j == 0 ? Integer.MAX_VALUE : grid[i][j-1];
                grid[i][j] += Math.min(top, left);
                }
            }
        }
        return grid[n-1][m-1];        
    }
    
    // from discussions: solution with DFS. 1ms(<99%) 
    int visited[][];
    public int minPathSum(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0);
    }
    
    public int dfs(int[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;
        if(i == grid.length-1 && j == grid[0].length-1)
            return grid[i][j];
        if(visited[i][j] != 0)
            return visited[i][j];
        int a = dfs(grid, i+1, j);
        int b = dfs(grid, i, j+1);
        visited[i][j] = grid[i][j] + Math.min(a, b);
        return visited[i][j];
    }
    
    
}