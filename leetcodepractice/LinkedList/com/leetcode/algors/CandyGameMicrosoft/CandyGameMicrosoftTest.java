package com.leetcode.algors.CandyGameMicrosoft;

import org.junit.Assert;
import org.junit.Test;

public class CandyGameMicrosoftTest {

	@Test
	public void candyGameMicrosoftTest1() {
		// given
		int[] arr = {1,2,3,4,4,4,5,6,6,7,8,9,9,9,9};
		int[] exp = {1,2,3,5,7,8};
		ListNode actual = createList(arr);
		ListNode expected = createList(exp);

		// when 
		Solution sl = new Solution();
		actual = sl.candyGameMicrososft(actual);
		
		// then
		
		while (actual!=null && expected!=null) {
			Assert.assertEquals("Comparing values in the lists: ", actual.val, expected.val);
			actual = actual.next;
			expected = expected.next;
		}
		
		Assert.assertEquals("Comparing length/last elements of the lists (should be null): ", actual==null, expected==null);
		
	}

	@Test
	public void candyGameMicrosoftTest2() {
		// given
		int[] arr = {2,2,2,4,4,4,5,6,6,7,8,9,9,9,9};
		int[] exp = {5,7,8};

		ListNode actual = createList(arr);
		ListNode expected = createList(exp);

		// when 
		Solution sl = new Solution();
		actual = sl.candyGameMicrososft(actual);
		
		// then
		while (actual!=null && expected!=null) {
			Assert.assertEquals("Comparing values in the lists: ", actual.val, expected.val);
			actual = actual.next;
			expected = expected.next;
		}
		Assert.assertEquals("Comparing length/last elements of the lists (should be null): ", actual==null, expected==null);
	}


	@Test
	public void candyGameMicrosoftTestEmptyList() {
		// given
		int[] arr = {};
		int[] exp = {};

		ListNode actual = createList(arr);
		ListNode expected = createList(exp);

		// when 
		Solution sl = new Solution();
		actual = sl.candyGameMicrososft(actual);
		
		// then
		while (actual!=null && expected!=null) {
			Assert.assertEquals("Comparing values in the lists: ", actual.val, expected.val);
			actual = actual.next;
			expected = expected.next;
		}
		Assert.assertEquals("Comparing length/last elements of the lists (should be null): ", actual==null, expected==null);
	}

	@Test
	public void candyGameMicrosoftTestOneElement() {
		// given
		int[] arr = {1};
		int[] exp = {1};

		ListNode actual = createList(arr);
		ListNode expected = createList(exp);

		// when 
		Solution sl = new Solution();
		actual = sl.candyGameMicrososft(actual);
		
		// then
		while (actual!=null && expected!=null) {
			Assert.assertEquals("Comparing values in the lists: ", actual.val, expected.val);
			actual = actual.next;
			expected = expected.next;
		}
		Assert.assertEquals("Comparing length/last elements of the lists (should be null): ", actual==null, expected==null);
	}

	
	private ListNode createList(int[] arr) {
		if (arr==null || arr.length==0) return null;
		
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
	
		for (int i=1;i<arr.length;i++) {
			ListNode n = new ListNode(arr[i]);
			current.next = n;
			current = n;
		}
		return head;
	}

	private void printList(ListNode head) {
		ListNode current;
		current = head;
		while(current!=null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}
	
	
}
