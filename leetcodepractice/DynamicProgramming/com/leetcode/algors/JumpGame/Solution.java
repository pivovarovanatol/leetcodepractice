package com.leetcode.algors.JumpGame;
// https://leetcode.com/problems/jump-game/submissions/


// solved with iteration thru the array adn calculating the range to jump. Works faster than recursion due to less nested calls. 1ms (<98%)
public class Solution {
    public boolean canJump(int[] A) {
        if (A==null || A.length==0) return true;
        int range = 0,index=0;
        while (index<=range){
            range=Math.max(range,index+A[index++]);//Get the maximum range to jump
            if (range>=A.length-1) //Arrive at the last index
                return true;
        }
        return false;
    }
}