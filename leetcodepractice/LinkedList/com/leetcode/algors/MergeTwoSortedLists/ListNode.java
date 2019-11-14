package com.leetcode.algors.MergeTwoSortedLists;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    ListNode (ListNode node, int val) {
    	ListNode newNode = new ListNode(val);
    	node.next = newNode;
    }

}
