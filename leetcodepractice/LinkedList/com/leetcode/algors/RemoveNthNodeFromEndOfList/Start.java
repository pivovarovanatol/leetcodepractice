package com.leetcode.algors.RemoveNthNodeFromEndOfList;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class Start {
   
    public static void main(String[] args) {
    	
    	int[] nums = {1,2,3,4,5};
    	ListNode head = new ListNode(0);
    	ListNode current = head;
    	for (int i : nums) {
    		ListNode next = new ListNode(i);
    		current.next = next;
    		current = next;
    	}
    	
    	Solution sl = new Solution();
    	int n  = 3;
    	head = sl.removeNthFromEnd(head, n);
    	
    	while (head!=null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	
    }
}