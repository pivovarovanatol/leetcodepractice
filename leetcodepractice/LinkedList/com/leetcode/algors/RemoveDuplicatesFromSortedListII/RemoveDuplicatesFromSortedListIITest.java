package com.leetcode.algors.RemoveDuplicatesFromSortedListII;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListIITest {
	@Test
	public void deleteNodeLinkedListTest1() {
		// given
		int[] arr = {1,1,2};
		int[] arrExpected = {2};
    	ListNode head = createList(arr);

    	ListNode headExpected = createList(arrExpected);
    	
    	// when
        Solution sl = new Solution();
        head = sl.deleteDuplicates(head);
        // then
        compareLists(head, headExpected);
    }

	
	@Test
	public void deleteNodeLinkedListTest2() {
		// given
		int[] arr = {};
		int[] arrExpected = {};
    	ListNode head = createList(arr);

    	ListNode headExpected = createList(arrExpected);
    	
    	// when
        Solution sl = new Solution();
        head = sl.deleteDuplicates(head);
        // then
        compareLists(head, headExpected);
    }

	
	@Test
	public void deleteNodeLinkedListTest3() {
		// given
		int[] arr = {1,1,2,2};
		int[] arrExpected = {};
    	ListNode head = createList(arr);

    	ListNode headExpected = createList(arrExpected);
    	
    	// when
        Solution sl = new Solution();
        head = sl.deleteDuplicates(head);
        // then
        compareLists(head, headExpected);
    }

	@Test
	public void deleteNodeLinkedListTest4() {
		// given
		int[] arr = {1,1,3,2,2};
		int[] arrExpected = {3};
    	ListNode head = createList(arr);

    	ListNode headExpected = createList(arrExpected);
    	
    	// when
        Solution sl = new Solution();
        head = sl.deleteDuplicates(head);
        // then
        compareLists(head, headExpected);
    }

	@Test
	public void deleteNodeLinkedListTest5() {
		// given
		int[] arr = {1,2,3,4,4,4,4,4};
		int[] arrExpected = {1,2,3};
    	ListNode head = createList(arr);

    	ListNode headExpected = createList(arrExpected);
    	
    	// when
        Solution sl = new Solution();
        head = sl.deleteDuplicates(head);
        // then
        compareLists(head, headExpected);
    }

				
	private void compareLists(ListNode head, ListNode headExpected) {
		Assert.assertTrue("Checking if both lists heads are null OR not null", !(head == null ^ headExpected == null));
        
        while(head!=null) {
        	Assert.assertTrue("Checking if both lists elements are not null -> same length", head!=null && headExpected!=null);
        	Assert.assertEquals("Checking values in both lists are the same", head.val, headExpected.val);
        	head = head.next;
        	headExpected = headExpected.next;
        }
	}

	private ListNode createList(int[] arr) {
		if (arr==null || arr.length==0) return null;
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
		return head;
	}
	
}
