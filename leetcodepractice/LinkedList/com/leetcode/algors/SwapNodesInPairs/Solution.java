package com.leetcode.algors.SwapNodesInPairs;
// https://leetcode.com/problems/swap-nodes-in-pairs/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	// solved in 0ms(<100%) 
    public ListNode swapPairs(ListNode head) {
        
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        head = null;
            
        while (current != null && current.next != null){
            if (current.next != null){
                next = current.next.next;
                if (prev!=null){
                    prev.next = current.next;
                    //prev = current.next;
                } else {
                    prev = current.next;
                }
                if (head == null){
                    head = prev;
                }
                current.next.next = current;
                current.next = next;
                prev = current;
                current = next;
            }
        }
        
        return head == null ? current : head;
    }
}