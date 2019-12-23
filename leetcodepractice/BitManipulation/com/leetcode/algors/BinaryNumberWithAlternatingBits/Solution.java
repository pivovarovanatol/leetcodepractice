package com.leetcode.algors.BinaryNumberWithAlternatingBits;
// https://leetcode.com/problems/binary-number-with-alternating-bits/

class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n = n >>> 1;
        
        while (n > 0){
            int tmp = n & 1;
            if (tmp == prev){
                return false;
            } else {
                prev = tmp;
                n = n >>> 1;
            }
        }
        return true;        
    }
}

