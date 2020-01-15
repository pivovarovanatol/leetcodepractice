package com.leetcode.algors.PathSum2;

import org.junit.Test;
import java.util.List;
import org.junit.Assert;

public class PathSum2Test {
	
	@Test
	public void binaryTreeMaximumPathSumEmptyTreeTest() {
		// given
		TreeNode root = null;
		int sum = 0;
		
		// when
		Solution sl = new Solution();
		List<List<Integer>> actual = sl.pathSum(root, sum);
		List<List<Integer>> expected = null;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
}
