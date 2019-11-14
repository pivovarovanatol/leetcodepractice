package com.leetcode.algors.ProjectionAreaOf3dShapes;

// https://leetcode.com/problems/projection-area-of-3d-shapes/


// solved in 1ms(<100%) 42.5MB(<57%)
class Solution {
    public int projectionArea(int[][] grid) {
        
        int n = grid.length;
        
        int sum = 0;
        int[] maxX = new int[n];
        int[] maxY = new int[n];
        
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] > 0) {
                    // For z axis area is just a count of elements
                    sum++;
    
                    // Keep track of max element for Y axis
                    if (grid[i][j] > maxY[j]){
                        maxY[j] = grid[i][j];
                    }

                    // Keep track of max element for X axis
                    if (grid[i][j] > maxX[i]){
                        maxX[i] = grid[i][j];
                    }   
                }
            }
        }
        
        // Sum up all max elements
        for (int i=0;i<n;i++){
            sum = sum + maxX[i] + maxY[i];
        }
        
        return sum;
        
    }
}