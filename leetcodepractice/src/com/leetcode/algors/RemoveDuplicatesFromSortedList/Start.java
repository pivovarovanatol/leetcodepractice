package com.leetcode.algors.RemoveDuplicatesFromSortedList;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution sl = new Solution();
		int[] arr = {1,2,3,4,4,4,5,6,6,7,8,9,9,9,9};
		ListNode head = new ListNode(0);
		ListNode current = head;
		
		for (int i=0;i<arr.length;i++) {
			ListNode n = new ListNode(arr[i]);
			current.next = n;
			current = n;
		}
		
		head = sl.deleteDuplicates(head);
		
		current = head;
		while(current!=null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		
	}
}


