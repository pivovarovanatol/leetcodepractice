package com.leetcode.algors.PowerOfFour;
//https://leetcode.com/problems/power-of-four/

import org.junit.Assert;
import org.junit.Test;

public class PowerOfFourTest {
	@Test 
	public void powerOfFourNumber1Test() {
		// given
		int x = 1;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = true;
		
		boolean actual = sl.isPowerOfFour(x);
		Assert.assertEquals(expected, actual);
	}
		
	@Test 
	public void powerOfFourNumber4Test() {
		// given
		int x = 4;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = true;
		
		boolean actual = sl.isPowerOfFour(x);
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void powerOfFourNumber16Test() {
		// given
		int x = 16;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = true;
		
		boolean actual = sl.isPowerOfFour(x);
		Assert.assertEquals(expected, actual);
	}
		
	@Test 
	public void powerOfFourNumber15Test() {
		// given
		int x = 15;
		
		// when
		Solution sl = new Solution(); 
		boolean expected = false;
		
		boolean actual = sl.isPowerOfFour(x);
		Assert.assertEquals(expected, actual);
	}
		

	
}
