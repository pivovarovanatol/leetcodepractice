package com.leetcode.algors.IslandPerimeter;
// https://leetcode.com/problems/island-perimeter/

class Solution {
	
	// from discussions. Idea is to count the number of 1s and multiply to 4 (number of borders) then subtract number of borders shared with other 1s (neighbors) multiplied by 2. 6ms(<97%) 
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int R = grid.length, C = grid[0].length;
        int cellCount = 0, neighborCount = 0;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 1) {
                    cellCount++;
                    // right, down
                    if (c < C-1 && grid[r][c+1] == 1) neighborCount++;
                    if (r < R-1 && grid[r+1][c] == 1) neighborCount++;
                }
            }
        }
        return cellCount * 4 - neighborCount * 2;
    }

	
	// solved iteratively by traversing the matrix. 8ms(<8%) 71MB(<6%)
    public int islandPerimeter2(int[][] grid) {
        // naive solution - traverse thru the matrix and check every cell if it's a 1. If yes - check boundaries and count perimmeter accordingly.
        int per = 0;
        int height = grid.length;
        if (height==0){
            return 0;
        }
        
        int width = grid[0].length;
        if (width==0){
            return 0;
        }
        
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if (grid[i][j]==1){
                    // border or water to the left
                    if (j==0 || grid[i][j-1]==0) per++;
                    // border or water to the right
                    if (j==width-1 || grid[i][j+1]==0) per++;
                    // border or water to the top
                    if (i==0 || grid[i-1][j]==0) per++;
                    // border or water to the down
                    if (i==height-1 || grid[i+1][j]==0) per++;
                }
            }
        }
        
        return per;
    }
}

