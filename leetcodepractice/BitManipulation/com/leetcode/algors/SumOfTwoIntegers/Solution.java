package com.leetcode.algors.SumOfTwoIntegers;
// https://leetcode.com/problems/sum-of-two-integers/

class Solution {
	
	// from discussions: 0ms(<100%) 33.1MB(<6.67%?)
    public int getSum(int a, int b) {
        int idx = 0, sum = 0, carry = 0;
        
        for (int i = 0; i < 32; i++) {
            int a1 = a & (1 << i);
            int b1 = b & (1 << i);

            sum |= a1 ^ b1 ^ carry;
            carry = ((a1 & b1) | (b1 & carry) | (a1 & carry)) << 1;
        }
        
        return sum;
    }
	
	
    public int getSum2(int a, int b) {
        
    	String s1 = Integer.toBinaryString(a);
    	String s2 = Integer.toBinaryString(b);
    	
    	
        char[] strA = Integer.toBinaryString(a).toCharArray();
        char[] strB = Integer.toBinaryString(b).toCharArray();
        
        char[] longer = strA.length >= strB.length ? strA : strB;
        char[] shorter = strA.length < strB.length ? strA : strB;
        
        int carry = 0;
        int pointer1 = longer.length-1;
        int pointer2 = shorter.length-1;
        int count = 0;
        int res =0;
        
        while (pointer1 >= 0){
            int tmp =0;
            if (pointer2 >= 0){
                tmp = shorter[pointer2]-'0';
            }
            int digit1 = longer[pointer1]-'0';
            int digit = digit1 ^ tmp;
            digit = digit ^ carry;
            
            carry = (digit1 & tmp) | (tmp & carry) | (digit1 & carry);
            
            
            res += Math.pow(2,count) * digit;
            count++;
            pointer1--;
            pointer2--;
        }
        
        if (carry > 0) {
        	res += Math.pow(2,count);
        }
        return res;
    }
}

