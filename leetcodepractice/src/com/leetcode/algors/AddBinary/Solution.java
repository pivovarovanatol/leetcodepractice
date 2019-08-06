package com.leetcode.algors.AddBinary;

class Solution {
    public String addBinary(String a, String b) {
        
    	String result = "";
    	
    	char[] ar1 = a.toCharArray();
    	char[] ar2 = b.toCharArray();
    	int len_a = ar1.length;
    	int len_b = ar2.length;
    	
    	if (len_a > len_b) {
    		ar2 = makeSameLen(ar2, len_a);
    	}
    	
    	if (len_a < len_b) {
    		ar1 = makeSameLen(ar1, len_b);
    	}
    	
    	int carry = 0;
    	for (int i=ar1.length-1;i>=0;i--) {
    		int n1 = ar1[i]-'0';
    		int n2 = ar2[i]-'0';
    		
    		int sum = (n1 ^ n2 ^ carry);
    		sum += '0';
    		result = (char) sum + result;
    		carry = (n1 & n2) | (n2 & carry) | (n1 & carry);
    	}
    	
    	if (carry==1) {
    		result = "1" + result;
    	}
    	
    	return result;
    }
    

    char[] makeSameLen(char[] a, int len) {
    	char[] c = new char[len];
    	int len_a = a.length;
    	int diff = len - len_a;
    	for (int i=len-1;i>=0;i--) {
    		if (i >= diff) {
    			c[i]=a[i-diff];
    		} else {
    			c[i]='0';
    		}
    	}
    	
    	return c;
    }
    
}