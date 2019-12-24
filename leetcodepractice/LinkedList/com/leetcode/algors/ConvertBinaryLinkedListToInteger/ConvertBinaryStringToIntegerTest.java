package com.leetcode.algors.ConvertBinaryLinkedListToInteger;
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ConvertBinaryStringToIntegerTest {

	@Test
	public void convertBinaryLinkedListToIntegerTest() {
		// Given
    	int[] arr = {1,0,0,1,1,1};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}

    	// When
        Solution sl = new Solution();
        int actual = sl.getDecimalValue(head);
        String str = Arrays
                .stream(arr)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a.concat(b))
                .get();
        int expected = Integer.parseInt(str, 2);

        // then 
        Assert.assertEquals("Check if the Expected is the same as actual", expected,  actual);
	}
	
	@Test
	public void convertEmptyBinaryLinkedListToIntegerTest() {
		// Given
    	int[] arr = {};
    	ListNode head = null;
    	ListNode curr = head;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}

    	// When
        Solution sl = new Solution();
        int actual = sl.getDecimalValue(head);
        int expected = 0;

        // then 
        Assert.assertEquals("Check if the Expected is the same as actual", expected,  actual);
	}
	
}
