package com.leetcode.algors.SearchInRotatedSortedArray2;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest2 {

	@Test 
	public void searchInRotatedSortedArrayCase1() {
		// given
		int[] nums = {15,16,19,20,25,1,3,4,5,7,10,14};
		int target = 25;
		
		// when
		boolean actual = new Solution().search(nums, target);
		boolean expected = true;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	

	@Test 
	public void searchInRotatedSortedArrayCase2() {
		// given
		int[] nums = {1,3,1,1,1,1};
		int target = 3;
		
		// when
		boolean actual = new Solution().search(nums, target);
		boolean expected = true;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void searchInRotatedSortedArrayCase3() {
		// given
		int[] nums = {2,5,6,0,0,1,2};
		int target = 3;
		
		// when
		boolean actual = new Solution().search(nums, target);
		boolean expected = false;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	


}
