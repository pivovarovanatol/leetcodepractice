package com.leetcode.algors.HammingDistance;
// https://leetcode.com/problems/hamming-distance/

import org.junit.Assert;
import org.junit.Test;

public class HammingDistanceTest {

	
	@Test 
	public void twoSimpleNumbersTest() {
		// given
		int x = 1;
		int y = 4;
		
		// when
		Solution sl = new Solution(); 
		int expected = 2;
		int actual = sl.hammingDistance(x, y);
		
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void justOneDifferenceTest() {
		// given
		int x = 7;
		int y = 6;
		
		// when
		Solution sl = new Solution(); 
		int expected = 1;
		int actual = sl.hammingDistance(x, y);
		
		// then
		Assert.assertEquals(expected, actual);
	}

		
	@Test 
	public void zeroToEigthTest() {
		// given
		int x = 0;
		int y = 8;
		
		// when
		Solution sl = new Solution(); 
		int expected = 1;
		int actual = sl.hammingDistance(x, y);
		
		// then
		Assert.assertEquals(expected, actual);
	}

		
		
	@Test 
	public void bigNumbersTest() {
		// given
		int x = 124312;
		int y = 435327;
		
		// when
		Solution sl = new Solution(); 
		int expected = 11;
		int actual = sl.hammingDistance(x, y);
		
		// then
		Assert.assertEquals(expected, actual);
	}

		
			
	
}
