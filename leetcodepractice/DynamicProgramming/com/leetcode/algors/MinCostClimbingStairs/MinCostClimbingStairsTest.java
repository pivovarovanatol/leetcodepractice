package com.leetcode.algors.MinCostClimbingStairs;

import org.junit.Assert;
import org.junit.Test;

public class MinCostClimbingStairsTest {

	@Test
	public void minCostClimbingStairsCase1() {
		// Given
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		
		// When
		Solution sl = new Solution();
		int result = sl.minCostClimbingStairs(cost);
		int expected = 6;
		
		// Then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void minCostClimbingStairsCase2() {
		// Given
		int[] cost = {10, 15, 20};
		
		// When
		Solution sl = new Solution();
		int result = sl.minCostClimbingStairs(cost);
		int expected = 15;
		
		// Then
		Assert.assertEquals(expected, result);
	}

		
	
}
