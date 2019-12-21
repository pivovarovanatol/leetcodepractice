package com.leetcode.algors.IntegerToBinary;

import org.junit.Assert;
import org.junit.Test;

public class IntegerToBinaryTest {

	
	@Test 
	public void numberUnder4Test() {
		// given
		int n = 3;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toBinaryString(n);
		String actual = sl.intToBinary(n);
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test 
	public void number2digitsTest() {
		// given
		int n = 33;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toBinaryString(n);
		String actual = sl.intToBinary(n);
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void number3digitsTest() {
		// given
		int n = 777;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toBinaryString(n);
		String actual = sl.intToBinary(n);
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	
	@Test 
	public void negativeNumberTest() {
		// given
		int n = -7;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toBinaryString(n);
		String actual = sl.intToBinary(n);
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test 
	public void negativeNumberTest2() {
		// given
		int n = -7231;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toBinaryString(n);
		String actual = sl.intToBinary(n);
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	
	
	
}
