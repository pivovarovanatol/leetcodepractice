package com.leetcode.algors.OddEvenLinkedList;
// https://leetcode.com/problems/odd-even-linked-list/

class Solution {
    // Solved with 2 pointers. 0ms(<100%)
    public ListNode oddEvenList(ListNode head) {
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode next = head;
        boolean s = true;
        if (head == null) return head;
        
        while (next != null){
            if (s){
                if (list1==null){
                    list1 = next;
                    head1 = next;
                    next = next.next;
                    list1.next = null;
                } else {
                    list1.next = next;
                    list1 = next;
                    next = next.next;
                    list1.next = null;
                }
                s = !s;
            } else {
                if (list2==null){
                    list2 = next;
                    head2 = next;
                    next = next.next;
                    list2.next = null;
                } else {
                    list2.next = next;
                    list2 = next;
                    next = next.next;
                    list2.next = null;
                }
                s = !s;
            } 
        }
        
        if (list1!=null) list1.next = head2;
        return head1;
    }
}