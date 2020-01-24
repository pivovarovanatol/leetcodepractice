package com.leetcode.algors.OptimalDivision;

import org.junit.Assert;
import org.junit.Test;


public class OptimalDivisionTest {

	@Test
	public void optimalDivisionTestTwoNumbers() {
		// given
		int[] nums = {3,2};
		Solution sl = new Solution();

		// when
		String actual = sl.optimalDivision(nums);
		String expected = "3/2";

		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void optimalDivisionTestRegularCase() {
		// given
		int[] nums = {1000,100,10,2};
		Solution sl = new Solution();

		// when
		String actual = sl.optimalDivision(nums);
		String expected = "1000/(100/10/2)";

		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void optimalDivisionTestLongAray() {
		// given
		int[] nums = {10,2,40,400,5};
		Solution sl = new Solution();

		// when
		String actual = sl.optimalDivision(nums);
		String expected = "10/(2/40/400/5)";

		//then
		Assert.assertEquals(expected, actual);
	}
	
	
	

}
