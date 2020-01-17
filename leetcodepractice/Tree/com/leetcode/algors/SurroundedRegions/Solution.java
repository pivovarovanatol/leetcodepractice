package com.leetcode.algors.SurroundedRegions;
// https://leetcode.com/problems/surrounded-regions/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void solve(char[][] board) {
        // idea: traverse thru matrix keeping track of visited cells. Check only visited.
        // For every cell == O -> do DFS/BFS and check if children are surrounded by X. If yes - convert the current cell to X, otherwise keep O.
    	// need to utilize BFS
    	
    	// another idea: do BFS and check every child if it's equal O. If X - skip. If yes - Check if reached the border of the matrix, then return immediately with false - not surrounded region. Otherwise - add unvisited nodes to the queue and repeat. 
    	// If queue is empty - return true (meaning region is surrounded). Then do second pass to convert to X.
    	
    	
        int height = board.length;
        int width = board[0].length;
        // check: 0 - not checked. -1 - in the process. 1 - checked.
        int[][] visited = new int[height][width];

       // for (int i=0;i<height;i++) {
       // 	visited[0][i]=1;
       // 	visited[i][0]=1;
       // }
        
        for (int i=1;i<height-1;i++){
            for (int j=1;j<width-1;j++){
                if (board[i][j]=='O'){
                    bfs(board, visited, i, j, height, width);
                }
            }
        }
    }
    
    // Store coordinates in the String as concatenate "X|Y"
    
    void bfs(char[][] board, int[][] visited, int i, int j, int height, int width){
    	
    	
    }

    
    
}

