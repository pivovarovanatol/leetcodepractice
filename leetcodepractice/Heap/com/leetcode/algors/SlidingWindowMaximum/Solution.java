package com.leetcode.algors.SlidingWindowMaximum;
// https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	// from discussions with Heap. 78ms (<13%)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return new int [] {};
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int [] res = new int[nums.length-k+1];
        int index = 0;
        for(int i=0;i<k;i++) {
            q.add(nums[i]);              
        }
        res[index++] = q.peek();
        for(int i=k;i<nums.length;i++) {
            q.remove(nums[i-k]);
            q.add(nums[i]);
            res[index++] = q.peek();
        }   
        return res;
    }
	
	// from discussions. Solution with Deque.  7ms (<85%)
	public int[] maxSlidingWindow2(int[] a, int k) {
		 if (a == null || k <= 0) return new int[0];		 
		 int[] res = new int[a.length - k + 1];
		 ArrayDeque<Integer> deque = new ArrayDeque<Integer>(); 
		 
		 int index  = 0;
		 for (int i = 0; i < a.length; i++) { 
			 int currNumber = a[i];
			 while (!deque.isEmpty() && deque.peek() < i - k + 1) // Ensure deque's size doesn't exceed k
				 deque.poll();
			 
			// Remove numbers smaller than a[i] from right(a[i-1]) to left, to make the first number in the deque the largest one in the window		 
			 while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) 
				 deque.pollLast();
			 
			 deque.offer(i);// Offer the current index to the deque's tail
			 
			 if (i >= k - 1)// Starts recording when i is big enough to make the window has k elements 
				 res[index++] = a[deque.peek()];
		 }		 
		 return res;
	 }
}