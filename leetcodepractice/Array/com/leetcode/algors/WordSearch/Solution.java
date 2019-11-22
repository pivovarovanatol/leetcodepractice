package com.leetcode.algors.WordSearch;
// https://leetcode.com/problems/word-search/

class Solution {
	// Solved with nested loops (log(MxN)) * DFS for each match (MxN?). 136ms(<8%) 51MB(<8%). Moving visited[][] out of nested loops increased perf to just 3 ms (<90%) and 38.6MB(<98%)  
    public boolean exist(char[][] board, String word) {
    
        char[] wordArray = word.toCharArray();
        int end = word.length();
        int width = board[0].length;
        int height = board.length;
        //System.out.println(word);
        //printMatrix(board);
        //System.out.println();
        
        if (end > width*height) {
        	//System.out.println("Too long...");
        	return false;
        }
        
        boolean[][] visited = new boolean[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                // word is found ? -> return, else -> next start
                if (board[i][j] == wordArray[0] && existHelper(board, wordArray, 0, end, j, i, width, height, visited)) {
                    return true;
                };
            }
        }        
        
        return false;
    }
    
    boolean existHelper(char[][] board, char[] wordArray, int currIndex, int end, int checkX, int checkY, int width, int height, boolean[][] visited) {


        //System.out.println("Checking at " + checkX + ":" + checkY + " if corresponds to index " + currIndex);
        if (checkX < 0 || checkX >= width || checkY<0 || checkY >= height){
        	//System.out.println("Out nof bounds ");
            return false;
        }

        if (visited[checkY][checkX] == true) {
        	//System.out.println("Already visited... ");
            return false;
        }
        
        visited[checkY][checkX] = true;
        if (board[checkY][checkX] == wordArray[currIndex]){
            if (currIndex == end-1){
                return true;
            }
            
            //System.out.println("Found char " + board[checkY][checkX] + " at " + checkX + ":" + checkY + " which corresponds to index " + currIndex);
            //System.out.println();
            boolean checkLeft = existHelper(board, wordArray, currIndex+1, end, checkX-1, checkY, width, height, visited);
            if (checkLeft) {
            	//System.out.println("Found the word!!!");
            	return checkLeft;
            }
            
            boolean checkRight = existHelper(board, wordArray, currIndex+1, end, checkX+1, checkY, width, height, visited);
            if (checkRight) {
            	//System.out.println("Found the word!!!");
            	return checkRight;
            }
            
            boolean checkUp = existHelper(board, wordArray, currIndex+1, end, checkX, checkY-1, width, height, visited);
            if (checkUp) {
            	//System.out.println("Found the word!!!");
            	return checkUp;
            }

            boolean checkDown = existHelper(board, wordArray, currIndex+1, end, checkX, checkY+1, width, height, visited);
            if (checkDown) {
            	//System.out.println("Found the word!!!");
            	return checkDown;
            }
            visited[checkY][checkX] = false;
            return false;
            
        } else {
        	visited[checkY][checkX] = false;
            return false;
        }
        
        
    }
    
    void printMatrix(char[][] board) {
    	
    	for (int i=0;i<board.length;i++) {
    		for (int j=0;j<board[0].length;j++) {
    			//System.out.print(board[i][j] + " ");
    		}
    		//System.out.println();
    	}
    }
    
}


