package com.leetcode.algors.ClimbStairs;

import java.util.HashMap;

// https://leetcode.com/problems/climbing-stairs/

class Solution {
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        int steps = climbStairsRec(n);
        return steps;
    }

    public int climbStairsRec(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if (hm.containsKey(n)) {
        	return hm.get(n);
        } else {
        	int tmp = climbStairsRec(n-1) + climbStairsRec(n-2);
        	hm.put(n, tmp);
            return tmp;
        }
    }
    
    
    public int climbStairs2(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int n2 = 1, n1 = 2, all = 0;
        
        for(int i = 2; i < n; i++){
            all = n2 + n1;
            n2 = n1;
            n1 = all;
        }
        return all;
    }

}