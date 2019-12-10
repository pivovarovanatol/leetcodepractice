package com.leetcode.algors.Search2DMatrix;
// https://leetcode.com/problems/search-a-2d-matrix/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Let's use binary search. 
        // First, will locate the row by binary searching thru rows.
        // Second, will locate the value in the row by binary searhing within the row.
        
        int value = target;
        
        int height = matrix.length;
        if (height <=0){
            return false;
        }        
        
        int width = matrix[0].length;
        if (width <=0){
            return false;
        }        
        
        
        if (value < matrix[0][0]){
            return false;
        }

        if (value > matrix[height-1][width-1]){
            return false;
        }
        
        
        int row = searchRow(matrix, value, 0, height-1,width);
        //System.out.println("Row is: " + row);
        if (row == -1){
            return false;
        }
        
        int column = searchColumn(matrix, value, 0, width-1, row);
        //System.out.println("Column is: " + column);
        if (column == -1){
            return false;
        }
        
        return true;
        
    }
    
    int searchRow(int[][] matrix, int value, int start, int end, int width){
        //System.out.println("Searching starting at: " + start + " end: " + end);
        if (start > end){
            return -1;
         }
        
        //if (value >= matrix[start][0] && value <= matrix[start][width-1]) {
        //    return start;
        //};
        
        int medium = (start+end)/2;
        //System.out.println("Medium is: " + medium);
        
        if (value  < matrix[medium][0]){
            return searchRow(matrix, value, start, medium-1, width);
        } else if (value >  matrix[medium][width-1]) {
            return searchRow(matrix, value, medium+1, end, width);
        } else {
            return medium;
        }
    }
    
    int searchColumn(int[][] matrix, int value, int start, int end, int row){
        
        if (start > end) {
            return -1;
        }
        
        int medium = start + (end - start +1)/2;
        
        if (value < matrix[row][medium]){
            return searchColumn(matrix, value, start, medium-1, row);
        } else if (value > matrix[row][medium]){
            return searchColumn(matrix, value, medium+1, end, row);
        } else if (value == matrix[row][medium]){
            return medium;
        }
        
        return -1;
    }
    
    
}
