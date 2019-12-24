package com.leetcode.algors.ConvertBinaryLinkedListToInteger;
//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
    	int[] arr = {1,0,0,1,1,1};
    	ListNode head = new ListNode(arr[0]);
    	ListNode curr = head;
    	ListNode node = null;
    	
    	for (int i=1;i<arr.length;i++) {
    		ListNode tmp= new ListNode(arr[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}
    	
        Solution sl = new Solution();
        int result = sl.getDecimalValue(head);
        String str = Arrays
                .stream(arr)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a.concat(b))
                .get();
        System.out.println("Expected result: " + Integer.parseInt(str, 2));
        System.out.println("Actual result: " + result);

    }
}