package com.leetcode.algors.ReverseBits;
// https://leetcode.com/problems/reverse-bits/


import java.lang.StringBuilder;

public class Solution {

public int reverseBits(int n) {
		int result = 0;
    for(int i = 0; i< 32; i++){
        if((n &1) == 1) {
            result = (result <<1) + 1;

        }else {
            result <<= 1;
        }
        n >>= 1;
    }
    return result;
}


// you need treat n as an unsigned value
public int reverseBits2(int n) {

    String binaryString = Integer.toBinaryString(n);
    
    binaryString = ("00000000000000000000000000000000" + binaryString).substring(binaryString.length());
    
    /*char[] chars = binaryString.toCharArray();
    int len = chars.length;
    
    for (int i=0;i<len/2;i++){
        char tmp = chars[len-1-i];
        chars[len-1-i] = chars[i];
        chars[i] = tmp;
    }

    binaryString = new String(chars);*/
    
    StringBuilder sb = new StringBuilder();
    binaryString = sb.append(binaryString).reverse().toString();
    int result = (int) Long.parseLong(binaryString, 2);
    
    return result;
}



}