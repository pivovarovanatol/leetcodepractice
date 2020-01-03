package com.leetcode.algors.LCAofBinarySearchTree;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import org.junit.Assert;
import org.junit.Test;


public class LCAofBinarySearchTreeTest {

	@Test
	public void testCase1() {
		// Having
		int[] arr = {6,2,8,0,4,7,9,-1,-1,3,5};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(arr, root, 0);
		TreeNode p = Start.findNodeByValue(root, 2);
		TreeNode q = Start.findNodeByValue(root, 8);
				
		// When
		Solution sl = new Solution();
		TreeNode lca = sl.lowestCommonAncestor(root, p, q);
		int actual = lca.val;
		int expected = 6;
		// Then
		Assert.assertEquals(expected, actual);
		
	}

	@Test
	public void testCase2() {
		// Having
		int[] arr = {6,2,8,0,4,7,9,-1,-1,3,5};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(arr, root, 0);
		TreeNode p = Start.findNodeByValue(root, 2);
		TreeNode q = Start.findNodeByValue(root, 4);
				
		// When
		Solution sl = new Solution();
		TreeNode lca = sl.lowestCommonAncestor(root, p, q);
		int actual = lca.val;
		int expected = 2;
		// Then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase3() {
		// Having
		int[] arr = {2,1,3};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(arr, root, 0);
		TreeNode p = Start.findNodeByValue(root, 3);
		TreeNode q = Start.findNodeByValue(root, 1);
				
		// When
		Solution sl = new Solution();
		TreeNode lca = sl.lowestCommonAncestor(root, p, q);
		int actual = lca.val;
		int expected = 2;
		// Then
		Assert.assertEquals(expected, actual);
	}
	
	
}
