package com.leetcode.algors.PalindromeLinkedList;
//https://leetcode.com/problems/palindrome-linked-list/

import org.junit.Assert;
import org.junit.Test;

public class PalindromeLinkedListTest {

	@Test
	public void oneElementListTest() {
		// given
    	int[] arr = {1};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}
    	// when
        boolean actual = new Solution().isPalindrome(head);
        boolean expected = true;
        
        // then 
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void emptyListTest() {
		// given
    	int[] arr = {};
    	ListNode head = null;
    	//ListNode curr = head;
    	
    	/*for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}*/
    	// when
        boolean actual = new Solution().isPalindrome(head);
        boolean expected = true;
        
        // then 
        Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void palindromeListTest() {
		// given
    	int[] arr = {1,1,1,2,2,3,2,2,1,1,1};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}
    	// when
        boolean actual = new Solution().isPalindrome(head);
        boolean expected = true;
        
        // then 
        Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void notPalindromeListTest() {
		// given
    	int[] arr = {1,1,1,2,3,3,2,2,1,1,1};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}
    	// when
        boolean actual = new Solution().isPalindrome(head);
        boolean expected = false;
        
        // then 
        Assert.assertEquals(expected, actual);
	}
	
	
	
}
