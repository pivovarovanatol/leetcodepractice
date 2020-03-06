package com.leetcode.algors.RemoveDuplicatesFromSortedListII;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class Start {
    public static void main(String[] args) {
    	int[] arr = {1,1};
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
        Solution sl = new Solution();
        head = sl.deleteDuplicates(oldHead);
        
        while(head!=null) {
        	System.out.print(head.val + " ");
        	head = head.next;
        }
        System.out.println();
    }
}