package com.leetcode.algors.CandyGameMicrosoft;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/


class Solution {
    public ListNode candyGameMicrososft(ListNode head) {
    	ListNode current = head;
    	if (head == null) {
    		return head;
    	}
    	if (head.next==null) {
    		return head;
    		}
    	
    	ListNode start=null;
		ListNode prev = null;
    	
    	while (current != null) {
    		
    		if (current.next !=null && current.next.val == current.val) {
    			if (prev!=null) prev.next = null;
        		while (current.next !=null && current.next.val == current.val) {
        			current = current.next;
        		}
        		current = current.next;
    		} else {
        		if (start==null) {
        			start = current;
        		}
        		
        		if (prev!=null) {
        			prev.next = current;
        		} 
        		prev = current;
        		current = current.next;
    		} 
    	}
    	return start;
    }
}

