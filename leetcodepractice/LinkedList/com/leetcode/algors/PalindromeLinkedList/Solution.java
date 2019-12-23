package com.leetcode.algors.PalindromeLinkedList;
// https://leetcode.com/problems/palindrome-linked-list/


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // Solved with Stack and Two pointers - fast and slow. 1ms(<99.5%) 40MB(<99%)
    public boolean isPalindrome(ListNode head) {
        // Get the middle of the linked list with Stack and two pointers  - fast and slow. All the way to the middle - push elements to the stack. 
        // Once found the middle - progress forward and compare each element with the pop from the stack
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        stack.push(slow);
        boolean odd = false;
        
        while (fast != null){
            slow = slow.next;
            stack.push(slow);
            if (fast.next == null){
                odd = true;
                break;
            } 
            if (fast.next.next == null){
                odd = false;
                break;
            }
            fast = fast.next.next;
        }
        
        //System.out.println(slow.val + " | " + count + " is Odd? " + odd);
        if (odd){
            stack.pop();
        }
        slow = slow.next;
        
        while (stack.size() > 0){
            ListNode tmp = stack.pop();
            //System.out.println("Comparing " + tmp.val + " with " + slow.val);
            if (tmp.val != slow.val){
                return false;
            } else {
                slow = slow.next;
            }
        }
        return true;
    }
}

