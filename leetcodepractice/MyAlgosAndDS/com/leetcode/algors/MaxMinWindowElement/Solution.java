package com.leetcode.algors.MaxMinWindowElement;

import java.util.ArrayDeque;

class Solution {
    public int[] maxWindowElement(int[] nums, int window) {
        int[] result = new int[nums.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0;i<window;i++) {
        	while (q.size()>0 && nums[i]>nums[q.peekLast()]) {
        		q.removeLast();
        		q2.removeLast();
        	}
        	q.addLast(i);
        	q2.addLast(nums[i]);
        }

        result[0]=q2.peek();
        int pointer1 = 1;
        int pointer2 = window;
        
        while (pointer1<nums.length) {
        	while (q.size() > 0 && q.peek() < pointer1) {
        		q.removeFirst();
        		q2.removeFirst();
        	}
        	while (q.size()>0 && pointer2 < nums.length && nums[pointer2] > nums[q.peekLast()]) {
        		q.removeLast();
        		q2.removeLast();
        	}
        	q.addLast(pointer2);
        	q2.addLast(nums[pointer2]);
        	
        	result[pointer1]=nums[q.peek()];
        	pointer1++;
        	if (pointer2<nums.length-1) pointer2++;
        }
        return result;
    }

    
    public int[] minWindowElement(int[] nums, int window) {
        int[] result = new int[nums.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0;i<window;i++) {
        	while (q.size()>0 && nums[i]<nums[q.peekLast()]) {
        		q.removeLast();
        		q2.removeLast();
        	}
        	q.addLast(i);
        	q2.addLast(nums[i]);
        }

        result[0]=q2.peek();
        int pointer1 = 1;
        int pointer2 = window;
        
        while (pointer1<nums.length) {
        	while (q.size() > 0 && q.peek() < pointer1) {
        		q.removeFirst();
        		q2.removeFirst();
        	}
        	while (q.size()>0 && pointer2 < nums.length && nums[pointer2] < nums[q.peekLast()]) {
        		q.removeLast();
        		q2.removeLast();
        	}
        	q.addLast(pointer2);
        	q2.addLast(nums[pointer2]);
        	
        	result[pointer1]=nums[q.peek()];
        	pointer1++;
        	if (pointer2<nums.length-1) pointer2++;
        }
        return result;
    }
    
    
    
}