package com.leetcode.algors.FindKSmallestPairDistance;
// https://leetcode.com/problems/find-k-th-smallest-pair-distance/

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    // from solution: BS + Sliding window - 4ms(<95%) 
    public int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
    
    // from solution: BS + prefix sum
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int WIDTH = 2 * nums[nums.length - 1];

        //multiplicity[i] = number of nums[j] == nums[i] (j < i)
        int[] multiplicity = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i-1]) {
                multiplicity[i] = 1 + multiplicity[i - 1];
            }
        }

        //prefix[v] = number of values <= v
        int[] prefix = new int[WIDTH];
        int left = 0;
        for (int i = 0; i < WIDTH; ++i) {
            while (left < nums.length && nums[left] == i) left++;
            prefix[i] = left;
        }

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                count += prefix[nums[i] + mi] - prefix[nums[i]] + multiplicity[i];
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }    
    
    public int smallestDistancePair2(int[] nums, int k) {
        // Idea: 
        // 1. Go over all combinations sing recursion and calculate the distance
        // 2. Add the K distances in the heap.
        // 3. return last element of the heap
        // 4. run out of memory :\
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        calcDistances(nums, pq);
        int result=0;
        while (k>0){
                result = pq.poll();
                //System.out.println("Distance is: " + result);
            k--;
        }
        return result;
    }
    
    public void calcDistances(int[] nums, PriorityQueue<Integer> pq){
        int dist = 0;
        
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                pq.add(Math.abs(nums[i]-nums[j]));
            }
        }
    }
    
    
}
