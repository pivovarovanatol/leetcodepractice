package com.leetcode.algors.MaximalSquare;

import org.junit.Assert;
import org.junit.Test;

public class MaximalSquareTest {

	@Test
	public void maximalSquareCase1() {
		// Given
		char[][] arr = {
				{'0', '0', '0', '0', '0'},
				{'0', '0', '1', '1', '1'},
				{'0', '0', '1', '1', '1'},
				{'0', '0', '0', '0', '0'},
				{'0', '0', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
			};

		// When
		Solution sl = new Solution();
		int result = sl.maximalSquare(arr);
		
		int expected = 4;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	@Test
	public void maximalSquareCase2() {
		// Given
		char[][] arr = {{'1','0','1','0','0'},
						{'1','0','1','1','1'},
						{'1','1','1','1','1'},
						{'1','0','0','1','0'}};

		// When
		Solution sl = new Solution();
		int result = sl.maximalSquare(arr);
		
		int expected = 4;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	@Test
	public void maximalSquareCase3() {
		// Given
		char[][] arr = {{'1','1','1','1','1','1','1','1'},
						{'1','1','1','1','1','1','1','0'},
						{'1','1','1','1','1','1','1','0'},
						{'1','1','1','1','1','0','0','0'},
						{'0','1','1','1','1','0','0','0'}
						};

		// When
		Solution sl = new Solution();
		int result = sl.maximalSquare(arr);
		
		int expected = 16;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	@Test
	public void maximalSquareCase4() {
		// Given
		char[][] arr = {{'0','0','0','1'},
						{'1','1','0','1'},
						{'1','1','1','1'},
						{'0','1','1','1'},
						{'0','1','1','1'}
						};

		// When
		Solution sl = new Solution();
		int result = sl.maximalSquare(arr);
		
		int expected = 9;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	@Test
	public void maximalSquareCase5() {
		// Given
		char[][] arr = {{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','0','0','1','1','1','1','1','1','1','1','0','0','1','1','1','0','1','1','1','1','1','1','1','1'},
						{'1','1','1','1','0','1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'0','1','1','1','1','0','1','0','1','1','1','1','1','1','0','1','1','0','1','1','0','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'0','1','0','1','1','0','1','0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','0','1','1','0','1','1','1','1','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0','1','1','0','0','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'1','1','1','1','1','1','1','1','1','0','1','1','0','1','0','1','1','1','1','1','1','1','1','1','1','1','0','1','0','1','1','1','1','1','1','0','1','1','1','1'},
						{'0','1','1','0','1','1','0','1','0','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0','1','0','1'},
						{'0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','0','0','1','1','0','0','1','1','0','1','1','0','1','0','1','0','1'},
						{'1','1','1','1','0','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','0','1','1','1','1','0','1','0','1','1','0','1','0','1','1'},
						{'1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1','1'},
						{'1','1','1','0','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'1','0','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1','1','1','0','0','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'0','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','1','1','0','1','1','1','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0','1','1'},
						{'1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','0','1','0','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1'},
						{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1'},
						{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','0','1','1','1','1','1','1','0','0','1','1','1','1','1'},
						{'1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0','1','1','1'},
						{'1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','0','1','1','1','1','1','0','0','1','0','1','1','1','1','1','0','1','1','1','1','1','1'},
						{'1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','0','1','1','1','1','1','0','1','1','1','1','1','0','1','1','0','1','1'},
						{'1','1','0','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
						{'1','1','1','1','1','0','1','0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','0','1','0','1','1','1','0','0','1','1','1','1','1','1','1','1'},
						{'1','1','1','0','0','1','0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1','0','1','1','1','1','0','1','1','1','1','1','0','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1'},
						{'1','1','1','1','1','1','1','0','1','1','1','1','1','1','0','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
						{'1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','0','1','1','1','0','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0','1','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','0','1','0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','0','1','1','1','1','1','1','1','1','1','0','1','1','1','0','1'},
						{'1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','0','1','1','1','0','1','1','0','1','1'},
						{'1','1','1','1','0','1','1','0','1','1','1','1','1','1','0','1','1','0','1','1','0','1','1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'1','1','0','0','0','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1'},
						{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
						{'0','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','0','1','0','1','0','1','1','0','1','1','1','1','1','1','1','1'},
						{'1','0','1','1','0','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1'},
						{'1','0','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1'},
						{'0','1','1','1','1','0','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
						{'0','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1','0','1','1','1','1','1','1','1','1','1','1'},
						{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','0','1','1','1','1','0','1','1','1','1','1','1','0','1','0','1','1','0','0','1','1','1','1','0','1','1'},
						{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','0','1','1','1','0'},
						{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0','0','1','1','1','1'},
						{'1','1','0','1','1','0','1','1','1','1','1','1','0','1','0','1','1','1','1','1','0','1','1','1','1','1','1','1','1','0','0','1','1','1','0','1','0','1','0','0'},
						{'0','1','1','0','1','1','1','1','1','1','1','0','0','1','1','1','1','1','0','0','1','0','1','1','1','1','1','0','1','1','1','0','1','1','0','1','1','1','0','1'}
						};

		// When
		Solution sl = new Solution();
		int result = sl.maximalSquare(arr);
		
		int expected = 64;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	

	
	
}
