package com.leetcode.algors.ProductOfArrayExceptSelf;
// https://leetcode.com/problems/product-of-array-except-self/
	
import org.junit.Assert;
import org.junit.Test;

public class ProductExceptSelfTest {

	
	@Test
	public void productExceptSelfCase1() {
		// given
		int[] expected = {24,12,8,6};
		int[] input = {1,2,3,4};
		
		// when
		int[] result = new Solution().productExceptSelf(input);
		
		// then
		Assert.assertArrayEquals("Different array has been returned", expected, result);
	}

	
	@Test
	public void productExceptSelfCase2() {
		// given
		int[] expected = {0,1};
		int[] input = {1,0};
		
		// when
		int[] result = new Solution().productExceptSelf(input);
		
		// then
		Assert.assertArrayEquals("Different array has been returned", expected, result);
	}

	
		
	
}
