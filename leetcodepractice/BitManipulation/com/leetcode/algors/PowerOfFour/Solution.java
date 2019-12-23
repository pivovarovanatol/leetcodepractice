package com.leetcode.algors.PowerOfFour;
//https://leetcode.com/problems/power-of-four/

class Solution {
	
	// Solved with shift and XOR
    public boolean isPowerOfFour2(int num) {
        boolean isPower = false;
        int i = 0;
        while (i < 32){
            int tmp=1;
            for (int j=0;j<i;j++){
                tmp = tmp << 1;
            }
            if (tmp > num){
                return false;
            }
            tmp = (num ^ tmp);
            if (tmp == 0){
                return true;
            }
            i=i+2;
        } 
        
        return isPower;
    }
    
    
    // Solved with 2 logarithms (Mariya's idea). 1ms(<100%) 33.7MB(<6.67%)
    public boolean isPowerOfFour(int num) {
    	float n = (float) (Math.log(num) / Math.log(4));
    	int x = (int) n;
    	System.out.println(n + " | " + x);
    	return (x == n);
    }
}


