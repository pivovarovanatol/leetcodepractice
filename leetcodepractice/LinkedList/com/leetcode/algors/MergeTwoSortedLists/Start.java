package com.leetcode.algors.MergeTwoSortedLists;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1 = null;
		ListNode tmp = null;
		
		ListNode l2 = new ListNode(1);
		tmp = new ListNode(3);
		l2.next = tmp;
		ListNode tmp1 = new ListNode(4);
		tmp.next = tmp1;
		
		Solution sl = new Solution();
		ListNode result = sl.mergeTwoLists(null, l2);
		
		while (result.next!=null) {
			System.out.println(result.val);
			result = result.next;
		}
		System.out.println(result.val);
		
	}

}
