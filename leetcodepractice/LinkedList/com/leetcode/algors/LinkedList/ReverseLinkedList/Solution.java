package com.leetcode.algors.LinkedList.ReverseLinkedList;
// https://leetcode.com/problems/reverse-linked-list/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    
// Simple iterative solution -> 0ms (<100%) 37.4MB(<98%)
    public ListNode reverseList3(ListNode head) {
    ListNode next = head.next;
    ListNode curr = head;
    ListNode prev = null;
    
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    
    return prev;
}


// Simple recursive solution -> 0ms (<100%) 37.1MB(<99%)
public ListNode reverseList(ListNode head) {
    ListNode newHead;
    
    if (head.next == null){
        return head;
    }
    
    newHead = reverseList(head.next);
    
    head.next.next = head;
    head.next = null;
    return  newHead;
}



// Solution with Queue -> 1ms (<6%) 37.2MB(<98%)
public ListNode reverseList2(ListNode head) {
    ListNode curr = head;
    ListNode tmp = null;
    Deque<ListNode> st = new ArrayDeque<ListNode>();
    
    while (curr != null) {
        st.add(curr);
        curr = curr.next;
    }
    
    while (!st.isEmpty()) {
        curr = st.remove();
        curr.next = tmp;
        tmp = curr;
    }
    
    return tmp;
}
}
