package com.leetcode.algors.FindTheTownJudge;

import org.junit.*;

public class FindTheTownJudgeTest {

	@Test 
	public void singleEntryTest() {
		// given
		int[][] trust = {{1,2}};
		int N = 2;
		
		// when
		Solution sl = new Solution();
		int actual = sl.findJudge(N, trust);
		int expected = 2;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void twoEntriesHasJudgeTest() {
		// given
		int[][] trust = {{1,3},{2,3}};
		int N = 3;
		
		// when
		Solution sl = new Solution();
		int actual = sl.findJudge(N, trust);
		int expected = 3;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void threeEntriesNoJudgeTest() {
		// given
		int[][] trust = {{1,3},{2,3},{3,1}};
		int N = 3;
		
		// when
		Solution sl = new Solution();
		int actual = sl.findJudge(N, trust);
		int expected = -1;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void fourEntriesHasJudgeTest() {
		// given
		int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		int N = 4;
		
		// when
		Solution sl = new Solution();
		int actual = sl.findJudge(N, trust);
		int expected = 3;
		
		// then
		Assert.assertEquals(expected, actual);
	}
	
}
