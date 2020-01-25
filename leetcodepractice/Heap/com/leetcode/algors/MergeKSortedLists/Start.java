package com.leetcode.algors.MergeKSortedLists;
//https://leetcode.com/problems/last-stone-weight/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr =  {{1,4,5},
						{1,3,4},
						{2,6,9}};
		ListNode[] lists = new ListNode[arr.length];
		listFromArray(arr, lists);
		
		Solution sl = new Solution();
		ListNode root = sl.mergeKLists(lists);
		
		while (root!=null) {
			System.out.print(root.val + " ");
			root=root.next;
		}
		
	}

	static void listFromArray(int[][] arr, ListNode[] lists) {
		int i=0;
		for (int[] nums : arr) {
			ListNode root=null;
			ListNode prev = null;
			for (int n : nums) {
				ListNode node = new ListNode(n);
				if (root==null) {
					root = node;
				}
				if (prev!=null) prev.next = node;
				prev = node;
			}
			lists[i]=root;
			i++;
		}
	}
    
}

