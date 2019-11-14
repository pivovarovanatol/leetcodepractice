package com.leetcode.algors.FactorialTrailingZeroes;

class Solution {
    public int trailingZeroes(int n) {
    	int res=0;
        while(n>=5){
            res+=n/5;
            n/=5;
        }
        //return n < 5 ? 0 : n/5 + 1;
        return res;
    }
}