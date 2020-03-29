package com.leetcode.contests.weekly182.problem4;

public class Start {

	public static void main(String[] args) {
		int[][] prerequisites = {{2,0}, {2,1},{3,2},{5,4},{5,3}, {0,3}};
		int numCourses = 6;
		
		Solution sl = new Solution();
		boolean actual = sl.canFinish(numCourses, prerequisites);
		System.out.println(actual);
		
	}
	
}

