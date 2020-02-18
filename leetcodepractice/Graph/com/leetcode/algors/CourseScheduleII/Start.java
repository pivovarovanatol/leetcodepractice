package com.leetcode.algors.CourseScheduleII;
//https://leetcode.com/problems/course-schedule-ii/

public class Start {

	public static void main(String[] args) {
		int[][] prerequisites = {{0,1}};
		int numCourses = 2;
		
		Solution sl = new Solution();
		int actual[] = sl.findOrder(numCourses, prerequisites);

		for (int el : actual) {
			System.out.print(el + " ");
		}
	}
	
}

