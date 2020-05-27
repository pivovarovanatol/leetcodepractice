package com.leetcode.algors.CountSquareSubmatriceswithAllOnes;
// https://leetcode.com/problems/count-square-submatrices-with-all-ones/ 


class Solution {
	
    public int countSquares(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }
	
    public int countSquares1(int[][] matrix) {
        // brute force
        if (matrix==null || matrix.length==0) {
            throw new IllegalArgumentException("Input matrix shouldn't be null or empty!");
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];        
        
//        for (int[] a : matrix) {
//        	for (int e : a) {
//        		System.out.print(e + " ");;
//        	}
//        	System.out.println();
//        }

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (!visited[i][j] && matrix[i][j]==1){
                    int level = 1;
                    
                    while (isValid(i,j+level,n,m,visited) && matrix[i][j+level]==1) {
                    	level++;
                    }
                    
                    for (int k = i+1;k<i+level;k++)
                        for (int l = j;l<j+level;l++) {
                        	if (isValid(k,l,n,m,visited))
                        		if (matrix[k][l]!=1) {
	                        		level = Math.min(k-i+1, l-j+1);
	                        		level = level == 0 ? 1 : level;
	                        		break;
                        	} 
                        }
                    if (i+level > n) level = n-i;
                    
                    System.out.println("For r=" + i + " and c=" + j + " min level=" + level);
                    
                    int t = level;
                    for (int k = i;k<i+level;k++)
                        for (int l = j;l<j+level;l++)
                        	visited[k][l]=true;
                        	
                    while (t > 0){
                    int add =  (level-t+1)*(level-t+1);
                        //System.out.println("Adding subsquares with side " + t + "=" + add);
                        count += add;
                        t--;
                    }
                }
            }
        }        
        
        
//        for (int i=0;i<n;i++){
//            for (int j=0;j<m;j++){
//                if (!visited[i][j] && matrix[i][j]==1){
//                    int level = getLevel(matrix, i, j, visited);
//                    int t = level;
//                    for (int k = i;k<i+level;k++)
//                        for (int l = j;l<j+level;l++)
//                        	visited[k][l]=true;
//                        	
//                    while (t > 0){
//                    int add =  (level-t+1)*(level-t+1);
//                        //System.out.println("Adding subsquares with side " + t + "=" + add);
//                        count += add;
//                        t--;
//                    }
//                    //System.out.println("For r=" + i + " and c=" + j + " min level=" + level);
//                    //System.out.println("For r=" + i + " and c=" + j + " total count=" + count);
//                }
//            }
//        }
        
        return count;
    }
    
    int getLevel(int[][] matrix, int r, int c, boolean[][] visited){
        if (r >= matrix.length || c >= matrix[0].length) return 0;
        if (visited[r][c]) return 0;
        visited[r][c] = true;
        
        //System.out.println("Entering recurse: " + r + " | " + c);
        
        if (matrix[r][c]!=1) return 0;
        
        int minLevel = Integer.MAX_VALUE;
        int n= matrix.length;
        int m= matrix[0].length;
        
        if (isValid(r,c+1,n,m,visited)) {
            int right = getLevel(matrix, r, c+1, visited);
            if (right==0) return 1;
            minLevel = Math.min(minLevel, right);    
        }

        if (isValid(r+1,c,n,m,visited)) {
            int down = getLevel(matrix, r+1, c, visited);
            if (down==0) return 1;
            minLevel = Math.min(minLevel, down);    
        }

        if (isValid(r+1,c+1,n,m,visited)) {
            int diagonal = getLevel(matrix, r+1, c+1, visited);
            if (diagonal==0) return 0;
            minLevel = Math.min(minLevel, diagonal);    
        }

        if (minLevel == Integer.MAX_VALUE) return 1;
        
        return minLevel + 1;
    }
    
    boolean isValid(int r, int c, int n, int m, boolean[][] visited){
        if (r>=n || c>=m || visited[r][c]) return false;
        else return true;
    }
    
}


/*

1 1 0 1 1
1 1 1 1 1
1 0 1 0 1 
1 1 0 1 1
1 1 1 1 1

1 2 0 1 2
1 2 3 4 5
1 0 1 0 1
1 2 0 1 2
1 2 3 4 5

*/