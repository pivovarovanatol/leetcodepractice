package com.leetcode.algors.ValidSudoku;

//import java.util.HashMap;

class Solution {
    // Some improvements: 1 loop for rows and columns. Using integer array instead of HashMap. 2ms(<91%) 43MB(<97%)
    public boolean isValidSudoku(char[][] board) {
        
        // Traverse thru rows and check if valid
        boolean rowValid = false;
        boolean columnValid = false;
        for (int i = 0;i<9;i++){
            rowValid = isRowValid(board, i);
            if (!rowValid) return false;
            
            columnValid = isColumnValid(board, i);
            if (!columnValid) return false;
        }
        
        // Traverse thru boxes and check if valid
        boolean boxValid = false;
        
        for (int i=0;i<9;i=i+3){
            for (int j=0;j<9;j=j+3){
                boxValid = isBoxValid(board, i, j);
                if (!boxValid) return false;
            }
        }
        
        return true;
    }
    
    // brute force solution with HashMaps. Solved in 3ms(<71%) 44MB(<75%)
    public boolean isValidSudoku1(char[][] board) {
        
        // Traverse thru rows and check if valid
        boolean rowValid = false;
        for (int i = 0;i<9;i++){
            rowValid = isRowValid(board, i);
            if (!rowValid) return false;
        }
        
        
        // Traverse thru columns and check if valid
        boolean columnValid = false;
        for (int i = 0;i<9;i++){
            columnValid = isColumnValid(board, i);
            if (!columnValid) return false;
        }
        
        // Traverse thru boxes and check if valid
        boolean boxValid = false;
        
        for (int i=0;i<9;i=i+3){
            for (int j=0;j<9;j=j+3){
                boxValid = isBoxValid(board, i, j);
                if (!boxValid) return false;
            }
        }
        
        return true;
    }
    
    boolean isRowValid(char[][] board, int row){
        //HashMap<Character, Integer> map = new HashMap<>();
        int[] exists = new int[9];

        for (int i=0;i<9;i++){
            if (board[row][i] == '.') continue;
            //if (map.containsKey(board[row][i])){
            if (exists[board[row][i]-'1']>0){
                //System.out.println("Row is invalid at " + row + " "+ i);
                return false;
            } else {
            	exists[board[row][i]-'1']=1;
            }
        }
        return true;
    }
    
    boolean isColumnValid(char[][] board, int column){
        //HashMap<Character, Integer> map = new HashMap<>();
        int[] exists = new int[9];
        
        for (int i=0;i<9;i++){
            if (board[i][column] == '.') continue;
            if (exists[board[i][column]-'1']>0){
                //System.out.println("Column is invalid at " + column + " "+ i);
                return false;
            } else {
                exists[board[i][column]-'1'] = 1;
            }
        }
        return true;
    }
    
    boolean isBoxValid(char[][] board, int startRow, int startColumn){
        //HashMap<Character, Integer> map = new HashMap<>();
        int[] exists = new int[9];
        
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (board[startRow+i][startColumn+j] == '.') continue;
                if (exists[board[startRow+i][startColumn+j]-'1'] > 0){
                    //System.out.println("Box is invalid at " + (startRow+i) + " " + (startColumn+j) + " | " + board[startRow+i][startColumn+j]);
                    return false;
                } else {
                    exists[board[startRow+i][startColumn+j]-'1'] = 1;
                }
            }
        }
        return true;
    }
    
}

