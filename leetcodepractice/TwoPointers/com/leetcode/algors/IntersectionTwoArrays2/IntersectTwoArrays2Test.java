package com.leetcode.algors.IntersectionTwoArrays2;

import org.junit.Assert;
import org.junit.Test;

public class IntersectTwoArrays2Test {

	@Test
	public void intersectTwoArrays2Test1() {
		// given
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		
		//when
		Solution sl = new Solution();
		int[] actual = sl.intersect(nums1, nums2);
		int[] expected = {2,2};
		
		//then
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void intersectTwoArrays2Test2() {
		// given
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		//when
		Solution sl = new Solution();
		int[] actual = sl.intersect(nums1, nums2);
		int[] expected = {4,9};
		
		//then
		Assert.assertArrayEquals(expected, actual);
	}
	
	
}
