package com.leetcode.algors.GoogleCanTrransform;

import org.junit.Assert;
import org.junit.Test;

public class CanTransformTest {

	@Test
	public void testCase1() {
		Solution sl = new Solution();
		String source = "ab";
		String destination = "aa";
		
		boolean actual = sl.canTransform(source, destination);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase2() {
		Solution sl = new Solution();
		String source = "abca";
		String destination = "dced";
		
		boolean actual = sl.canTransform(source, destination);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCase3() {
		Solution sl = new Solution();
		String source = "abcdefghijklmnopqrstuvwxyz";
		String destination = "bcdefghijklmnopqrstuvwxyza";
		
		boolean actual = sl.canTransform(source, destination);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCase4() {
		Solution sl = new Solution();
		String source = "aa";
		String destination = "cd";
		
		boolean actual = sl.canTransform(source, destination);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase5() {
		Solution sl = new Solution();
		String source = "abcdefghijklmnopqrstuvwxyz";
		String destination = "bbcdefghijklmnopqrstuvwxyz";
		
		boolean actual = sl.canTransform(source, destination);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	
	
}
