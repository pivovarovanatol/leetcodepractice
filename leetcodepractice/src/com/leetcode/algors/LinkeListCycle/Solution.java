package com.leetcode.algors.LinkeListCycle;

import java.util.HashSet;

public class Solution {
    
	// Naive solution with O(n) complexity and using HashSet to determine the existence of the element
	public boolean hasCycle2(ListNode head) {
    	
    	HashSet<ListNode> set = new HashSet<>();
    	
    	boolean hasCycle=false;
    	
    	while (!hasCycle && head != null) {
    		if (!set.add(head)) {
    			hasCycle=true;
    		} else {
    			head = head.next;
    		}
    	}
    	return hasCycle;
    }
	
	
	// Two pointer approach. Complexity should be O(n) as well -> don't know why it's faster...
	public boolean hasCycle(ListNode head) {
    	
		ListNode fast = head;
		//ListNode slow = head;
		
    	while (fast!=null && fast.next!=null) {
    		head = head.next;
    		fast = fast.next.next;
    		
    		if (head == fast) {
    			return true;
    		}
    		
    	}
    	return false;
    }
	
	
}