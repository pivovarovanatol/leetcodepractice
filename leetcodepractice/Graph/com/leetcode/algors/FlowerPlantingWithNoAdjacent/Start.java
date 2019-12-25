package com.leetcode.algors.FlowerPlantingWithNoAdjacent;
//https://leetcode.com/problems/flower-planting-with-no-adjacent/


public class Start {

	public static void main(String[] args) {
		int[][] paths = {{1,2},{2,3},{3,1}};
		int N = 3;
		
		Solution sl = new Solution();
		int[] actual = sl.gardenNoAdj(N, paths);
		
		for (int e : actual) {
			System.out.print(e + " ");
		}
		
		
	}
	
}

