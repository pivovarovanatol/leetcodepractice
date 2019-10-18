package com.leetcode.algors.IntersectionOfTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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