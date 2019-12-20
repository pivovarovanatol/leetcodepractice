package com.leetcode.algors.ConvertNumberToHexadecimal;

import org.junit.Assert;
import org.junit.Test;

public class ConvertNumberToHexadecimalTest {

	
	@Test 
	public void numberUnder8Test() {
		// given
		int n = 7;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toHexString(n);
		String actual = sl.toHex(n);
		
		// then
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test 
	public void numberHigherThan8Test() {
		// given
		int n = 17;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toHexString(n);
		String actual = sl.toHex(n);
		
		// then
		Assert.assertEquals(expected, actual);
		
	}
	
	
	@Test 
	public void numberZeroTest() {
		// given
		int n = 0;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toHexString(n);
		String actual = sl.toHex(n);
		
		// then
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test 
	public void numberHigherTest() {
		// given
		int n = 213123;
		
		// when
		Solution sl = new Solution(); 
		String expected = Integer.toHexString(n);
		String actual = sl.toHex(n);
		
		// then
		Assert.assertEquals(expected, actual);
		
	}
	
	
	
	
	
}
