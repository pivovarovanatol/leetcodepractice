package com.leetcode.algors.CoinChange2;

import java.util.Arrays;

class Solution {
	
	// from textbook. 2 ms (<100%)
    public int change(int amount, int[] coins) {
        int arr[] = new int[amount+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for(int c : coins)
            for(int i = c; i <= amount; i++)
                arr[i] += arr[i-c];
        return arr[amount];
    }
	
	// from discussions
    public int change2(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return dfs(coins, 0, amount, dp);
    }
    int dfs(int[] coins, int i, int amount, Integer[][] dp) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) return 0;
        if (dp[i][amount] != null) return dp[i][amount];
        int ans = 0;
        ans += dfs(coins, i + 1, amount, dp); // skip ith coin
        ans += dfs(coins, i, amount - coins[i], dp); // use ith coin
        return dp[i][amount] = ans;
    }
    
//	  Doesn't work due to 1-2 and 2-1 are considered different ways, but has to be one
//    int dp(int[] coins, int amount, int index,  HashMap<Integer, Integer> count){
//    	int total=0;
//    	int[] dp = new int[5001];
//    	dp[0]=0;
//    	
//    	for (int i=1;i<=amount;i++) {
//    		for (int coin : coins) {
//    			if (i==coin) {
//    				dp[i]++;
//    			} 
//    			else if (i-coin > 0) {
//    				dp[i] +=dp[i-coin];
//    			} else {
//    				continue;
//    			}
//    			System.out.println("Amount="+i+" number of ways="+dp[i]);
//    		}
//    	}
//        
//        return dp[amount];
//    }


}