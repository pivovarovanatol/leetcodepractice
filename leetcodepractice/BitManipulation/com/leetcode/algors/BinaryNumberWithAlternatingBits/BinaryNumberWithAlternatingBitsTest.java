package com.leetcode.algors.BinaryNumberWithAlternatingBits;
// https://leetcode.com/problems/hamming-distance/

import org.junit.Assert;
import org.junit.Test;

public class BinaryNumberWithAlternatingBitsTest {

	
	@Test 
	public void binaryWatch0Test() {
		// given
		int x = 0;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = true;
		boolean actual = sl.hasAlternatingBits(x);
		
		// then
		Assert.assertEquals(actual, expected);
		
	}
		
	@Test 
	public void binaryWatch5Test() {
		// given
		int x = 5;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = true;
		boolean actual = sl.hasAlternatingBits(x);
		
		// then
		Assert.assertEquals(actual, expected);
		
	}
		
	@Test 
	public void binaryWatch7Test() {
		// given
		int x = 7;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = false;
		boolean actual = sl.hasAlternatingBits(x);
		
		// then
		Assert.assertEquals(actual, expected);
		
	}
		

	@Test 
	public void binaryWatch11Test() {
		// given
		int x = 11;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = false;
		boolean actual = sl.hasAlternatingBits(x);
		
		// then
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test 
	public void binaryWatch10Test() {
		// given
		int x = 10;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = true;
		boolean actual = sl.hasAlternatingBits(x);
		
		// then
		Assert.assertEquals(actual, expected);
		
	}
	
	
}
