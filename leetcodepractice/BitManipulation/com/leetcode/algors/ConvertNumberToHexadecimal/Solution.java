package com.leetcode.algors.ConvertNumberToHexadecimal;
// https://leetcode.com/problems/convert-a-number-to-hexadecimal/

class Solution {
 
	// Solved with shift and bit-wise AND operation. 0ms(<100%) 33.9MB(<100%) 
    public String toHex(int num) {
        if (num ==0){ return "0";}
        
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e', 'f'};        
        StringBuilder sb = new StringBuilder();
        
        while(num!=0){
            int tmp = num&15;
            sb.append(hex[tmp]);
            num = num >>> 4;
        }
        
        return (sb.reverse().toString());
    }
}