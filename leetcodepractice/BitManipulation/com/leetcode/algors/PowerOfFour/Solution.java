package com.leetcode.algors.PowerOfFour;
//https://leetcode.com/problems/power-of-four/

class Solution {
    public boolean isPowerOfFour(int num) {
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
}


