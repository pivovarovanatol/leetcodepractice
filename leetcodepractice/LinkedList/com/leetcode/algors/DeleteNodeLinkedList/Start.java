package com.leetcode.algors.DeleteNodeLinkedList;
// https://leetcode.com/problems/delete-node-in-a-linked-list/

public class Start {
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	ListNode node = null;
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		if (i==3) {
    			node = tmp;
    		}
    		curr.next = tmp;
    		curr = tmp;
    	}
    	
    	ListNode oldHead = head;
        while(head!=null) {
        	System.out.print(head.val + " ");
        	head = head.next;
        }
        System.out.println();
        
        Solution sl = new Solution();
        sl.deleteNode(node);
        
        head = oldHead;
        while(head!=null) {
        	System.out.print(head.val + " ");
        	head = head.next;
        }
        System.out.println();
    }
}