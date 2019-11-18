package com.leetcode.algors.SortList;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
	
	
	
	
	
	// Bubble sort - too slow O(n^2). 
    public ListNode sortList2(ListNode head) {
        
        // Will try to sort it with a bubble sort for starters - but it's O(n^2)...
        if (head == null || head.next == null){
            return head;
        }
        
        boolean flipped = true;
        while (flipped){
            flipped = false;
            ListNode curr = head;
            ListNode prev = null;
            ListNode tmp = null;
            while (curr.next != null){
                if (curr.val > curr.next.val){
                    flipped = true;
                    if (prev != null){
                        prev.next = curr.next;
                    } else {
                        head = curr.next;
                    }
                    //System.out.println(curr.val + " is bigger than " + curr.next.val + " -> flipping...");

                    tmp = curr;
                    curr = curr.next;
                    tmp.next = curr.next;
                    curr.next = tmp;
                    //System.out.println("Now curr is " + curr.val + " and next is " + curr.next.val);
                }
                prev = curr;
                curr = curr.next;
            }
            //System.out.println("Finished cycle. Flipped is: " + flipped);
        }
        
       return head; 
    }
}

