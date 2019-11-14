package com.leetcode.algors.ReachNumber;
// https://leetcode.com/problems/reach-a-number/


class Solution {
    public int reachNumber(int target) {

        int steps = 0;
        int currPos = 0;
        long max = 10000000000l;
        long min = -10000000000l;
        int sign = 1;
        
        if (target < 0){
            sign = -1;
        }
        
        while (currPos < max && currPos > min){

            if (target == currPos){
                return steps;
            };
            steps++;
            
            System.out.println("Step is: " + steps + " currPos is: " + currPos + " target is: " + target);
            
            currPos += steps*sign;
            sign *= -1;
            
        }
        
        return steps;   
    }
    
    
    
}