package com.leetcode.algors.CountSmallerNumbersAfterSelf;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Assert;

public class CountSmallerNumbersAfterSelfTest {
	
	@Test
	public void countSmallerNumbersAfterSelfCase1() {
		// having
		int[] nums = {5,2,6,1};
		int[] expected = {2,1,1,0};
		
		// when
		Solution sl = new Solution();
		List<Integer> actual = sl.countSmaller(nums);
		
		// then
		Assert.assertEquals("Comparing the size of the results: ", expected.length, actual.size());
		
		int i=0;
		for (int e : actual) {
			Assert.assertEquals("Comparing returned elements: ", expected[i], e);
			i++;
		}
	}

	@Test
	public void countSmallerNumbersAfterSelfCase2() {
		// having
		int[] nums = {2,0,1};
		int[] expected = {2,0,0};
		
		// when
		Solution sl = new Solution();
		List<Integer> actual = sl.countSmaller(nums);
		
		// then
		Assert.assertEquals("Comparing the size of the results: ", expected.length, actual.size());
		
		int i=0;
		for (int e : actual) {
			Assert.assertEquals("Comparing returned elements: ", expected[i], e);
			i++;
		}
	}
	
	@Test
	public void countSmallerNumbersAfterSelfCase3() {
		// having
		int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		int[] expected = {10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0};
		
		// when
		Solution sl = new Solution();
		List<Integer> actual = sl.countSmaller(nums);
		
		// then
		Assert.assertEquals("Comparing the size of the results: ", expected.length, actual.size());
		
		int i=0;
		for (int e : actual) {
			Assert.assertEquals("Comparing returned elements: ", expected[i], e);
			i++;
		}
	}



}
