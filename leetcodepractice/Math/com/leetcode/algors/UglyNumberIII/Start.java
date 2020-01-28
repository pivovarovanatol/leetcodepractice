package com.leetcode.algors.UglyNumberIII;
// https://leetcode.com/problems/power-of-two/


public class Start {

    public static void main(String[] args) {
            
//    	int n=1000000000;
//    	int a=2;
//    	int b=217983653;
//    	int c=336916467;
//    	int expected= 1999999984;
    	
//    	int n=12;
//    	int a=4;
//    	int b=6;
//    	int c=100;
//    	int expected= 36;

//    	int n=5;
//    	int a=2;
//    	int b=11;
//    	int c=13;
//    	int expected= 10;

//    	int n=1000;
//    	int a=2;
//    	int b=3;
//    	int c=5;
//    	int expected= 1364;
    	
//    	int n=8;
//    	int a=2;
//    	int b=3;
//    	int c=4;
//    	int expected= 12;
    	
//    	int n=7;
//    	int a=7;
//    	int b=7;
//    	int c=7;
//    	int expected= 49;

//    	int n=100;
//    	int a=2;
//    	int b=3;
//    	int c=5;
//    	int expected= 136;

    	int n=10;
    	int a=7;
    	int b=6;
    	int c=8;
    	int expected= 28;
    	
    	Solution sl = new Solution();
    	int actual = sl.nthUglyNumber(n, a, b, c);
        System.out.println(actual + " = " + expected);
        
        System.out.println("LCM of 8 and 12 = " + sl.lcm(8, 12));
        
        System.out.println("GCD of 8 and 12 = " + sl.gcd(8, 12));
        
    }

}
