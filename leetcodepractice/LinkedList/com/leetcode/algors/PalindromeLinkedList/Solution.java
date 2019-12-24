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
    
    // Solved. Found the middle by two pointers (fast+slow). Then moved forward and created reversed linked list and then moved from the initial head and compared with reversed one. 1ms(<99.55%) 39.5MB(<99%)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while (fast != null){
            slow = slow.next;
            if (fast.next == null){
                break;
            } 
            if (fast.next.next == null){
                break;
            }
            fast = fast.next.next;
        }
                
        ListNode front = head;
        ListNode back = reverse(slow.next);
        
        while (front != null && back != null){
            //System.out.println("Front is " + front.val + " Back is " + back.val);
            if (front.val != back.val){
                return false;
            } else {
                front = front.next;
                back = back.next;
            }
        }
        
        if (front == null && back != null){
            //System.out.println("Back is still not empty " + back.val);
            return false;
        }
        return true;
    }
    
    ListNode reverse(ListNode head){
    	ListNode curr = head;
    	ListNode next = head.next;
    	ListNode prev = null;
    	
    	while (next != null) {
        	curr.next = prev;
        	prev = curr;
        	curr = next;
        	next = next.next;
    	}
    	curr.next = prev;
        return curr;
    }

	
	
    // Solved with Stack and Two pointers - fast and slow. 1ms(<99.5%) 40MB(<99%)
    public boolean isPalindrome2(ListNode head) {
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

