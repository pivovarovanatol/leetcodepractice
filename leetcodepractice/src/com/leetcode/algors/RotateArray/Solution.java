package com.leetcode.algors.RotateArray;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void rotate(int[] nums, int k) {

    	if (k==0) return;
        int len = nums.length;
        if (len < 2) return;
    	k = k % len;
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i=len-k;i<len;i++){
            deque.add(nums[i]);
        }
        
        for (int i=0;i<len-k;i++){
            deque.add(nums[i]);
        }
        
        for (int i=0;i<len;i++){
            nums[i] = deque.remove();
        }


        
    }
}