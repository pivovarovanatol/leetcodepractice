package com.leetcode.algors.Search2DMatrix;
//https://leetcode.com/problems/search-a-2d-matrix/

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
	
	@Test
	public void searchMatrixNotExists() {
		// Given
		int[][] matrix = {
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
				};
		
		// When
		boolean expected = false;
	    boolean result = new Solution().searchMatrix(matrix, 13);
		
		//Then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void searchMatrixExists() {
		// Given
		int[][] matrix = {
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
				};
		
		// When
		boolean expected = true;
	    boolean result = new Solution().searchMatrix(matrix, 30);
		
		//Then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void searchMatrixLessThanFirst() {
		// Given
		int[][] matrix = {
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
				};
		
		// When
		boolean expected = false;
	    boolean result = new Solution().searchMatrix(matrix, -1);
		
		//Then
		Assert.assertEquals(expected, result);
	}

	
	@Test
	public void searchMatrixMoreThanLast() {
		// Given
		int[][] matrix = {
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
				};
		
		// When
		boolean expected = false;
	    boolean result = new Solution().searchMatrix(matrix, 55);
		
		//Then
		Assert.assertEquals(expected, result);
	}

	
    
	
}
