package com.leetcode.algors.NextGreaterElement1;
// https://leetcode.com/problems/next-greater-element-i/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
	// from discussions: using Stack and HashMap. 4ms(<80%) 
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

	
	// solved brute force with HashMap. 5ms(<18%) 46MB(<7%)
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        // Idea: 1. scan the nums2 and create a map of indexes for each element. 
        // 2. Then go over nums1 and for every element scan nums2 starting from it's index in the map.
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // Creating a map
        for(int i=0;i<n2;i++){
            map.put(nums2[i],i);
        }
        
        // Scanning nums1
        for (int i=0; i<n1; i++){
            int index = map.get(nums1[i]);
            int max = -1;
            for (int j=index+1;j<n2;j++){
                if (nums2[j]>nums1[i]){
                    max = nums2[j];
                    break;
                }
            }
            nums1[i] = max;
        }
        
        return nums1;
    }
}