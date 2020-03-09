package com.leetcode.algors.OddEvenLinkedList;
// https://leetcode.com/problems/odd-even-linked-list/
	
public class Start {
    public static void main(String[] args) {
    	int[] arr = {3,6,1,1,1,7,1,1,1,1};
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
    	
        Solution sl = new Solution();
        head = sl.oddEvenList(head);
        
        while(head!=null) {
        	System.out.print(head.val + " ");
        	head = head.next;
        }
        System.out.println();
    }
}