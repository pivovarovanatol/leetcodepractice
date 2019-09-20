package com.leetcode.algors.PascalTriangle;
// https://leetcode.com/problems/path-sum/submissions/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
	
    	List<List<Integer>> result = new ArrayList<>();

    	
    	if (numRows == 0) {
    		return result;
    	}
    		
    
    	int[][] arr = new int[numRows][numRows];
		List<Integer> tmp = new ArrayList<Integer>();   	
    	arr[0][0]=1;
    	tmp.add(arr[0][0]);
		result.add(tmp);
		
    	for (int i=1;i<numRows;i++) {
			List<Integer> tmp1 = new ArrayList<Integer>();
    		for (int j=0;j<i+1;j++) {
    			int top = arr[i-1][j];
    			int left = 0;
    			
    			if (j>0) {
    				left = arr[i-1][j-1];
    			}
    			
    			arr[i][j] = left + top;
    			tmp1.add(arr[i][j]);
    		}
    		
    		result.add(tmp1);
    	}
    	
    	
    	return result;
    }
}