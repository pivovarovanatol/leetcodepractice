package com.leetcode.algors.PerfectSquares;
// https://leetcode.com/problems/perfect-squares/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	// from discussions: concise DP solution. 24ms(<57%) 41MB(<13%) 
	public int numSquares1(int n) {
		   int[] dp = new int[n + 1];
			int nearest;
			for (int i = 1; i <= n; i++) {
				nearest = (int) Math.sqrt(i);
				int min = dp[i - 1];
				for (int j = nearest; j > 0; j--) {
					if (dp[i - j * j] < min)
						min = dp[i - j * j];
				}
				dp[i] = min + 1;
			}

			return dp[n];
		}  
	
	
	// from discussions: solution with BFS. 10ms(<95%) 44MB(<13%). Need to understand.  
	public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n)
            return 1;

        for (int i = 1; i*i < n; i++) {
            dp[i*i] = 1;
            q.offer(i*i);
        }
        
        while (!q.isEmpty()) {
            int curr = q.peek();
            for (int i = 1; i*i <= n-curr; i++) {
                if (curr + i*i == n) {
                    return dp[curr] + 1;
                } 
                if (dp[curr + i*i] == 0) {
                    dp[curr + i*i] = dp[curr] + 1;
                    q.offer(curr + i*i);
                }
            }
            q.poll();
        }
        return 0;
}
	
	
    // solved with DP and recursion. 52ms(<26%) 48MB(<12.5%)
    public int numSquares2(int n) {
        // get the X = square root of n -> start for regression.
        // iterate from highest X to 1 and for every - get the diff between the n and quare of X and recurse. Calce number of steps.
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = dp(n, map);
        return num;        
    }
    
    int dp(int n, HashMap<Integer, Integer> map){
        //System.out.println("Called for :" + n);
        if (n==0){
            return 0;
        }
        
        if (n==1){
            return 1;
        }
        
        int x = (int) Math.sqrt(n);
        //int x = n/2;
        int count = Integer.MAX_VALUE;
        int lim = x/2;
        while (x>lim){
            int diff = n - x*x;
            if (diff < 0){
                x--;
                continue;
            }
            
            if (diff == 0){
                return 1;
            }
            
            if (diff == 1){
                return 2;
            }

            int tmp = 0;
            if (map.containsKey(diff)) {
                tmp = map.get(diff);
            } else {
                tmp = dp(diff, map);
                map.put(diff, tmp);
            }
            
            if (tmp < count){
                count = tmp;
            }
            x--;
        }
        
        return count + 1;
    }
    
}
