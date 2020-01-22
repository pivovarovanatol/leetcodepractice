package com.leetcode.algors.SearchInRotatedSortedArray;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

	@Test 
	public void searchInRotatedSortedArrayCase1() {
		// given
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		
		// when
		int actual = new Solution().search(nums, target);
		int expected = 4;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void searchInRotatedSortedArrayCase2() {
		// given
		int[] nums = {4,5,6,7,0,1,2};
		int target = 3;
		
		// when
		int actual = new Solution().search(nums, target);
		int expected = -1;
		
		// then
		Assert.assertEquals(expected, actual);
	}
		
	@Test 
	public void searchInRotatedSortedArrayCase3() {
		// given
		int[] nums = {2,1};
		int target = 1;
		
		// when
		int actual = new Solution().search(nums, target);
		int expected = 1;
		
		// then
		Assert.assertEquals(expected, actual);
	}


	@Test 
	public void searchInRotatedSortedArrayCase4() {
		// given
		int[] nums = {8,9,10,1,2,3,4,5,6,7};
		int target = 5;
		
		// when
		int actual = new Solution().search(nums, target);
		int expected = 7;
		
		// then
		Assert.assertEquals(expected, actual);
	}




}
