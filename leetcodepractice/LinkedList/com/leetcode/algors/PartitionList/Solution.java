package com.leetcode.algors.PartitionList;
// https://leetcode.com/problems/partition-list/

class Solution {
    // Trying to solve with 2 pointers for lists greater and smaller than X. 0ms (<100%) 
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode next = head;
        ListNode prev = null;
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode head1 = null;
        ListNode head2 = null;
        head = null;
        
        while (next != null){
        	if (next.val >= x) {
        		// val >= x -> adding to list 1
        		if (list2 == null) {
        			list2 = next;
        			next = next.next;
        			list2.next = null;
        		} else {
        			list2.next = next;
        			list2 = next; 
        			next = next.next;
        			list2.next = null;
        		}
        		if (head2 == null) head2 = list2;
        	} else {
        		// val < x -> adding to list 2
        		if (list1 == null) {
        			list1 = next;
        			next = next.next;
        			list1.next = null;
        		} else {
        			list1.next = next;
        			list1 = next; 
        			next = next.next;
        			list1.next = null;
        		}
        		if (head1 == null) head1 = list1;
        	}
        }
        
        if (list1!=null) list1.next = head2;
        
        return head1 == null ? head2 : head1;
    }
}
