package com.leetcode.algors.DeleteNodeLinkedList;
// https://leetcode.com/problems/delete-node-in-a-linked-list/

import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeLinkedListTest {

	@Test
	public void deleteNodeLinkedListTest() {
		// Given
    	int[] arr1 = {1,2,3,4,5};
    	ListNode head1 = new ListNode(arr1[0]);
    	ListNode curr = head1;
    	ListNode node = null;
    	// Going to delete element with index 3 (val=4)
    	for (int i=1;i<arr1.length;i++) {
    		ListNode tmp= new ListNode(arr1[i]);
    		if (i==3) {
    			node = tmp;
    		}
    		curr.next = tmp;
    		curr = tmp;
    	}
    	
    	int[] arr2 = {1,2,3,5};
    	ListNode head2 = new ListNode(arr2[0]);
    	curr = head2;
    	for (int i=1;i<arr2.length;i++) {
    		ListNode tmp= new ListNode(arr2[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}

    	// When
        Solution sl = new Solution();
        sl.deleteNode(node);
        
        // then 
        while (head2!=null && head1!=null) {
        	Assert.assertEquals("Comparing elements values for two lists: ", head2.val, head1.val);
        	head2 = head2.next;
        	head1 = head1.next;
        }
        Assert.assertEquals("Check if the Expected List is emty", true,  head2==null);
        Assert.assertEquals("Check if the Actual List is emty", true,  head1==null);
	}
	
}
