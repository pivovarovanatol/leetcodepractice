package com.leetcode.algors.FairCandySwap;

import org.junit.Assert;
import org.junit.Test;

public class FairCandySwapTest {
	
	@Test
	public void FairCandySwapCase1(){
		// given
		int[] arr1 = {2};
		int[] arr2 = {1,3};

		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		
		
		// then
		int[] expected = {2,3};
		
		Assert.assertArrayEquals(expected, result);
		
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
		
	}
}
