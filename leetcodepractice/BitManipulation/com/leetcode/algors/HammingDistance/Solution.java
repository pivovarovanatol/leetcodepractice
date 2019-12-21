package com.leetcode.algors.HammingDistance;
//https://leetcode.com/problems/hamming-distance/

class Solution {
    public int hammingDistance(int x, int y) {
     
        int res = x ^ y;
        int count=0;
        
        for (int i=0;i<31;i++){
            int tmp = res&1;
            count += tmp;
            res = res >>> 1;
            
        }
        
        return count;
    }
}