package com.leetcode.algors.CircularArrayLoop;

import org.junit.Assert;
import org.junit.Test;

public class CircularArrayLoopTest {

	@Test 
	public void circularArrayLoopCase1() {
		// having 
		int[] nums = {3,1,2}; // false
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = true;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void circularArrayLoopCase2() {
		// having 
		int[] nums = {-1,2}; // false
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = false;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test 
	public void circularArrayLoopCase3() {
		// having 
		int[] nums = {2,-1,1,2,2}; // true
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = true;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void circularArrayLoopCase4() {
		// having 
		int[] nums = {-1,-2,-3,-4,-5}; // false
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = false;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test 
	public void circularArrayLoopCase5() {
		// having 
		int[] nums = {-2,1,-1,-2,-2}; // false
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = false;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void circularArrayLoopCase6() {
		// having 
		int[] nums = {1,1}; // false
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = true;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void circularArrayLoopCase7() {
		// having 
		int[] nums = {1,2,3,4,5}; // false
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = true;
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void circularArrayLoopCase8() {
		// having 
		int[] nums = {2,2,2,2,2,4,7}; // false
		Solution sl = new Solution();
		
		// when
		boolean actual = sl.circularArrayLoop(nums);
		boolean expected = false;
		
		// then
		Assert.assertEquals(expected, actual);
	}


	
}
