package com.leetcode.algors.MiddleLinkedList;
//https://leetcode.com/problems/middle-of-the-linked-list/

import org.junit.Assert;
import org.junit.Test;

public class MiddleLinkedListTest {

	@Test
	public void deleteNodeLinkedListTest() {
		// Given
    	int[] arr = {1,2,3,4,5,6,7,8,9};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	ListNode node = null;
    	int middle = arr.length/2;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		if (i==middle) {
    			node = tmp;
    		}
    		curr.next = tmp;
    		curr = tmp;
    	}

    	// When
        Solution sl = new Solution();
        ListNode midNode = sl.middleNode(head);
        
        // then 
        while (node!=null && midNode!=null) {
        	Assert.assertEquals("Comparing elements values for two lists: ", midNode.val, node.val);
        	midNode = midNode.next;
        	node = node.next;
        }
        Assert.assertEquals("Check if the Expected List is emty", true,  node==null);
        Assert.assertEquals("Check if the Actual List is emty", true,  midNode==null);
	}
	
}
