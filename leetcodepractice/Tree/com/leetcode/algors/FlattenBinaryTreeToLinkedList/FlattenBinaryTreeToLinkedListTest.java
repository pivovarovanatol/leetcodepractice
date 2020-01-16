package com.leetcode.algors.FlattenBinaryTreeToLinkedList;

import org.junit.Test;
import java.util.List;
import org.junit.Assert;

public class FlattenBinaryTreeToLinkedListTest {
	
	@Test
	public void flattenBinaryTreeToLinkedListTest1() {
		// given
		TreeNode root = null;
		int sum = 0;
		
		// when
		Solution sl = new Solution();
		sl.flatten(root);
		List<List<Integer>> expected = null;
		
		// then
		Assert.assertEquals(expected, expected);
	}
	
}
