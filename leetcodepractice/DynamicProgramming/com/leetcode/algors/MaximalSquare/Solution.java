package com.leetcode.algors.MaximalSquare;
// https://leetcode.com/problems/maximal-square/


class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int height = matrix.length;
        
        if (height == 0){
            return 0;
        }

        int width = matrix[0].length;
        
        
        boolean[][] visited = new boolean[height][width];
        int maxSize = 0;
        
        for (int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                
                if (!visited[i][j]){
                    int size = getMaxSizeHelper(matrix, i, j, height, width, visited);
                    visited[i][j] = true;
                    if (size > maxSize){
                        maxSize=size;
                    };
                }
                
            }
        }
        
        
        return maxSize*maxSize;
    }
    
    
    int getMaxSizeHelper(char[][] matrix, int y, int x, int height, int width,  boolean[][] visited) {
        
        
        if (x < 0 || x >= width || y < 0 || y >= height){
            return 0;
        }
        
        //System.out.println("Checking element at " + y + " : " + x + " value: " + matrix[y][x]);

        if (visited[y][x]){
            return 0;
        }
        
        if (matrix[y][x] == '0'){
            //visited[y][x] = true;
            return 0;
        }
        
        
        //int right = getMaxSizeHelper(matrix, y, x+1, height, width, visited);
        //int down = getMaxSizeHelper(matrix, y+1, x, height, width, visited);
        //int diagonal = getMaxSizeHelper(matrix, y+1, x+1, height, width, visited);
        
        //System.out.println("Results for element at " + y + " : " + x + " value: " + matrix[y][x] + " right size: " + right + " down size: " + down);
        //int newSize = right < down ? right : down;
        //newSize = diagonal < newSize ? diagonal : newSize;
        
        return 1;// + newSize;
    }
    
}


