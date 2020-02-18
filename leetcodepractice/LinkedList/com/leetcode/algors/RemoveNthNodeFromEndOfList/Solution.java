package com.leetcode.algors.RemoveNthNodeFromEndOfList;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode current = head;
        ListNode slow = head;
        int count = 0;
        // getting the Nth element
        while (current!=null){
            current = current.next;
            if (count >= n){
                prev = slow;
                slow = slow.next;
            }
            count++;
        }
        
        if (prev!=null){
            prev.next = slow.next;    
        } else {
            head = slow.next;
        }
        
        return head;
    }
}
