package com.leetcode.algors.ConvertBinaryLinkedListToInteger;
//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	
	// Solved with shift and logical OR. 0ms(<100%) 34.3MB(<100%)
    public int getDecimalValue(ListNode head) {
    	
    	if (head==null) {
    		return 0;
    	}
        int num = 0;
        
        while (head != null){
            num = num << 1;
            num = num | head.val;
            head = head.next;
        }
        
        //System.out.println(Integer.toBinaryString(num));
        return num;
    }
}