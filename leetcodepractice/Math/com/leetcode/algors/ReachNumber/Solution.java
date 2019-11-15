package com.leetcode.algors.ReachNumber;
// https://leetcode.com/problems/reach-a-number/


class Solution {
	
	
	// Solution from discussion -> to compare
    public int reachNumber(int target) {
        //target = Math.abs(target);
        
        target = target > 0 ? target : 0-target;
        
        int sum = 0;
        int k = 0;
        while(sum < target || (sum - target) % 2 != 0){
            sum += ++k;
        }
        return k;
    }    
	
    public int reachNumber2(int target) {

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