package com.leetcode.algors.MinCostClimbingStairs;
// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    // from discussions with DP. 1ms(<99%) 38MB(<92%)
    public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < dp.length - 1; i++) {
			if (dp[i - 1] > dp[i - 2]) {
				dp[i] = dp[i - 2] + cost[i];
			} else {
				dp[i] = dp[i - 1] + cost[i];
			}
		}
		dp[cost.length] = dp[cost.length - 2];
		return dp[cost.length] > dp[dp.length - 2] ? dp[dp.length - 2] : dp[cost.length];
    }
	
	
    // solved with recursion and memoization of intermediate results.
    public int minCostClimbingStairs2(int[] cost) {
        int[] map = new int[1001];
        for (int i=0;i<1001;i++){
            map[i]=-1;
        }
        int first = getCost(cost, 0, map);
        int second = getCost(cost, 1, map);
        return Math.min(first, second);
        
    }
    
    public int getCost(int[] cost, int index, int[] map){
        if (map[index]>-1){
            return map[index];
        }
        if (index >= cost.length){
            map[index]=0;
            return 0;
        }
        int first = cost[index] + getCost(cost, index+1, map);
        
        if (index >= cost.length-1){
            map[index] = first;
            return first;
        }
        
        int second = cost[index] + getCost(cost, index+2, map);
        map[index] = Math.min(first, second);
        return Math.min(first, second);
        
    }
    
}