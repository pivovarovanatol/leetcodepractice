package com.leetcode.algors.PerfectSquares;

import org.junit.Assert;
import org.junit.Test;

public class PerfectSquaresTest {

	@Test
	public void maximalSquareCase1() {
		// Given
		int n = 12;
		
		// When
		Solution sl = new Solution();
		int result = sl.numSquares(n);
		
		int expected = 3;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	

	@Test
	public void maximalSquareCase2() {
		// Given
		int n = 13;
		
		// When
		Solution sl = new Solution();
		int result = sl.numSquares(n);
		
		int expected = 2;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	@Test
	public void maximalSquareCase3() {
		// Given
		int n = 90;
		
		// When
		Solution sl = new Solution();
		int result = sl.numSquares(n);
		
		int expected = 2;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	@Test
	public void maximalSquareCase4() {
		// Given
		int n = 9999;
		
		// When
		Solution sl = new Solution();
		int result = sl.numSquares(n);
		
		int expected = 4;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	
	
}
