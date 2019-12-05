package com.leetcode.algors.MaximalSquare;
// https://leetcode.com/problems/maximal-square/

class Solution {

	// Solved in 3ms (<99.64%) 42.9MB(<100%) 
    public int maximalSquare(char[][] matrix) {
        
        int height = matrix.length;
        if (height == 0){
            return 0;
        }
        int width = matrix[0].length;
        
        int maxSize = 0;
        //boolean[][] visited = new boolean[height][width];
        int[][] sizes = new int[height][width];
        
        for (int i=0;i<=height;i++){
            for (int j=0;j<=width-maxSize;j++){
                int currSize = getMaxSize(matrix, i, j, sizes, height, width);
                if (currSize > maxSize){
                    maxSize = currSize;
                }
            }
        }        
        //System.out.println("Matrix is");
        //printMatrix(matrix);
        //System.out.println("Sizes are");
        //printMatrix(sizes);
        
        return maxSize*maxSize;
    }
    
	int getMaxSize(char[][] matrix, int i, int j, int[][] sizes, int height, int width){

        // If out of bounds - return 0
        if (i >= height || j >= width){
            return 0;
        }
        //System.out.println("Checking " + i + " " + j + " value=" + matrix[i][j]);
        
        // If 0 - then exit recursion and return 0
        if (matrix[i][j] == '0'){
            return 0;
        }
        
        if (sizes[i][j] !=0) {
        	return sizes[i][j];
        }
        
        if (i < matrix.length - 1 && j < matrix[0].length-1){
            if (matrix[i+1][j] == '0' || matrix[i][j+1] == '0' || matrix[i+1][j+1] == '0') {
                sizes[i][j] = 1;
            	return 1; 
            }
        }


        // Else - check if neighbors to the right, down and diagonal are 1s
        int sizeRight = getMaxSize(matrix, i, j+1, sizes, height, width);
        if (sizeRight == 0) {
            sizes[i][j] = 1;
        	return 1;
        }
        
        int sizeDown = getMaxSize(matrix, i+1, j, sizes, height, width);
        if (sizeDown == 0) {
            sizes[i][j] = 1;
        	return 1;
        }

        int sizeDiagonal = getMaxSize(matrix, i+1, j+1, sizes, height, width);
        if (sizeDiagonal == 0) {
            sizes[i][j] = 1;
        	return 1;
        }
        
        int retValue = sizeRight < sizeDown ? sizeRight : sizeDown;
        retValue = retValue < sizeDiagonal ? retValue : sizeDiagonal;
        
        retValue += 1;
        
        sizes[i][j] = retValue;
        
        return retValue;
    }
	
	
    void printMatrix(int[][] arr) {
    	
		System.out.println("==================================================================================================================");
    	for (int i=0;i<arr[0].length;i++) {
    		System.out.print(i + " ");
    	}
    	System.out.println();
		System.out.println("==================================================================================================================");
    	
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(i + "|");
        	for (int j=0;j<arr[0].length;j++) {
        		System.out.print(arr[i][j] + " ");
        	}
    		System.out.println();
    	}
		System.out.println("==================================================================================================================");
    }
    
    void printMatrix(char[][] arr) {
    	
		System.out.println("==================================================================================================================");
		System.out.println("==================================================================================================================");
    	for (int i=0;i<arr[0].length;i++) {
    		System.out.print(i + " ");
    	}
    	System.out.println();
		System.out.println("==================================================================================================================");
    	
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(i + "|");
        	for (int j=0;j<arr[0].length;j++) {
        		System.out.print(arr[i][j] + " ");
        	}
    		System.out.println();
    	}
		System.out.println("==================================================================================================================");
    }
    
}

