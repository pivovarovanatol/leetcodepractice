package com.leetcode.algors.ReverseInteger;

class Solution {
    public int reverse(int x) {
        int result = 0;
    	if (x>=Integer.MAX_VALUE) {
    		return 0;
    	}
    	
    	if (x<=Integer.MIN_VALUE) {
    		return 0;
    	}
    	
        if (x ==0) {
        	return 0;
        } else  {   
	        if (x < 0) {
	        	// x < 0 case
	        	x*=-1;
	        	
	        	String strX = Integer.toString(x);
	        	char[] arr = strX.toCharArray();
	        	char tmp;
	        	int n = arr.length;
	        	for (int i=0;i<n/2;i++) {
	        		tmp = arr[i];
	        		arr[i]=arr[n-i-1];
	        		arr[n-i-1]=tmp;
	        	}
	        	
	        	strX = new String (arr);
	        	long test = Long.parseLong(strX);
	        	if (test > Integer.MAX_VALUE) {
	        		strX="0";
	        		}
	        	x = Integer.parseInt(strX);
	        	x*=-1;
	        	return x;
	        } else {
	        	// x > 0 case
	        	String strX = Integer.toString(x);
	        	char[] arr = strX.toCharArray();
	        	char tmp;
	        	int n = arr.length;
	        	for (int i=0;i<n/2;i++) {
	        		tmp = arr[i];
	        		arr[i]=arr[n-i-1];
	        		arr[n-i-1]=tmp;
	        	}
	        	
	        	strX = new String (arr);
	        	long test = Long.parseLong(strX);
	        	if (test > Integer.MAX_VALUE) {
	        		strX="0";
	        		}
	        	x = Integer.parseInt(strX);
	        	return x;
	        }
        }
    }
}