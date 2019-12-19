package com.leetcode.algors.OneBitAndTwoBitCharacters;
//https://leetcode.com/problems/degree-of-an-array/

import org.junit.Assert;
import org.junit.Test;

public class OneBitAndTwoBitCharacterTest {
	
	@Test
	public void emptyArrayTest(){
		// given
		int[] arr = {};
		Solution sl = new Solution();

		// when
		boolean result = sl.isOneBitCharacter(arr);		

		// then
		boolean expected = false;
		Assert.assertEquals(expected, result);
	}

	@Test
	public void oneSymbolArrayTest(){
		// given
		int[] arr = {0};
		Solution sl = new Solution();

		// when
		boolean result = sl.isOneBitCharacter(arr);		

		// then
		boolean expected = true;
		Assert.assertEquals(expected, result);
	}

	@Test
	public void twoSymbolArrayTest(){
		// given
		int[] arr = {1, 0};
		Solution sl = new Solution();

		// when
		boolean result = sl.isOneBitCharacter(arr);		

		// then
		boolean expected = false;
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void twoSymbolTrueArrayTest(){
		// given
		int[] arr = {0, 0};
		Solution sl = new Solution();

		// when
		boolean result = sl.isOneBitCharacter(arr);		

		// then
		boolean expected = true;
		Assert.assertEquals(expected, result);
	}
	

	@Test
	public void threeSymbolArrayTest(){
		// given
		int[] arr = {1, 0, 0};
		Solution sl = new Solution();

		// when
		boolean result = sl.isOneBitCharacter(arr);		

		// then
		boolean expected = true;
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void regularArrayTest(){
		// given
		int[] arr = {1, 1, 1, 0};
		Solution sl = new Solution();

		// when
		boolean result = sl.isOneBitCharacter(arr);		

		// then
		boolean expected = false;
		Assert.assertEquals(expected, result);
	}
	
	
	
}
