package com.leetcode.algors.NextPermutation;

import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTest {

	@Test
	public void nextPermutationTest1() {
		int[] nums = {2,3,1};
		int[] expecteds = {3,1,2};
		int[] actuals = nums;
				
		Solution sl = new Solution();
		sl.nextPermutation(nums);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void nextPermutationTest2() {
		int[] nums = {1,2,3};
		int[] expecteds = {1,3,2};
		int[] actuals = nums;
				
		Solution sl = new Solution();
		sl.nextPermutation(nums);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void nextPermutationTest3() {
		int[] nums = {3,2,1};
		int[] expecteds = {1,2,3};
		int[] actuals = nums;
				
		Solution sl = new Solution();
		sl.nextPermutation(nums);
		Assert.assertArrayEquals(expecteds, actuals);
	}


	@Test
	public void nextPermutationTest4() {
		int[] nums = {1,1,5};
		int[] expecteds = {1,5,1};
		int[] actuals = nums;
				
		Solution sl = new Solution();
		sl.nextPermutation(nums);
		Assert.assertArrayEquals(expecteds, actuals);
	}



}
