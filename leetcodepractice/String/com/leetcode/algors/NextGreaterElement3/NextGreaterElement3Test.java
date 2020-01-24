package com.leetcode.algors.NextGreaterElement3;

import org.junit.Assert;
import org.junit.Test;


public class NextGreaterElement3Test {

	@Test
	public void nextGreaterElement3TestRandomNumber() {
		// given
		Solution sl = new Solution();

		// when
		int actual = sl.nextGreaterElement(12443322);
		int expected = 13222344;

		//then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void nextGreaterElement3TestSmallNumberPositive() {
		// given
		Solution sl = new Solution();

		// when
		int actual = sl.nextGreaterElement(12);
		int expected = 21;

		//then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void nextGreaterElement3TestSmallNumberNegative() {
		// given
		Solution sl = new Solution();

		// when
		int actual = sl.nextGreaterElement(21);
		int expected = -1;

		//then
		Assert.assertEquals(expected, actual);
	}
	

	@Test
	public void nextGreaterElement3TestHugeNumber() {
		// given
		Solution sl = new Solution();

		// when
		int actual = sl.nextGreaterElement(1800000000);
		int expected = -1;

		//then
		Assert.assertEquals(expected, actual);
	}
	

}
