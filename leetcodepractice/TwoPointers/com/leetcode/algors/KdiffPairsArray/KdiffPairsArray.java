package com.leetcode.algors.KdiffPairsArray;

import org.junit.Assert;
import org.junit.Test;

public class KdiffPairsArray {

	
	@Test
	public void findKDiffPairsCase1() {
		// given
		int[] nums = {3, 1, 4, 1, 5};
		int k=2;

		
		//when
		Solution sl = new Solution();
		int actual = sl.findPairs(nums, k);
		int expected=2;
		
		//then
		Assert.assertEquals(expected, actual);
		
	}
	
	
}
