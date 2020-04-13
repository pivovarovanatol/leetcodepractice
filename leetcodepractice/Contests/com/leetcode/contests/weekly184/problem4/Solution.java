package com.leetcode.contests.weekly184.problem4;
// https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/


class Solution {
    int modd = 1000000007; 
  
    public int numOfWays(int n) { 
        return solve(n); 
    } 
  
    public static int solve(int A) { 
        long color3 = 6; 
        long color2 = 6; 
        long temp = 0; 
        for (int i = 2; i <= A; i++)         
        { 
            temp = color3; 
            color3 = (2 * color3 + 2 * color2 ) % 1000000007; 
            color2 = ( 2 * temp + 3 * color2 ) % 1000000007; 
        } 
        long num = (color3 + color2) % 1000000007; 
        return (int)num; 
    } 
    
    
}