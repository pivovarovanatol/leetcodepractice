package com.leetcode.algors.ValidSudoku;

import org.junit.Assert;
import org.junit.Test;

public class ValidSudokuTest {

	@Test
	public void validSudokuCase1() {
		// given
		char[][] input = {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		
		// when
		boolean expected = true;
		boolean result = new Solution().isValidSudoku(input);
		
		// then
		Assert.assertEquals(expected, result);
		
		
	}
	
	@Test
	public void validSudokuCase2() {
		// given
		char[][] input = {
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		
		// when
		boolean expected = false;
		boolean result = new Solution().isValidSudoku(input);
		
		// then
		Assert.assertEquals(expected, result);
		
		
	}
	
	
}
