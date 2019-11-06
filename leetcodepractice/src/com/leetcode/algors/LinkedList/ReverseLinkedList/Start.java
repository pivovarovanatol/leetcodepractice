package com.leetcode.algors.LinkedList.ReverseLinkedList;
// https://leetcode.com/problems/remove-linked-list-elements/

import java.io.IOException;

public class Start {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
        String line = "[1,2,3,4,5,6]";
            ListNode head = stringToListNode(line);
            int val = 6;
            
            ListNode ret = new Solution().reverseList(head);
            String out = listNodeToString(ret);
            System.out.print(out);
    }
}

/* 
 * 000001
 *   1111
 * 010000
 * 
 * 
 * */
