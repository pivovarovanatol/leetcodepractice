package com.leetcode.algors.SurroundedRegions;
// https://leetcode.com/problems/surrounded-regions/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	
	// solved with DFS. 1ms(<100%) 45MB(46%)
    public void solve(char[][] board) {
    	// go over boundaries and for every 'O' perform DFS keeping track of how far it spreads 
    	// mark that in the boolean matrix. After go and assign the O for corresponding cells in the original board, or put X, since it's not connected to boundaries Os.
    	
        int height = board.length;
        if (height==0) {
        	return;
        }
        int width = board[0].length;
        boolean[][] marked = new boolean[height][width];
        boolean[][] visited = new boolean[height][width];
        
        for (int i=0;i<height;i++) {
        	mark(board, visited, i, 0, height, width, marked);
        	mark(board, visited, i, width-1, height, width, marked);
        }
        
        for (int i=0;i<width;i++) {
        	mark(board, visited, 0, i, height, width, marked);
        	mark(board, visited, height-1, i, height, width, marked);
        }
        
        for (int i=1;i<height-1;i++){
            for (int j=1;j<width-1;j++){
                if (marked[i][j]){
                   	board[i][j]='O';
                } else {
                	board[i][j]='X';
                }
            }
        }

    }

	void mark(char[][] board, boolean[][] visited, int i, int j, int height, int width, boolean[][] marked) {
		if (i<0 || i>= height || j<0 || j >= width) {
			return;
		}
		if (visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		if (board[i][j]=='X') {
			return;
		} else {
			marked[i][j]=true;
			mark(board, visited, i-1, j, height, width, marked);
			mark(board, visited, i+1, j, height, width, marked);
			mark(board, visited, i, j-1, height, width, marked);
			mark(board, visited, i, j+1, height, width, marked);
		}
		
	}
	
	
	
    public void solve1(char[][] board) {
        // idea: traverse thru matrix keeping track of visited cells. Check only visited.
        // For every cell == O -> do DFS/BFS and check if children are surrounded by X. If yes - convert the current cell to X, otherwise keep O.
    	// need to utilize BFS
    	
    	// another idea: do BFS and check every child if it's equal O. If X - skip. If yes - Check if reached the border of the matrix, then return immediately with false - not surrounded region. 
    	// Otherwise - add unvisited nodes to the queue and repeat. 
    	// If queue is empty - return true (meaning region is surrounded). Then do second pass to convert to X.
    	
    	// another idea - create another board filled with X, then start from boundaries on first board 
    	// and copy O and connected Os to a new board?
    	
        int height = board.length;
        if (height==0) {
        	return;
        }
        int width = board[0].length;
        //boolean[][] visited = new boolean[height][width];
        // check: 0 - not checked. -1 - in the process. 1 - checked.

       // for (int i=0;i<height;i++) {
       // 	visited[0][i]=1;
       // 	visited[i][0]=1;
       // }
        
        for (int i=1;i<height-1;i++){
            for (int j=1;j<width-1;j++){
                if (board[i][j]=='O'){
                	boolean[][] visited = new boolean[height][width];
                    boolean surrounded = bfs(board, visited, i, j, height, width);
                    //clearMatrix(visited);
                    if (surrounded) {
                    	board[i][j]='X';
                    }
                }
            }
        }
    }
    
    // Store coordinates in the String as concatenate "X|Y"
    
    boolean bfs(char[][] board, boolean[][] visited, int i, int j, int height, int width){
    	if (visited[i][j]) {
    		return board[i][j]=='X';
    	}
    	
    	Deque<Integer> queueY = new ArrayDeque<>();
    	Deque<Integer> queueX = new ArrayDeque<>();
    	queueY.add(i);
    	queueX.add(j);
    	//visited[i][j]=1;
    	while(!queueY.isEmpty()) {
    		int x = queueX.remove();
    		int y = queueY.remove();
    		
    		if (board[y][x]=='X') {
    			continue;
    		}
    		
    		if (x<=0 || x>=width-1) {
    			return false;
    		}
    		if (y<=0 || y>=height-1) {
    			return false;
    		}
    		
    		visited[y][x]=true;
    		
    		if (!visited[y-1][x] && board[y-1][x]=='O') {
    	    	queueY.add(y-1);
    	    	queueX.add(x);    			
    		}
    		if (!visited[y+1][x] && board[y+1][x]=='O') {
    	    	queueY.add(y+1);
    	    	queueX.add(x);    			
    		}
    		
    		if (!visited[y][x-1] && board[y][x-1]=='O') {
    	    	queueY.add(y);
    	    	queueX.add(x-1);    			
    		}
    		
    		if (!visited[y][x+1] && board[y][x+1]=='O') {
    	    	queueY.add(y);
    	    	queueX.add(x+1);    			
    		}
    		
    	}
    	
    	return true;
    }

    void clearMatrix(boolean[][] matrix) {
    	for (int i=0;i<matrix.length;i++) {
    		for (int j=0;j<matrix[0].length;j++) {
    			matrix[i][j]=false;
    		}
    	}
    }
    
}

