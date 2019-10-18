package com.leetcode.algors.IntersectionOfTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	// 1ms (faster than 99%!) 39MB
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //ListNode tmp = headA;
    	ListNode cursor1 = headA;
    	ListNode tailA = cursor1;

    	if (headA == null || headB==null) {
    		return null;
    	}
    	
    	int count=0;
    	while (cursor1!=null) {
    		tailA = cursor1;
    		cursor1 = cursor1.next;
    		count++;
    	}
    	tailA.next = headA;
    	
    	cursor1 = headB;

    	for (int i=0;i<count;i++) {
    		if (cursor1 == null) {
    			tailA.next = null;
        		return null;
        	}
    		cursor1 = cursor1.next;
    	}
    	
    	ListNode cursor2 = headB;
    	
    	while(true) {
    		if (cursor1 == null || cursor2==null) {
    			tailA.next = null;
        		return null;
        	}
    		
    		if (cursor1 == cursor2) {
    			tailA.next = null;
    			return  cursor1;
    		}
    		cursor1 = cursor1.next;
    		cursor2 = cursor2.next;
    	}

    }

    // 8ms 40MB
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tmp = headA;
        Set<ListNode> nodes = new HashSet<ListNode>();
        
    	while (tmp!=null) {
    		nodes.add(tmp);
    		tmp = tmp.next;
    	}
    	
    	tmp = headB;
    	
    	while (tmp!=null) {
    		if (nodes.contains(tmp)) {
    			return tmp;
    		}
    		tmp = tmp.next;
    	}
    	
    	return null;
    }
    
    
    


}

