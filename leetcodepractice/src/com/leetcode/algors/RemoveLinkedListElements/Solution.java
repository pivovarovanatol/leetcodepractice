package com.leetcode.algors.RemoveLinkedListElements;
//https://leetcode.com/problems/remove-linked-list-elements/


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode currNode = head;
        ListNode prevNode = null;
        
        while (currNode != null){
            if (currNode.val == val){
                if (currNode == head) {
                    head = currNode.next;
                    currNode = head;
                } else {
                    prevNode.next = currNode.next;
                    currNode = currNode.next;
                }
            } else {
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        return head;
    }
}
