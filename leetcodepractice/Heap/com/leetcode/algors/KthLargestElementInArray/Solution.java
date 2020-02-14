package com.leetcode.algors.KthLargestElementInArray;
// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    // with Priority queue. 5ms(<59%) 41MB(<5%)
    public int findKthLargest(int[] nums, int k) {
        int result=Integer.MIN_VALUE;
        // using new Comparator
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 >= e2 ? 1 : -1;
            }
        });
        
        for (int e : nums){
            pq.add(-1*e);
        }
        
        for (int i=0;i<k;i++){
            result = -1*pq.poll();
        }
        return result;
    }

    public int findKthLargest4(int[] nums, int k) {
        int result=Integer.MIN_VALUE;
        // using Lambda comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a >= b ? 1 : -1);
        
        for (int e : nums){
            pq.add(-1*e);
        }
        
        for (int i=0;i<k;i++){
            result = -1*pq.poll();
        }
        return result;
    }
	
	
	public int findKthLargest3(int[] nums, int k) {
        int result=Integer.MIN_VALUE;
        // using negated values
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int e : nums){
            pq.add(-1*e);
        }
        
        for (int i=0;i<k;i++){
            result = -1*pq.poll();
        }
        return result;
    }

    public int findKthLargest1(int[] nums, int k) {
        int result=Integer.MIN_VALUE;
        // using Collections.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int e : nums){
            pq.add(e);
        }
        
        for (int i=0;i<k;i++){
            result = pq.poll();
        }
        return result;
    }

    // brute force with sorting an array and returning n-k element. 1ms(<99%) 41MB(<5%)
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return (nums[nums.length-k]);
    }
}