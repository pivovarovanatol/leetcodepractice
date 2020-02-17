package com.leetcode.algors.KthSmallestPrimeFraction;

import org.junit.Assert;
import org.junit.Test;

public class KthSmallestPrimeFractionTest {

	@Test
	public void testKthSmallestPrimeFraction() {
		// having
		int[] nums = {1,2,3,5};
		int k = 3;
		
		// when
		Solution sl = new Solution();
		int[] actual = sl.kthSmallestPrimeFraction2(nums, k);
		int[] expected = {2,5};

		// then
		//System.out.println(result[0]);
		//System.out.println(result[1]);
		Assert.assertEquals("Checking the output length:" ,expected.length, actual.length);
		Assert.assertEquals("Checking first element: ", expected[0], actual[0]);
		Assert.assertEquals("Checking second element: ", expected[1], actual[1]);
	}
	
	
	
	
}
