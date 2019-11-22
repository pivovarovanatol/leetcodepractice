package com.leetcode.algors.MergeTwoSortedLists;


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode first = null;
    	ListNode current2=null;
    	ListNode current=null;
    	if (l1 == null && l2 == null) {return null;}
    	
    	if (l1 == null || l2 == null) {
        	if (l1 == null) {
        		first = new ListNode(l2.val);
        		current = first;
        		l2 = l2.next;
        	} else {
        		first = new ListNode(l1.val);
        		current = first;
        		l1 = l1.next;
        	}
    	} else {
    	
    	if (l1.val < l2.val) {
    		first = new ListNode(l1.val);
    		current = first;
    		l1 = l1.next;
    	} else
    	{
    		first = new ListNode(l2.val);
    		current = first;
    		l2 = l2.next;
    	}
    	}
    	
    	while (l1 != null || l2 != null) {
    		if (l1 != null && l2 != null) {
        		if (l1.val < l2.val) {
        			current2 = new ListNode(l1.val);
        			current.next = current2;
        			current = current2;
        			l1 = l1.next;
        		} else {
        			current2 = new ListNode(l2.val);
        			current.next = current2;
        			current = current2;
        			l2 = l2.next;
        		}
    		} else {
    		if (l1 != null) {
    			current2 = new ListNode(l1.val);
    			current.next = current2;
    			current = current2;
    			l1 = l1.next;
    			} else {
    			current2 = new ListNode(l2.val);
    			current.next = current2;
    			current = current2;
    			l2 = l2.next;
    			}
    		}
    	}

    	return first;
    }
}
