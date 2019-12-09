package com.leetcode.algors.SortColors;

import org.junit.Assert;
import org.junit.Test;

public class SortColorsTest {

	
	@Test
	public void sortColorsCase1() {
		// given
		int[] input = {2,0,2,1,1,0}; 
		int[] expected = {0,0,1,1,2,2};
		
		//when
		Solution sl = new Solution();
		sl.sortColors(input);
		
		//then
		Assert.assertArrayEquals(expected, input);
		
	}
	
	
}
