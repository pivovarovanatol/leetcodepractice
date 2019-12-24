package com.leetcode.algors.MiddleLinkedList;
// https://leetcode.com/problems/middle-of-the-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	
	// Solved with two pointers Fast adn Slow. 0ms(<100%) 34.2MB(<100%)
    public ListNode middleNode(ListNode head) {
        
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode pointerFast = head.next.next;
        ListNode pointerSlow = head;
        
        while (pointerFast!=null && pointerFast.next != null){
            pointerSlow = pointerSlow.next;
            pointerFast = pointerFast.next.next;
        }
        pointerSlow = pointerSlow.next;
        return pointerSlow;
    }
}

