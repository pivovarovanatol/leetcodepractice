package com.leetcode.algors.SqrtX;
//https://leetcode.com/problems/sqrtx/

class Solution {
    public int mySqrt(int x) {
        
    	//long multi = 0;
    	//long multi2 = 0;
    	int start=0;
    	int end = x;
    	
    	while (true) {
    		int mid = (start + end)/2;
    		//multi = (long)mid * (long)mid;
    		//multi2 = ((long)(mid+1) * (long)(mid+1));
    		if ((long)mid * (long)mid==x) {
    			return mid;
    		}
    		if (((long)(mid+1) * (long)(mid+1))==x) {
    			return mid+1;
    		}
    		
    		if ((long)mid * (long)mid < x) {
    			if(((long)(mid+1) * (long)(mid+1))>x) {
    				return mid;
    			}
    			start = mid;
    		} else {
    			end=mid;
    		}
    	}
    }
}