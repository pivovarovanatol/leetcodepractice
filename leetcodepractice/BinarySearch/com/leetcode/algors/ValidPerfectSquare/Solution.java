package com.leetcode.algors.ValidPerfectSquare;
// https://leetcode.com/problems/valid-perfect-square/



class Solution {
	
	// Solved with binary search 0ms(<100%) 32.9MB(<6%???)
    public boolean isPerfectSquare(int num) {
        
        if (num <=0){
            return false;
        }
        
        if (num == 1){
            return true;
        }
        
        long start = 1;
        long end = num;
        
        while (start < end){
            long middle = start + (end - start)/2;
            
            //System.out.println("Start is: " + start + " End is: " + end + " Middle is: " + middle);
            
            long tmp = middle * middle;
            if (tmp == num){
                return true;
            }
            
            if (tmp > num){
                end = middle;
            } else {
                start = middle+1;
            }
            
            
        }        
     return false;   
    }
}
