package com.leetcode.algors.BestTimeToBuyAndSellStock2;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
    public int maxProfit(int[] prices) {
        
    	int buyPrice=-1;
    	int sellPrice = -1;
    	int result = 0;
    	
    	
    	for (int i=0;i<prices.length;i++) {

    		if (buyPrice <0) {
    			buyPrice=prices[i];
    			sellPrice=prices[i];
    		} else if (prices[i] > sellPrice) {
    			sellPrice = prices[i];
    		} else  if (prices[i] < sellPrice) {
    			result += (sellPrice - buyPrice);
    			sellPrice=prices[i];
    			buyPrice=prices[i];
    		} else if (prices[i] < buyPrice) {
    			buyPrice = prices[i];
    		}
    	}
    		
    	return result + (sellPrice-buyPrice);
    }
}