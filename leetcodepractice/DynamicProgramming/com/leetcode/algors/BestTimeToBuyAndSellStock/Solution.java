package com.leetcode.algors.BestTimeToBuyAndSellStock;
// https://leetcode.com/problems/path-sum/submissions/

class Solution {
    public int maxProfit(int[] prices) {
        
    	int localMax=0;
    	int localMin = Integer.MAX_VALUE;
    	int result = 0;
    	
    	for (int i=prices.length-1;i>0;i--) {
    		if (prices[i]>localMax) {
    			localMax=prices[i];
    			localMin = Integer.MAX_VALUE;
    		}
    		
    		if (prices[i-1] < localMin  && localMax > 0) {
    			localMin = prices[i-1];
    			
    			if (localMax - localMin > result) {
        			result = localMax - localMin;
    			}
    		}
    		
    	}
    	return (result > 0 ? result : 0);
    }
}