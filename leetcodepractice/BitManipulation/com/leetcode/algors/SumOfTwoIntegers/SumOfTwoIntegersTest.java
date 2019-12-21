package com.leetcode.algors.SumOfTwoIntegers;

import org.junit.Assert;
import org.junit.Test;

public class SumOfTwoIntegersTest {

	@Test
	public void testSumTwoPositive() {
		// Given
		Solution sl = new Solution();
		
		// When
		int expected = 2 + 3;
		int actual = sl.getSum(2, 3);
		
		// Then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSumTwoMediumPositive() {
		// Given
		Solution sl = new Solution();
		
		// When
		int expected = 22 + 33;
		int actual = sl.getSum(22, 33);
		
		// Then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testSumNegativeAndPositive() {
		// Given
		Solution sl = new Solution();
		
		// When
		int expected = -1 + 5;
		int actual = sl.getSum(-1, 5);
		
		// Then
		Assert.assertEquals(expected, actual);
	}
	


}
