package com.leetcode.algors.KthLargestElementInStream;

import java.util.PriorityQueue;


// From discussions. Just one PriorityQueue holding K elements, the rest of the queue is discarded.

class KthLargest2 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int k;
    public KthLargest2(int k, int[] nums) {
        pq.clear();
        this.k =k;
        if(nums.length>0){
        for(int x : nums){
            if(pq.size()<k){
            pq.add(x);}
            else {
                if(x>pq.peek()){
                    pq.poll();
                    pq.add(x);
                }
            }
        }
        }
    }
    
    public int add(int val) {
                if(pq.size()<k)
                { pq.add(val);
                }
                else{ if(pq.peek()<val){
                    pq.poll();
                    pq.add(val);
                }}
        return pq.peek();
    }
}