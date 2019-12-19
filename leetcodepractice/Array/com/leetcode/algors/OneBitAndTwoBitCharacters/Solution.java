package com.leetcode.algors.OneBitAndTwoBitCharacters;
// https://leetcode.com/problems/1-bit-and-2-bit-characters/

class Solution {
	
	
	// solved with O(N) - simple scan and keep track of symbol start. 0ms(<100%) 35.9MB(<100%)
    public boolean isOneBitCharacter(int[] bits) {
        
        int i=0;
        int start = 0;
        
        while (i < bits.length){
            // if current symbol is 1 - then it must be two-bit symbol, so we skip one
            start = i;
            if (bits[i] == 1){
                i +=2;
            } else {
                // should be one bit symbol - increase by one
                i++;
            }
        }
        
        if (bits.length - start == 1){
            return true;
        } else {
            return false;
        }
    }
}
