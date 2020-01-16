package com.leetcode.algors.BinaryTreeLevelOrderTraversal;
// https://leetcode.com/problems/binary-tree-level-order-traversal/


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class BinaryTreeLevelOrderTraversalTest {
	
	@Test
	public void binaryTreePreorderTraversalSimpleTest() {
		// given
		int[] arr = {1,-11111,2,-11111,-11111,3,-11111,-11111};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(root, arr, 0);
		int k=1;
		
		// when
		Solution sl = new Solution();
		List<List<Integer>> actual = sl.levelOrder(root);
		List<List<Integer>> expected = new ArrayList<>();;

		// then
		Assert.assertEquals("Elements of the lists are different: ", expected, actual);
	}


}
