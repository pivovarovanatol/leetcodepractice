package com.leetcode.algors.PalindromeLinkedList;
//https://leetcode.com/problems/palindrome-linked-list/

public class Start {
    
    public static void main(String[] args) {
        
    	int[] arr = {1,2,3,4,3,2,1};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}
    	
    	//ListNode tmp = new Solution().reverse(head);
    	
        boolean result = new Solution().isPalindrome(head);
        
        System.out.print(result);
    }
}