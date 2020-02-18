package com.leetcode.algors.NextGreaterNodeInLinkedList;
// https://leetcode.com/problems/next-greater-node-in-linked-list/


public class Start {
   
    public static void main(String[] args) {
    	
    	int[] nums = {2,2,5};
    	ListNode head = new ListNode(nums[0]);
    	ListNode current = head;
    	for (int i=1;i<nums.length;i++) {
    		ListNode next = new ListNode(nums[i]);
    		current.next = next;
    		current = next;
    	}
    	
    	Solution sl = new Solution();
    	int n  = 3;
    	int[] actual = sl.nextLargerNodes(head);
    	
    	for (int e : actual) {
    		System.out.print(e + " ");
    	}
    	
    }
}