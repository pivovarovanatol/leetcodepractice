package com.leetcode.algors.ValidPerfectSquare;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;

public class IsPerfectSquareTest {
	
	@Test
	public void testRegularPerfectSquare() {
		// Given
		int num = 16;
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = true;
		result = sl.isPerfectSquare(num);
		
		// Then
		Assert.assertEquals(result, expected);
	}

	@Test
	public void testRegularNotPerfectSquare() {
		// Given
		int num = 15;
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = false;
		result = sl.isPerfectSquare(num);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void testOneAsPerfectSquare() {
		// Given
		int num = 1;
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = true;
		result = sl.isPerfectSquare(num);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void testNegativeNumber() {
		// Given
		int num = -16;
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = false;
		result = sl.isPerfectSquare(num);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void testHugeNotPerfectSquare() {
		// Given
		int num = 2147483647;
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = false;
		result = sl.isPerfectSquare(num);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	
	
	@Test
	public void testHugePerfectSquare() {
		// Given
		int num = 1975269136;
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = true;
		result = sl.isPerfectSquare(num);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	
}
