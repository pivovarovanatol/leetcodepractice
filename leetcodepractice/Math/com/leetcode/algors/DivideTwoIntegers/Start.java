package com.leetcode.algors.DivideTwoIntegers;
//https://leetcode.com/problems/divide-two-integers/

public class Start {

    public static void main(String[] args) {
    	
    	long startTime = System.currentTimeMillis(); 
    	
//        int dividend = Integer.MIN_VALUE;
//        int divisor = Integer.MIN_VALUE;

    	int dividend = 100;
        int divisor = 3;
        
//        int dividend = Integer.MAX_VALUE;
//        int divisor = Integer.MAX_VALUE-5;
    	
//        int dividend = 1;
//        int divisor = -1;

//        int dividend = 1;
//        int divisor = 2;

//        int dividend = 1026117192;
//        int divisor = -874002063;

        int actual = new Solution().divide(dividend, divisor);
        // String out = listNodeToString(ret);
        System.out.println(actual);
        System.out.println(dividend/divisor);
        
        System.out.println("Executed in: " + (System.currentTimeMillis() - startTime) + "ms");
        
    }
}

