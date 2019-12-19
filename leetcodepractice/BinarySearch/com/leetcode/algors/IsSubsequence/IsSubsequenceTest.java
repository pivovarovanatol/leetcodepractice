package com.leetcode.algors.IsSubsequence;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;

public class IsSubsequenceTest {
	
	@Test
	public void testRegularTrueCase() {
		// Given
		String input1 = "abc";
		String input2 = "ahbgdc";
		
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = true;
		result = sl.isSubsequence(input1, input2);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void testRegularFalseCase() {
		// Given
		String input1 = "axc";
		String input2 = "ahbgdc";
		
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = false;
		result = sl.isSubsequence(input1, input2);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	
	@Test
	public void testEmptyFirstPArameter() {
		// Given
		String input1 = "";
		String input2 = "ahbgdc";
		
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = true;
		result = sl.isSubsequence(input1, input2);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	
	@Test
	public void testEmptySecondParameter() {
		// Given
		String input1 = "abc";
		String input2 = "";
		
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = false;
		result = sl.isSubsequence(input1, input2);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void testEmptyBothParams() {
		// Given
		String input1 = "";
		String input2 = "";
		
		Solution sl = new Solution();
		
		// When
		boolean result;
		boolean expected = true;
		result = sl.isSubsequence(input1, input2);
		
		// Then
		Assert.assertEquals(result, expected);
	}
	
	
	
	
}
