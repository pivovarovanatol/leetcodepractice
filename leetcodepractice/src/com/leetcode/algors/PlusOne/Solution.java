package com.leetcode.algors.PlusOne;
// https://leetcode.com/problems/plus-one/


class Solution {
    public int[] plusOne(int[] digits) {
    	int carry=1;
    	for (int i=digits.length-1;i>=0;i--) {
    		carry = digits[i]+carry;
    		digits[i] = carry%10;
    		carry=carry/10;
    	}
    	
    	if (carry>0) {
    		int[] arr = new int[digits.length + 1];
    		arr[0]=carry;
    		for (int i=1;i<digits.length+1;i++) {
    			arr[i] = digits[i-1];
    		}
			return arr;
		}
    	
    	return digits;
    }
}