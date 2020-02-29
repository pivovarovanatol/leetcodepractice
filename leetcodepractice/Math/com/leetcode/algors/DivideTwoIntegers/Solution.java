package com.leetcode.algors.DivideTwoIntegers;
// https://leetcode.com/problems/divide-two-integers/


class Solution {
	
	// another solution from discussions 1ms(<100%). 
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        return (A > 0) == (B > 0) ? res : -res;
    }
	
	
	// from discussions: using the binary shift. 0ms (<100%)
    public int divide0(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        long z = a - b;
        while (a - b >= 0) {
        	long k = a - (b << x << 1);
            for (x = 0; a - (b << x << 1) >= 0; x++) {
            	k = a - (b << x << 1);
            };
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }	
	
    
    
    // from discussions: solved with recursion. 1ms(<100%)
    public int divide1(int a, int b) {
        if(a==Integer.MIN_VALUE){
            if(b==-1) return Integer.MAX_VALUE;
        }
        
        long x = a < 0 ? -(long)a : (long)a;
        long y = b < 0 ? -(long)b : (long)b;
        
        int res = recurse(x, y, 1);
        if(a < 0 && b < 0) return res;
        if(a < 0 || b < 0) return -res;
        return res;
    }

    public int recurse(long x, long y, int count) {
        if(x <= 0 || count==0) return 0;
        if(y > x) return recurse(x, y >>> 1, count >>> 1); //overshot, so divide and try again.
        else return recurse(x-y, y+y, count+count)+count;
    }    
    
    
    
	
	// brute force with subtractions. Lots for corner cases with MAX_VALUE/MIN_VALUE. Solved in 894ms(<7%)
    public int divide2(int dividend, int divisor) {
        if (divisor == 1){
            return dividend;
        } else if (divisor ==-1){
            if (dividend == Integer.MAX_VALUE) {
                return Integer.MIN_VALUE +1;
            } else if (dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            } else {
                return 0 - dividend;
            }
        }
        if (divisor == dividend) return 1;
        if (divisor == 2) return dividend >> 1;
        if (divisor == 4) return dividend >> 2;
        if (divisor == 8) return dividend >> 3;
        if (divisor == 16) return dividend >> 4;
        if (divisor == 32) return dividend >> 5;
        if (divisor == 64) return dividend >> 6;
        if (divisor == 128) return dividend >> 7;
        if (divisor == 256) return dividend >> 8;

        int count =0;
        boolean positive = true;
        // sign -> 0=plus, 1=minus
        int sign = 0;
        
        if (divisor < 0){
            if (dividend < 0){
                positive = true;
                sign = 1;
            } else {
                positive = false;
                sign = 0;
            }
        } else {
            if (dividend < 0){
                positive = false;
                sign = 0;
            } else {
                positive = true;
                sign = 1;
            }
        }

        if (dividend >=0){
            while (dividend >= 0){
                if (sign ==0){
                    dividend += divisor;
                    count++;
                } else {
                    dividend -= divisor;                
                    count++;
                }
            }
        } else {
            while (dividend <= 0){
                if (sign ==0){
                    dividend += divisor;
                    count++;
                } else {
                    dividend -= divisor;                
                    count++;
                }
            }
        }
        
        count--;
        return positive ? count : 0 - count;
    }
}


