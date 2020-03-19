package com.leetcode.algors.DayOfTheWeek;

import org.junit.Assert;
import org.junit.Test;

public class DayOfTheWeekTest {
	
	@Test
	public void dayOfTheWeekTest1(){
		// given
		int year = 2009, month = 9, day = 15;
		
		// when
		Solution sl = new Solution();
		String actual = sl.dayOfTheWeek(day, month, year);
		String expected = "Tuesday";
		
		// then
		//System.out.println(result);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void dayOfTheWeekTest2(){
		// given
		int year = 2019, month = 8, day = 31;
		
		// when
		Solution sl = new Solution();
		String actual = sl.dayOfTheWeek(day, month, year);
		String expected = "Saturday";
		
		// then
		//System.out.println(result);
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void dayOfTheWeekTest3(){
		// given
		int year = 1999, month = 7, day = 18;
		
		// when
		Solution sl = new Solution();
		String actual = sl.dayOfTheWeek(day, month, year);
		String expected = "Sunday";
		
		// then
		//System.out.println(result);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void dayOfTheWeekTest4(){
		// given
		int year = 1993, month = 8, day = 15;
		
		// when
		Solution sl = new Solution();
		String actual = sl.dayOfTheWeek(day, month, year);
		String expected = "Sunday";
		
		// then
		//System.out.println(result);
		Assert.assertEquals(expected, actual);
	}

						
	@Test
	public void dayOfTheWeekTest5(){
		// given
		int year = 1995, month = 3, day = 6;
		
		// when
		Solution sl = new Solution();
		String actual = sl.dayOfTheWeek(day, month, year);
		String expected = "Monday";
		
		// then
		//System.out.println(result);
		Assert.assertEquals(expected, actual);
	}

			
	
}
