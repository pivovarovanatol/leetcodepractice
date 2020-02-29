package com.leetcode.algors.DivideTwoIntegers;
//https://leetcode.com/problems/divide-two-integers/

import org.junit.Assert;
import org.junit.Test;


public class DivideTwoIntegersTest {

	@Test
	public void divideTwoIntegersTestCase1(){
	  int dividend = Integer.MAX_VALUE;
	  int divisor = 2;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void divideTwoIntegersTestCase2(){
      int dividend = Integer.MIN_VALUE;
      int divisor = Integer.MIN_VALUE;
      int expected = (dividend/divisor);

      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}
	@Test
	public void divideTwoIntegersTestCase3(){
  	  int dividend = 100;
      int divisor = 33;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}

	@Test
	public void divideTwoIntegersTestCase4(){
      int dividend = Integer.MAX_VALUE;
      int divisor = Integer.MAX_VALUE-5;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}
	@Test
	public void divideTwoIntegersTestCase5(){
      int dividend = 1;
      int divisor = -1;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}

	@Test
	public void divideTwoIntegersTestCase6(){
      int dividend = -10;
      int divisor = 2;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void divideTwoIntegersTestCase7(){
      int dividend = 1;
      int divisor = 2;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}
	@Test
	public void divideTwoIntegersTestCase8(){
      int dividend = 2147483647;
      int divisor = 2;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}
	@Test
	public void divideTwoIntegersTestCase9(){
      int dividend = 1026117192;
      int divisor = -874002063;
      int expected = (dividend/divisor);
      int actual = new Solution().divide(dividend, divisor);
      Assert.assertEquals(expected, actual);
	}











}
