package com.leetcode.algors.MiddleLinkedList;
//https://leetcode.com/problems/middle-of-the-linked-list/

public class Start {
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5,6};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	ListNode node = null;
    	int middle = arr.length/2;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		if (i==middle) {
    			node = tmp;
    		}
    		curr.next = tmp;
    		curr = tmp;
    	}
    	
        Solution sl = new Solution();
        ListNode midNode = sl.middleNode(head);
        
        System.out.println("========================== Results:");
        while(midNode!=null) {
        	System.out.print(midNode.val + " ");
        	midNode = midNode.next;
        }
        System.out.println();

        System.out.println("========================== Expected:");
        while(node!=null) {
        	System.out.print(node.val + " ");
        	node = node.next;
        }
        System.out.println();

    }
}