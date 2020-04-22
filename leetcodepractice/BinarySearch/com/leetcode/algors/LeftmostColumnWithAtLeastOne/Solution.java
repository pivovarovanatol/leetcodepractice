package com.leetcode.algors.LeftmostColumnWithAtLeastOne;
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/

import java.util.Arrays;
import java.util.List;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
	// Do a binary search per row. Maximum 100 rows, therefore maximum 100 * log(100) = 100 * ~7.
	// Use array for DP to minimize requests. Solved and Accepted. 
	
	int[] dp;
    public int leftMostColumnWithOne(BinaryMatrix bm) {
        List<Integer> dimensions = bm.dimensions();
        int height = dimensions.get(0);
        int width = dimensions.get(1);
        
        //System.out.println("Matrix dimensions: " + height + " X " + width);
        //if (height>0) return -1;
        int min = Integer.MAX_VALUE;
        dp = new int[(height+1)*100];
        Arrays.fill(dp, -1);
        
        for (int i=0;i<height;i++) {
        	//System.out.println("Checking element at row: " + i);
        	int tmp = get(bm, i, width-1);
        	if (tmp==0) {
            	//System.out.println("Found 0 at last element -> skipping row ");
        		continue;
        	};

        	// checking first -> if 1 -> min =0;
        	tmp = get(bm, i, 0);
        	//System.out.println("Found" + tmp + " at first element");
        	if (tmp==1) {
            	//System.out.println("Found" + tmp + " at first element -> return 0");
        		return 0;
        	};
        	int left = bs(bm, i, 0, width-1, -1);
        	if (left < min) min = left;
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    // look for the first zero
    int bs(BinaryMatrix bm, int r, int start, int end, int prevVal) {
    	if (start >= end) {
    		int val = get(bm, r, start);
    		return val == 1 ? start : start+1;
    	}
    	int mid = (start+end)/2;
    	int val = get(bm, r, mid);
    	// if prevVal==-1 -> first execution, need to re-run with current value
    	if (prevVal == -1) return bs(bm, r, start, end, val);
    	
    	// if val == 1 -> moving to the left
    	if (val == 1) {
    		return bs(bm, r, start, mid-1, val);
    	} else {
    		return bs(bm, r, mid+1, end, val);
    	}
    	
    }
    
    int get(BinaryMatrix bm, int r, int c) {
    	if (dp[r*100 + c] > -1) {
    		return dp[r*100 + c];
    	} else {
    		int tmp = bm.get(r,c);
    		dp[r*100 + c] = tmp;
    		return tmp;
    	}
    }
    
}