package com.leetcode.algors.KthLargestElementInStream;
// https://leetcode.com/problems/kth-largest-element-in-a-stream/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 3;
		int[] arr = {};
		KthLargest kthLargest = new KthLargest(3, arr);
	
		System.out.println(kthLargest.add(3));   // returns 4
		System.out.println(kthLargest.add(5));   // returns 5
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8
		
	}
    
}

