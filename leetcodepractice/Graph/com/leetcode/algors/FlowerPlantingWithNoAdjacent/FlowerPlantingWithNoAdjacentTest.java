package com.leetcode.algors.FlowerPlantingWithNoAdjacent;
//https://leetcode.com/problems/flower-planting-with-no-adjacent/

import org.junit.*;

public class FlowerPlantingWithNoAdjacentTest {

	@Test 
	public void simpleTest() {
		// given
		int[][] paths = {{1,2},{2,3},{3,1}};
		int N = 3;
		
		// when
		Solution sl = new Solution();
		int[] actual = sl.gardenNoAdj(N, paths);
		int[] expected = {1,2,3};
		
		// then
		for (int i=0;i<N;i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
	}
	
	@Test 
	public void simpleTest2() {
		// given
		int[][] paths = {{1,2},{3,4}};
		int N = 4;
		
		// when
		Solution sl = new Solution();
		int[] actual = sl.gardenNoAdj(N, paths);
		int[] expected = {1,2,1,2};
		
		// then
		for (int i=0;i<N;i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
	}

	
	@Test 
	public void simpleTest3() {
		// given
		int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
		int N = 4;
		
		// when
		Solution sl = new Solution();
		int[] actual = sl.gardenNoAdj(N, paths);
		int[] expected = {1,2,3,4};
		
		// then
		for (int i=0;i<N;i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
	}

	
	
}
