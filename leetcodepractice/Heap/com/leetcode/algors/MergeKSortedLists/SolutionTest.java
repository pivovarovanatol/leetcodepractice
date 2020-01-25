package com.leetcode.algors.MergeKSortedLists;
// https://leetcode.com/problems/last-stone-weight/

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
	
	@Test
	public void mergeKSortedListsCase1(){
		// given
		int[][] arr =  {{1,4,5},
				{1,3,4},
				{2,6,9}};
		ListNode[] lists = new ListNode[arr.length];
		Start.listFromArray(arr, lists);

		int[][] exp = {{1, 1, 2, 3, 4, 4, 5, 6, 9}};
		ListNode[] expected = new ListNode[1];
		Start.listFromArray(exp, expected);
		
		// when
		Solution sl = new Solution();
		ListNode actual = sl.mergeKLists(lists);
		ListNode given = expected[0];
		
		// then
		while (actual!=null) {
			Assert.assertEquals(actual.val, given.val);
			actual=actual.next;
			given=given.next;
		}
	}

    
}
