package com.leetcode.algors.LinkeListCycle;


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

		ListNode tmp2 = new ListNode(7);
		tmp1.next = tmp2;
		
		tmp2.next = l2;
		
		Solution sl = new Solution();
		boolean result = sl.hasCycle(l2);
		
		System.out.println(result);
		
	}

}
