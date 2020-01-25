package com.leetcode.algors.MergeKSortedLists;
// https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.*;

class Solution {
	
	
	
	// from discussions: Merge sort for K-lists with recursion. 4ms (<78%)
    public ListNode mergeKLists(ListNode[] lists) {
        //edge case []
        if (lists.length == 0) return null;
        return partition(lists, 0, lists.length-1);
    }
    
    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        
        // start will always be less than or equal to end
        int mid = (start + end) / 2;
        ListNode l1 = partition(lists, start, mid);
        ListNode l2 = partition(lists, mid+1, end);
        return mergeTwo(l1, l2);
    }
    
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l1, l2.next);
            return l2;
        }
    }
	
    
    // solved with Reverse Heap in 7ms(<32%) 45MB(<19%)
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (ListNode root : lists){
            while (root!=null){
                heap.add(root.val);
                root = root.next;
            }
        }
        ListNode root = null;
        while (!heap.isEmpty()){
            ListNode node = new ListNode(heap.remove());
            node.next = root;
            root = node;
        }
        return root;
    }
	
    // solved with Heap and Stack in 8ms(<26%) 45MB(<19%)
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (ListNode root : lists){
            while (root!=null){
                heap.add(root.val);
                root = root.next;
            }
        }
        Stack<ListNode> stack = new Stack<>();
        
        while (!heap.isEmpty()){
            ListNode node = new ListNode(heap.remove());
            stack.push(node);    
        }
        ListNode root = null;
        
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = root;
            root = node;
        }
        return root;
    }
}
