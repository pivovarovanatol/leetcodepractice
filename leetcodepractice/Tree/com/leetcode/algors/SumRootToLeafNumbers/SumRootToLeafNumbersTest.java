package com.leetcode.algors.SumRootToLeafNumbers;

import org.junit.Test;
import org.junit.Assert;

public class SumRootToLeafNumbersTest {

	@Test
	public void sumRootToLeafNumbersSimpleCaseTest() {
		// given
		int[] arr = {1,2,3};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(root, arr, 0);
		
		// when
		Solution sl = new Solution();
		int actual = sl.sumNumbers(root);
		int expected = 25;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void sumRootToLeafNumbersEmptyTreeTest() {
		// given
		TreeNode root = null;
		
		// when
		Solution sl = new Solution();
		int actual = sl.sumNumbers(root);
		int expected = 0;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void sumRootToLeafNumbersBiggerTreeTest() {
		// given
		int[] arr = {4,9,0,5,1};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(root, arr, 0);
		
		// when
		Solution sl = new Solution();
		int actual = sl.sumNumbers(root);
		int expected = 1026;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
}
