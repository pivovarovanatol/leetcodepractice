package com.leetcode.algors.FindFirstAndLastPositionOfElementInSortedArray;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {
	
	@Test
	public void findFirstAndLastPositionOfElementInSortedArrayTest1() {
		int[] nums = {5,7,7,8,8,10};
		int target=7;
		int[] expected= {1,2};
		
		Solution sl = new Solution();
		int[] actual = sl.searchRange(nums, target);
		
		Assert.assertEquals(actual[0], expected[0]);
		Assert.assertEquals(actual[1], expected[1]);
	}

	@Test
	public void findFirstAndLastPositionOfElementInSortedArrayTestOneElement1() {
		int[] nums = {1};
		int target=2;
		int[] expected= {-1,-1};
		
		Solution sl = new Solution();
		int[] actual = sl.searchRange(nums, target);
		
		Assert.assertEquals(actual[0], expected[0]);
		Assert.assertEquals(actual[1], expected[1]);
	}
	
	@Test
	public void findFirstAndLastPositionOfElementInSortedArrayTestOneElement2() {
		int[] nums = {2};
		int target=2;
		int[] expected= {0,0};
		
		Solution sl = new Solution();
		int[] actual = sl.searchRange(nums, target);
		
		Assert.assertEquals(actual[0], expected[0]);
		Assert.assertEquals(actual[1], expected[1]);
	}
	

	@Test
	public void findFirstAndLastPositionOfElementInSortedArrayTestTwoElements() {
		int[] nums = {2,2};
		int target=2;
		int[] expected= {0,1};
		
		Solution sl = new Solution();
		int[] actual = sl.searchRange(nums, target);
		
		Assert.assertEquals(actual[0], expected[0]);
		Assert.assertEquals(actual[1], expected[1]);
	}
	
	@Test
	public void findFirstAndLastPositionOfElementInSortedArrayTestTwoElements2() {
		int[] nums = {2,2};
		int target=1;
		int[] expected= {-1,-1};
		
		Solution sl = new Solution();
		int[] actual = sl.searchRange(nums, target);
		
		Assert.assertEquals(actual[0], expected[0]);
		Assert.assertEquals(actual[1], expected[1]);
	}
	



}
