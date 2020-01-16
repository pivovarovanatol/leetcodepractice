package com.leetcode.algors.BinaryTreePreorderTraversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class BinaryTreePreorderTraversalTest {
	
	@Test
	public void binaryTreePreorderTraversalEmptyTreeTest() {
		// given
		TreeNode root = null;
		
		// when
		Solution sl = new Solution();
		List<Integer> actual = sl.preorderTraversal(root);
		List<Integer> expected = new ArrayList<>();;
		
		// then
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void binaryTreePreorderTraversalSimpleTest() {
		// given
		int[] arr = {1,-11111,2,-11111,-11111,3,-11111,-11111};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(root, arr, 0);
		
		// when
		Solution sl = new Solution();
		List<Integer> actual = sl.preorderTraversal(root);
		int[] tmp = {1,2,3};
		List<Integer> expected = new ArrayList<Integer>();
		for (int e : tmp) {
			expected.add(e);
		}
		
		// then
		
		Assert.assertEquals("Size of the lists are different!", actual.size(), expected.size());
		
		for (int i=0;i<expected.size();i++) {
			Assert.assertEquals("Elements of the lists are different: ", expected.get(i), actual.get(i));
		}
	}


}
