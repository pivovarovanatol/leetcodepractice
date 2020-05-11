package com.leetcode.algors.DFS.NumberOfWaysCuttingPizza;
//https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

import org.junit.Assert;
import org.junit.Test;

public class cutPizzaTest {
	@Test
	public void testCase1() {
		// TODO Auto-generated method stub
		String[] pizza = {"A..","AAA","..."};
		int k=3;
		int expected = 3;
		
		Solution sl = new Solution();
		int actual = sl.ways(pizza, k);
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase2() {
		// TODO Auto-generated method stub
		String[] pizza = {"A..","AA.","..."};
		int k=3;
		int expected = 1;
		
		Solution sl = new Solution();
		int actual = sl.ways(pizza, k);
		
		Assert.assertEquals(expected, actual);
	}


	@Test
	public void testCase3() {
		// TODO Auto-generated method stub
		String[] pizza = {"A..","A..","..."};
		int k=1;
		int expected = 1;
		
		Solution sl = new Solution();
		int actual = sl.ways(pizza, k);
		
		Assert.assertEquals(expected, actual);
	}



}
