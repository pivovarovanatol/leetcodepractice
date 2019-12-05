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

	@Test
	public void FairCandySwapCase2(){
		// given
		int[] arr1 = {1,1};
		int[] arr2 = {2,2};
		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		

		// then
		int[] expected = {1,2};
		Assert.assertArrayEquals(expected, result);
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
	}

	@Test
	public void FairCandySwapCase3(){
		// given
		int[] arr1 = {1,2};
		int[] arr2 = {2,3};
		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		

		// then
		int[] expected = {1,2};
		Assert.assertArrayEquals(expected, result);
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
	}

	@Test
	public void FairCandySwapCase4(){
		// given
		int[] arr1 = {1,2,5};
		int[] arr2 = {2,4};
		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		

		// then
		int[] expected = {5,4};
		Assert.assertArrayEquals(expected, result);
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
	}

	@Test
	public void FairCandySwapCase5(){
		// given
		int[] arr1 = {35,17,4,24,10};
		int[] arr2 = {63,21};
		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		

		// then
		int[] expected = {24,21};
		Assert.assertArrayEquals(expected, result);
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
	}
	
	@Test
	public void FairCandySwapCase6(){
		// given
		int[] arr1 = {1,17,14,1,16};
		int[] arr2 = {26,11};
		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		

		// then
		int[] expected = {17,11};
		Assert.assertArrayEquals(expected, result);
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
	}
		
	@Test
	public void FairCandySwapCase7(){
		// given
		int[] arr1 = {8,73,2,86,32};
		int[] arr2 = {56,5,67,100,31};
		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		

		// then
		int[] expected = {2,31};
		Assert.assertArrayEquals(expected, result);
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
	}
			
	@Test
	public void FairCandySwapCase8(){
		// given
		int[] arr1 = {32,39,8,41,9,2,24,33,32,25,10,29,24,1,14,20,37,49,49,29};
		int[] arr2 = {36,86,80,97,26,100,60,65,24,93};
		Solution sl = new Solution();

		// when
		int[] result = sl.fairCandySwap(arr1, arr2);		

		// then
		int[] expected = {20,100};
		Assert.assertArrayEquals(expected, result);
		//System.out.println(result[0] + " " + result[1]);
		//System.out.print(" ");
	}
			
	
}
