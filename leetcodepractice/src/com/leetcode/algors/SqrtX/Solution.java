package com.leetcode.algors.SqrtX;
//https://leetcode.com/problems/sqrtx/

class Solution {
    public int mySqrt(int x) {
        
    	int multi = 0;
    	
    	for (int i=0;i<=x;i++) {
    		multi = i * i;
    		
    		if (multi == x) {
    			return i;
    		}
    		
    		if (multi > x) {
    			return i-1;
    		}
    	}
    	
    	return 0;
    }
}