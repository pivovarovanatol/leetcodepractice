package com.leetcode.algors.IntersectionOfTwoLinkedLists;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next=null;}

    ListNode (ListNode node, int val) {
    	ListNode newNode = new ListNode(val);
    	node.next = newNode;
    }

}
