package com.leetcode.algors.UglyNumberIII;

import org.junit.Assert;
import org.junit.Test;


public class UglyNumberIIITest {

	@Test
	public void uglyNumberIIITestSimple1() {
		//given
    	int n=100;
    	int a=2;
    	int b=3;
    	int c=5;
    	int expected= 136;
    	// when
    	int actual = new Solution().nthUglyNumber(n, a, b, c);
    	//then
    	Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void uglyNumberIIITestSimple2() {
		//given
    	int n=10;
    	int a=7;
    	int b=6;
    	int c=8;
    	int expected= 28;
    	// when
    	int actual = new Solution().nthUglyNumber(n, a, b, c);
    	//then
    	Assert.assertEquals(expected, actual);
	}

	
	@Test
	public void uglyNumberIIITestHuge() {
		//given
    	int n=1000000000;
    	int a=2;
    	int b=217983653;
    	int c=336916467;
    	int expected= 1999999984;
    	// when
    	int actual = new Solution().nthUglyNumber(n, a, b, c);
    	//then
    	Assert.assertEquals(expected, actual);
	}
	
	
}
