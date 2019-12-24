package com.leetcode.algors.DeleteNodeLinkedList;
// https://leetcode.com/problems/delete-node-in-a-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	// Solved in 0ms(<100%) 37MB(<100%)
    public void deleteNode(ListNode node) {
        // Copying value from next node to the current node and then bypass the next node. 
    	
    	if (node != null) {
            node.val = node.next.val;
            node.next = node.next.next;
    	}
    }
}


