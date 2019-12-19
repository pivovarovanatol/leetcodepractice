package com.leetcode.algors.SuperUglyNumber;
//https://leetcode.com/problems/super-ugly-number/

import org.junit.Assert;
import org.junit.Test;

public class SuperUglyNumberTest {
	
	Solution sl;
	
	public SuperUglyNumberTest(){
		sl = new Solution();
	}
	
	@Test
	public void lastStoneWeightTestCase1(){
		// given
		int k = 12;
		int[] primes = {2,7,13,19}; 

		// when
		int result = sl.nthSuperUglyNumber(k, primes);

		// then
		int expected = 32;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}


    
}
