package com.leetcode.algors.IntersectionOfTwoLinkedLists;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		
		
		
		Solution sl = new Solution();
		ListNode result = sl.getIntersectionNode(l0, l6);
		
		System.out.println(result == null ? null : result.val);

		
	}

}
