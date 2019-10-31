package com.leetcode.algors.NumberOf1Bits;
// https://leetcode.com/problems/number-of-1-bits/
	
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        String str = Integer.toBinaryString(n);
        
        for(char ch : str.toCharArray()){
            count += ch == '1' ? 1 : 0;
        }
        return count;
    }
    
    
    public int hammingWeight2(int n) {
        if(n==0){
            return 0;
        }
        int res=0;
        while(n!=0){
            n&=(n-1);
            res++;
        }
        return res;
    }
}