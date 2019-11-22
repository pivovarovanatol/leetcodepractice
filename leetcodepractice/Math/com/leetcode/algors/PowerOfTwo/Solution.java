package com.leetcode.algors.PowerOfTwo;
// https://leetcode.com/problems/power-of-two/

class Solution {

    // Iterative solution. 1ms (<100%) 33.7MB(<7.32%)
    public boolean isPowerOfTwo(int n) {
        
        if (n==1) {
            return true;
        }
        if (n<=0) {
            return false;
        }
        
        while (n > 2) {
            if (n%2 == 1) {
                return false;
            }
            n = n /2;
        }
        
        return true;
    }


    
    
    
    // Recursive solution. 1ms (<100%) 33.7MB(<7.32%)
    public boolean isPowerOfTwo2(int n) {
        
        if (n==1) {
            return true;
        }
        if (n<=0) {
            return false;
        }
        
        return (isPowerOfTwoHelper(n));
        
    }

    public boolean isPowerOfTwoHelper(int n) {
        
        if (n==2){
            return true;
        }
        
        if (n==1){
            return false;
        }        
        int n2 = n % 2;

        if (n2==1){
            return false;
        }
        
        return isPowerOfTwoHelper(n/2);
    }


}
