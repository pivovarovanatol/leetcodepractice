package com.leetcode.algors.SortList;
// https://leetcode.com/problems/sort-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
MERGE SORT is ideal for sorting linked lists as it is a divide and conquer approach
and linked lists give O(1) perf in dividing and joining.

Merge sort is technically in-place as it keeps dividing the input into halves
till each half has a single element, and then merges by simply swapping larger
elements in the first half with smaller ones in the second half. With linked lists, 
you don't need to swap. You just add the smaller nodes before the larger
nodes to the merged list.
    
Note: This solution uses recursion so it is O(n) space. The question wants constant space.
For merge sort and O(nlgn) performance with linked lists, you either need 
an explicit stack or an implicit one provided by recursion.

I think what the question wants is you shouldn't copy the list in an array,
sort it via Arrays.sort() (or equivalent method in your language) 
and then create a new list from the sorted array.
*/
class Solution {
	
	
	// From discussion - using merge sort. O(nlogn). 4ms (<64%) 40MB(<89%). 
	public ListNode sortList(ListNode list) {
	    // Base case: An empty list or a 1 node list is already sorted.
	    if (list == null || list.next == null) return list;
	
	    // Recursive case: Keep dividing the list into equal halves
	    // until you hit the base case i.e. get a zero or 1-element list,
	    // which as mentioned earlier is already sorted. 
	    ListNode list1 = list;
	    ListNode list2 = secondHalfOf(list);
	
	    // We still don't have a single element list1. Keep dividing.
	    if (list1.next != null) 
	        list1 = sortList(list1);
	    
	    // We still don't have a zero or single element list2. Keep dividing.
	    if (list2 != null && list2.next != null) 
	        list2 = sortList(list2);
	    
	    /**
	     At this point, both list1 and list2 are SORTED. 
	     Merge them into a single list and return the merged list.
	     
	     Q: How did you assume that the lists are already sorted when we're here?
	     A: If we're here, it's because: 
	        a) Both are either zero or 1-element lists which by definition are already sorted
	        b) If they have more elements they must've been merged in the previous recursion.
	    */ 
	    return mergeSortedLists(list1, list2);
	}
	
	// Divides given NON-NULL list into 2 halves and returns the second half.
	private ListNode secondHalfOf(ListNode list) {
	    ListNode previous = null;
	    ListNode current  = list;
	    ListNode twoX     = list; // maintains a gap of 2 nodes from "previous" node.
	    
	    while (twoX != null) {
	        previous = current;
	        current  = current.next;
	        twoX     = twoX.next;
	        if (twoX != null) twoX = twoX.next;
	    }
	    
	    // IMPORTANT: The "Previous" node and NOT the "current" node is at the middle of list.
	    ListNode secondHalf = previous.next;
	    previous.next = null;
	    return secondHalf;
	}
	
	// Merges two SORTED lists into one. 
	private ListNode mergeSortedLists(ListNode l1, ListNode l2) {
	    if (l1 == null) return l2;
	    if (l2 == null) return l1;
	    
	    ListNode sentinel = new ListNode(-1); // Sentinel node to simplify code
	    ListNode current = sentinel;
	
	    while (l1 != null && l2 != null) {
	        if (l1.val <= l2.val) {
	            current.next = l1;
	            l1 = l1.next;
	        } else {
	            current.next = l2;
	            l2 = l2.next;
	        }
	
	        current = current.next;
	    }
	    
	    ListNode remaining = l1 != null ? l1 : l2;
	    while (remaining != null) {
	        current.next = remaining;
	        current      = current.next;
	        remaining    = remaining.next;
	    }
	    
	    return sentinel.next;
	}
	
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

