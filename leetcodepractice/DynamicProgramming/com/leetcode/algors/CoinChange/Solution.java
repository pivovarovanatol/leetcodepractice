package com.leetcode.algors.CoinChange;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    LinkedList<Integer> list = new LinkedList<>();
    int initialAmount=0;
    
    public int coinChange(int[] coins, int amount) {
        initialAmount=amount;
        Arrays.sort(coins);
        if (coins.length == 0) return 0;
        if (amount < 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int result = dp1(coins, coins.length-1, amount, 0, map);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public int dp1(int[] coins, int index, int amount, int count, HashMap<Integer, Integer> map) {
    	//System.out.println(amount); 
    	if (amount == 0) return count;
    	if (index < 0) return Integer.MAX_VALUE;
    	//if (map.containsKey(amount)) return map.get(amount);

    	int min = Integer.MAX_VALUE;
    	int mult = amount / coins[index];
    	int i = 0;
    	while (i <= mult) {
    		int newAmount = amount - coins[index]*i;
    		int tmp = Integer.MAX_VALUE;
    		if (newAmount==0) min = Math.min(min, count + i);
    		if (newAmount >= 0) {
    			tmp = dp1(coins, index-1, newAmount, count+i, map);
    			min = Math.min(min, tmp);
    		} 
    		//mult--;
    		i++;
    	}
    	map.put(amount, min);
    	return min;
    }
    
}
