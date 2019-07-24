package com.leetcode.algors.MergeTwoSortedLists;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1 = new ListNode(1);
		
		ListNode l2 = new ListNode(2);
		
		Solution sl = new Solution();
		ListNode result = sl.mergeTwoLists(l1, l2);
		System.out.println(result);
	}

}
