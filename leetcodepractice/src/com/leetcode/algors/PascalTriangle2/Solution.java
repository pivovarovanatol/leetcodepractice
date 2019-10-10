package com.leetcode.algors.PascalTriangle2;
// https://leetcode.com/problems/path-sum/submissions/

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
    	
        int[][] arr = new int[rowIndex+1][rowIndex+1];
        
        arr[0][0]=1;
        
        for (int i=1;i<=rowIndex;i++) {
        	arr[i][0]=1;
        	for (int j=1;j<=rowIndex;j++) {
        		arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
        	}
        }
    	
        for (int i=0;i<=rowIndex;i++) {
        	result.add(arr[rowIndex][i]);
        }
        
    	return result;
    }
    
}