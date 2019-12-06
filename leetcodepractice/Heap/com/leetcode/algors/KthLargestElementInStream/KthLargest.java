package com.leetcode.algors.KthLargestElementInStream;
// https://leetcode.com/problems/kth-largest-element-in-a-stream/
import java.util.*;

// Solved with PriorityQueue. 17ms (<94%) 40MB(<100%) 
class KthLargest {

	PriorityQueue<Integer> top;
	PriorityQueue<Integer> rest;
	int kElement;
	int k;
  
	 public KthLargest() {
	     top = new PriorityQueue<Integer>(10);
	     rest = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	     kElement = -1;
	     k = -1;
	 }
	 
	 public KthLargest(int k, int[] nums) {
	     top = new PriorityQueue<Integer>(10);
	     rest = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	     this.k = k;
	     this.kElement = -1;
	     for (int element : nums) {
    		 add(element);
	     }
	 }
	 
	 public int add(int val) {
 
		if (rest.size() > 0 && val <= rest.peek()) {
			rest.offer(val);
		} else {
			top.offer(val);
			if (top.size() >= this.k) {
				rest.offer(top.poll());
			}
		}
		
		if (rest.size() > 0) {
			this.kElement = rest.peek();
		}
		
		return this.kElement;
	 }
	 
}

/**
* Your KthLargest object will be instantiated and called as such:
* KthLargest obj = new KthLargest(k, nums);
* int param_1 = obj.add(val);
*/


