package com.leetcode.algors.RemoveDuplicatesFromSortedListII;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

class Solution {
	// solved 0ms(<100%) 
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        head = null;
        while (curr != null){
            ListNode next = curr.next;
            if (next != null && curr.val == next.val){
                while (next != null && curr.val == next.val){
                    next = next.next;
                }
                curr = next;
                if (prev!=null){
                    prev.next = next;
                }
            } else {
                if (head==null) head = curr;
                prev = curr;
                if (curr!= null ) {
                    curr = curr.next;
                }
            }
        }
        return head;
    }
}