package com.leetcode.algors.SortCharactersByFrequency;
// https://leetcode.com/problems/sort-characters-by-frequency/

import org.junit.Assert;
import org.junit.Test;

public class SortCharactersByFrequencyTest {
	
	Solution sl;
	
	public SortCharactersByFrequencyTest(){
		sl = new Solution();
	}
	
	@Test
	public void SortCharactersByFrequencyCase1(){
		// given
		String input = "tree";

		// when
		String result = sl.frequencySort(input);

		// then
		String expected = "eert";
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void SortCharactersByFrequencyCase2(){
		// given
		String input = "cccaaa";

		// when
		String result = sl.frequencySort(input);

		// then
		String expected = "aaaccc";
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void SortCharactersByFrequencyCase3(){
		// given
		String input = "Aabb";

		// when
		String result = sl.frequencySort(input);

		// then
		String expected = "bbAa";
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}


    
}
