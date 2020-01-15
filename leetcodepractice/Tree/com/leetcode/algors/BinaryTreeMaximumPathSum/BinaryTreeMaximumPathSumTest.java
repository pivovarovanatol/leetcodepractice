package com.leetcode.algors.BinaryTreeMaximumPathSum;

import org.junit.Test;
import org.junit.Assert;

public class BinaryTreeMaximumPathSumTest {
	
	@Test
	public void binaryTreeMaximumPathSumEmptyTreeTest() {
		// given
		TreeNode root = null;
		
		// when
		Solution sl = new Solution();
		int actual = sl.maxPathSum(root);
		int expected = 0;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void binaryTreeMaximumPathSumTest1() {
		// given
		int[] arr = {9,6,-3,-11111,-11111,-6,2,-11111,-11111,2,-11111,-6,-6,-6};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(root, arr, 0);
		
		// when
		Solution sl = new Solution();
		int actual = sl.maxPathSum(root);
		int expected = 15;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void binaryTreeMaximumPathSumTest2() {
		// given
		int[] arr = {5,4,8,11,-11111,13,4,7,2,-11111,-11111,-11111,1};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(root, arr, 0);
		
		// when
		Solution sl = new Solution();
		int actual = sl.maxPathSum(root);
		int expected = 49;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	
}
