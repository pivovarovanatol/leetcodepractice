package com.leetcode.algors.NextSmallerBiggerElement;

import java.util.Stack;

class Solution {
    public int[] prevSmallerElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        result[0]=st.peek();
        for (int i=1;i<nums.length;i++) {
        	int t=nums[i];
        	while (st.size()>0 && st.peek()>nums[i]) {
        		st.pop();
        	}
        	if (st.size()>0) {
        		result[i] = st.peek();
        	} else {
        		result[i] = nums[i];
        	}
        	st.push(nums[i]);
        }
        return result;
    }

    public int[] prevBiggerElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        result[0]=st.peek();
        for (int i=1;i<nums.length;i++) {
        	int t=nums[i];
        	while (st.size()>0 && st.peek()<nums[i]) {
        		st.pop();
        	}
        	if (st.size()>0) {
        		result[i] = st.peek();
        	} else {
        		result[i] = nums[i];
        	}
        	st.push(nums[i]);
        }
        return result;
    }
    
}