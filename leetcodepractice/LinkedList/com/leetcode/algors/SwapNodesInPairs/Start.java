package com.leetcode.algors.SwapNodesInPairs;
// https://leetcode.com/problems/swap-nodes-in-pairs/
	
public class Start {
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4};
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
    	
    	int x = 3;
    	
        Solution sl = new Solution();
        head = sl.swapPairs(head);
        
        while(head!=null) {
        	System.out.print(head.val + " ");
        	head = head.next;
        }
        System.out.println();
    }
}