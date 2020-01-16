package com.leetcode.algors.KthSmallestElementInBST;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class KthSmallestElementInBSTTest {
	
	@Test
	public void binaryTreePreorderTraversalSimpleTest() {
		// given
		int[] arr = {1,-11111,2,-11111,-11111,3,-11111,-11111};
		TreeNode root = new TreeNode(arr[0]);
		root = Start.insertLevelOrder(root, arr, 0);
		int k=1;
		
		// when
		Solution sl = new Solution();
		int actual = sl.kthSmallest(root, k);
		int expected = 1;

		// then
		Assert.assertEquals("Elements of the lists are different: ", expected, actual);
	}


}
