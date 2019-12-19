package com.leetcode.algors.DegreeOfAnArray;
//https://leetcode.com/problems/degree-of-an-array/

import org.junit.Assert;
import org.junit.Test;

public class DegreeOfAnArrayTest {
	
	@Test
	public void emptyArrayTest(){
		// given
		int[] arr = {};
		Solution sl = new Solution();

		// when
		int result = sl.findShortestSubArray(arr);		

		// then
		int expected = 1;
		Assert.assertEquals(expected, result);
	}

			
	@Test
	public void arrayWithOneValueTest(){
		// given
		int[] arr = {1};
		Solution sl = new Solution();

		// when
		int result = sl.findShortestSubArray(arr);		

		// then
		int expected = 1;
		Assert.assertEquals(expected, result);
	}

	@Test
	public void twoSameValuesTest(){
		// given
		int[] arr = {1,1};
		Solution sl = new Solution();

		// when
		int result = sl.findShortestSubArray(arr);		

		// then
		int expected = 2;
		Assert.assertEquals(expected, result);
	}

	
	@Test
	public void twoDifferentValuesTest(){
		// given
		int[] arr = {1,2};
		Solution sl = new Solution();

		// when
		int result = sl.findShortestSubArray(arr);		

		// then
		int expected = 1;
		Assert.assertEquals(expected, result);
	}

	@Test
	public void regularArrayTest(){
		// given
		int[] arr = {1,2,2,3,1,4,2};
		Solution sl = new Solution();

		// when
		int result = sl.findShortestSubArray(arr);		

		// then
		int expected = 6;
		Assert.assertEquals(expected, result);
	}

	
	
	
}
