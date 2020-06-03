package com.leetcode.algors.CourseScheduleIV;

import java.util.List;

//https://leetcode.com/problems/course-schedule-iv/

public class Start {

	public static void main(String[] args) {
		
		int n=33;
		int[][] prerequisites = {{16,22},{16,15},{16,2},{16,3},{16,25},{16,21},{16,11},{16,23},{16,5},{16,13},{16,20},{16,29},{16,14},{16,9},{16,17},{16,6},{16,27},{16,8},{16,24},{16,1},{16,31},{16,7},{16,18},{16,26},{16,30},{16,28},{16,10},{16,12},{32,22},{32,15},{32,2},{32,25},{32,21},{32,11},{32,23},{32,5},{32,4},{32,20},{32,29},{32,14},{32,17},{32,19},{32,6},{32,27},{32,8},{32,24},{32,1},{32,31},{32,7},{32,18},{32,26},{32,30},{32,28},{32,10},{32,12},{32,0},{22,15},{22,2},{22,3},{22,21},{22,11},{22,23},{22,5},{22,4},{22,13},{22,20},{22,29},{22,9},{22,17},{22,19},{22,6},{22,8},{22,24},{22,31},{22,7},{22,18},{22,26},{22,30},{22,28},{22,10},{22,12},{22,0},{15,2},{15,3},{15,25},{15,21},{15,11},{15,23},{15,5},{15,4},{15,13},{15,29},{15,14},{15,9},{15,17},{15,19},{15,6},{15,27},{15,8},{15,24},{15,1},{15,31},{15,7},{15,18},{15,26},{15,30},{15,28},{15,10},{15,12},{15,0},{2,25},{2,21},{2,11},{2,23},{2,5},{2,4},{2,13},{2,29},{2,14},{2,9},{2,17},{2,19},{2,6},{2,27},{2,8},{2,24},{2,1},{2,31},{2,7},{2,18},{2,10},{2,12},{2,0},{3,25},{3,21},{3,11},{3,23},{3,5},{3,4},{3,13},{3,20},{3,29},{3,14},{3,9},{3,17},{3,6},{3,8},{3,1},{3,31},{3,7},{3,18},{3,26},{3,30},{3,10},{3,12},{3,0},{25,21},{25,11},{25,23},{25,5},{25,4},{25,20},{25,29},{25,14},{25,9},{25,17},{25,19},{25,6},{25,27},{25,8},{25,24},{25,1},{25,31},{25,7},{25,18},{25,26},{25,30},{25,28},{25,10},{25,12},{21,11},{21,23},{21,5},{21,4},{21,13},{21,20},{21,29},{21,14},{21,9},{21,19},{21,6},{21,27},{21,8},{21,24},{21,1},{21,31},{21,7},{21,18},{21,26},{21,30},{21,28},{21,10},{21,12},{21,0},{11,23},{11,5},{11,4},{11,13},{11,20},{11,29},{11,14},{11,9},{11,17},{11,19},{11,6},{11,27},{11,8},{11,24},{11,1},{11,31},{11,7},{11,18},{11,26},{11,30},{11,28},{11,10},{11,12},{11,0},{23,5},{23,4},{23,13},{23,20},{23,29},{23,14},{23,9},{23,17},{23,6},{23,8},{23,24},{23,1},{23,7},{23,18},{23,28},{23,10},{23,12},{5,13},{5,20},{5,9},{5,17},{5,6},{5,27},{5,24},{5,1},{5,31},{5,7},{5,18},{5,26},{5,30},{5,10},{5,12},{5,0},{4,13},{4,20},{4,29},{4,14},{4,17},{4,19},{4,6},{4,8},{4,24},{4,1},{4,31},{4,7},{4,18},{4,26},{4,30},{4,28},{4,10},{4,12},{4,0},{13,20},{13,14},{13,9},{13,17},{13,19},{13,8},{13,24},{13,1},{13,31},{13,7},{13,18},{13,26},{13,30},{13,28},{13,10},{13,12},{13,0},{20,29},{20,14},{20,9},{20,17},{20,19},{20,6},{20,27},{20,1},{20,31},{20,26},{20,30},{20,28},{20,12},{20,0},{29,14},{29,9},{29,17},{29,19},{29,6},{29,27},{29,8},{29,24},{29,1},{29,31},{29,7},{29,18},{29,30},{29,28},{29,10},{29,12},{29,0},{14,9},{14,17},{14,19},{14,6},{14,27},{14,24},{14,1},{14,31},{14,7},{14,18},{14,26},{14,30},{14,28},{14,12},{14,0},{9,17},{9,19},{9,6},{9,27},{9,8},{9,24},{9,1},{9,31},{9,7},{9,18},{9,26},{9,30},{9,28},{9,12},{9,0},{17,19},{17,6},{17,27},{17,8},{17,24},{17,1},{17,7},{17,18},{17,26},{17,30},{17,28},{17,10},{17,12},{17,0},{19,6},{19,8},{19,24},{19,1},{19,31},{19,7},{19,18},{19,26},{19,30},{19,28},{19,10},{19,0},{6,27},{6,8},{6,24},{6,1},{6,7},{6,26},{6,30},{6,28},{6,10},{6,12},{6,0},{27,8},{27,24},{27,1},{27,7},{27,26},{27,30},{27,28},{27,10},{27,12},{27,0},{8,24},{8,1},{8,31},{8,18},{8,26},{8,28},{8,12},{8,0},{24,1},{24,31},{24,7},{24,18},{24,26},{24,30},{24,28},{24,12},{24,0},{1,31},{1,7},{1,18},{1,26},{1,30},{1,28},{1,10},{1,12},{1,0},{31,7},{31,18},{31,26},{31,30},{31,28},{31,10},{31,12},{31,0},{7,18},{7,26},{7,30},{7,28},{7,10},{18,26},{18,28},{18,10},{26,30},{26,28},{26,10},{26,0},{30,28},{30,10},{30,12},{30,0},{28,12},{28,0},{10,0},{12,0}};
		int[][] queries = {{6,17},{31,23},{32,18},{31,18},{23,8},{30,20},{13,16},{25,31},{30,22},{17,0},{10,26},{32,20},{10,28},{31,32},{32,21},{24,27},{17,10},{27,3},{24,16},{31,29},{6,31},{23,22},{24,13},{7,21},{14,28},{28,30},{28,32},{16,7},{7,32},{10,24},{5,28},{20,32},{27,31},{31,32},{30,32},{4,10},{18,32},{18,22},{10,25},{32,22},{0,32},{32,27},{32,25},{18,12},{24,23},{30,31},{28,18},{18,26},{18,20},{30,16},{7,19},{29,31},{13,10},{18,7},{14,2},{32,30},{14,1},{27,29},{13,22},{25,1},{25,23},{8,29},{16,20},{10,24},{4,20},{0,13},{25,14},{29,27},{12,28},{24,31},{32,26},{29,3},{27,23},{22,31},{21,15},{29,11},{30,26},{18,25},{22,29},{10,26},{20,12},{6,1},{30,7},{4,31},{13,16},{30,18},{13,5},{16,25},{23,28},{28,25},{30,10},{16,21},{32,5},{19,16},{30,29},{2,16},{18,21},{20,24},{24,23},{13,7},{28,5},{32,31},{17,24},{6,29},{24,25},{21,24},{24,22},{26,29},{20,5},{22,29},{19,9},{16,21},{21,18},{2,11},{14,0},{14,7},{17,23},{31,1},{3,9},{22,4},{30,21},{32,11},{31,28},{26,29},{19,0},{22,13},{4,17},{1,2},{29,24},{14,15},{19,0},{6,25},{14,27},{20,31},{25,21},{32,31},{31,27},{6,14},{32,30},{22,20},{27,20},{23,22},{28,31},{15,26},{26,14},{28,7},{29,30},{32,28},{15,26},{14,27},{32,31},{6,23},{8,27},{5,7},{21,18},{14,11},{32,28},{29,8},{24,32},{14,28},{19,21},{15,13},{3,20},{30,27},{22,19},{32,29},{6,10},{26,30},{29,4},{16,3},{31,8},{20,24},{30,8},{17,28},{13,14},{4,10},{12,22},{26,3},{30,28},{3,8},{11,30},{20,4},{20,14},{15,27},{15,23},{27,25},{4,20},{7,31},{24,22},{28,29},{21,31},{32,11},{19,10},{30,25},{8,24},{26,17},{9,26},{17,14},{29,24},{30,31},{29,22},{10,21},{21,19},{25,28},{15,28},{32,29},{23,1},{26,29},{17,31},{25,21},{15,8},{29,28},{20,24},{19,24},{23,22},{2,15},{17,31},{31,32},{23,21},{27,31},{28,24},{2,21},{4,26},{27,20},{14,25},{4,3},{21,22},{28,22},{16,26},{12,22},{27,9},{8,30},{24,30},{23,28},{14,3},{1,7},{32,31},{23,29},{23,29},{11,20},{30,27},{20,7},{31,27},{2,30},{6,11},{18,10},{13,31},{19,31},{24,9},{7,10},{27,31},{3,4},{24,2},{8,21},{13,27},{23,20},{26,25},{18,30},{26,23},{20,29},{32,27},{29,14},{29,27},{6,27},{17,0},{29,30},{31,28},{24,29},{23,0},{31,23},{23,26},{21,14},{16,7},{28,12},{3,7},{3,30},{31,29},{15,0},{13,6},{32,12},{28,26},{27,30},{23,29},{5,13},{29,30},{14,22},{9,22},{16,13},{31,28},{30,13},{14,21},{32,31},{10,21},{27,24},{11,4},{13,1},{21,24},{31,32},{12,3},{29,32},{15,14},{9,26},{25,21},{32,31},{11,23},{18,11},{18,21},{24,1},{31,18},{26,20},{19,6},{25,10},{21,28},{23,32},{28,30},{31,30},{6,16},{19,29},{13,23},{31,30},{29,25},{32,19},{26,23},{2,3},{22,24},{32,29},{24,27},{30,8},{31,30},{24,13},{31,32},{26,30},{27,10},{26,5},{10,22},{27,32},{17,14},{26,18},{32,31},{10,5},{0,19},{28,30},{13,7},{9,28},{20,19},{4,23},{30,31},{26,21},{25,24},{23,22},{26,29},{22,17},{18,20},{18,31},{11,16},{0,23},{9,6},{17,19},{1,4},{18,27},{20,30},{16,19},{25,23},{32,29},{32,30},{18,3},{2,21},{0,5},{18,16},{11,1},{28,16},{31,10},{32,14},{13,32},{20,22},{25,23},{14,21},{14,26},{14,3},{18,5},{28,24},{4,19},{2,16},{24,16},{21,19},{32,25},{30,23},{12,8},{11,17},{13,5},{23,16},{28,22},{10,29},{10,15},{29,6},{18,10},{26,30},{31,21},{23,2},{27,20},{32,17},{1,16},{32,30},{22,12},{17,0},{4,6},{31,29},{30,32},{18,28},{32,28},{16,28},{19,25},{31,32},{25,31},{19,21},{12,9},{18,32},{17,10},{21,9},{0,16},{16,23},{10,30},{31,19},{30,19},{26,12},{24,25},{17,32},{23,22},{6,23},{14,28},{5,14},{25,29},{28,24},{8,3},{30,19},{26,7},{11,17},{32,29},{26,28},{14,23},{30,25},{25,31},{31,4},{11,9},{30,19},{19,2},{11,9},{21,28},{13,10},{19,6},{1,19},{24,15},{23,25},{16,30},{9,26},{28,0},{21,24},{19,3},{26,6},{11,21},{17,21},{16,21},{1,31},{15,16},{31,32},{30,8},{6,7},{23,14},{19,22},{31,32},{23,20},{17,30},{4,3},{17,1},{32,25},{10,31},{11,12},{26,28},{25,28},{31,23},{18,16},{16,14},{2,8},{1,14},{10,19},{26,8},{16,7},{25,18},{16,10},{19,27},{30,31},{29,21},{29,28},{17,30},{10,24},{16,0},{32,31},{32,31},{8,1},{23,11},{25,28},{20,14},{16,10},{10,0},{22,32},{15,9},{19,14},{27,25},{27,25},{31,32},{13,30},{9,31},{15,26},{15,28},{0,25},{30,22},{7,24},{10,28},{22,23},{16,28},{8,9},{31,17},{19,25},{23,6},{29,32},{4,5},{21,5},{27,23},{31,30},{29,30},{24,25},{20,30},{27,18},{21,9},{32,30},{23,5},{17,5},{20,18},{19,12},{32,28},{21,17},{32,20},{26,13},{28,25},{31,32},{19,29},{29,14},{24,15},{30,4},{14,20},{27,22},{4,16},{9,22},{18,5},{31,13},{26,29},{30,32},{27,30},{0,8},{17,1},{30,32},{18,19},{25,22},{23,17},{24,26},{8,10},{20,23},{32,31},{32,20},{22,9},{0,15},{19,18},{32,29},{22,1},{19,22},{13,23},{31,32},{20,3},{29,8},{27,29},{7,17},{16,20},{24,4},{30,32},{28,12},{32,31},{31,30},{6,18},{32,30},{11,6},{28,29},{21,31},{2,21},{9,30},{31,32},{13,21},{31,14},{22,30},{32,26},{11,30},{9,19},{10,20},{29,10},{1,20},{25,30},{13,20},{15,16},{27,28},{29,22},{13,3},{7,17},{12,14},{32,31},{18,15},{31,28},{25,31},{30,31},{29,2},{26,19},{31,24},{22,3},{32,31},{23,28},{2,24},{4,8},{19,5},{16,29},{7,13},{10,28},{12,9},{23,28},{14,27},{31,24},{14,3},{26,31},{23,32},{14,31},{14,18},{0,10},{23,13},{25,24},{17,7},{17,11},{19,2},{32,16},{9,15},{25,17},{12,3},{32,26},{12,20},{29,11},{29,32},{5,7},{23,25},{27,22},{31,32},{30,22},{30,31},{9,10},{28,29},{5,3},{8,24},{28,32},{14,22},{7,28},{30,20},{20,9},{32,31},{23,31},{31,29},{32,30},{24,32},{1,2},{20,4},{1,21},{31,15},{26,27},{10,24},{1,25},{23,20},{20,22},{9,29},{25,24},{17,9},{17,9},{13,32},{21,20},{29,20},{19,7},{28,30},{12,28},{21,28},{12,16},{14,11},{6,27},{31,23},{10,15},{28,7},{0,5},{19,17},{25,11},{7,16},{32,30},{32,30},{12,31},{11,12},{31,28},{27,32},{14,1},{17,5},{15,25},{8,19},{29,31},{14,27},{18,20},{7,3},{9,6},{20,24},{9,27},{1,11},{20,4},{12,30},{21,7},{28,3},{32,30},{11,0},{29,27},{31,32},{11,9},{24,0},{24,14},{21,3},{13,30},{25,32},{21,24},{7,8},{19,22},{21,20},{11,4},{5,4},{9,17},{31,26},{26,18},{25,21},{19,17},{7,4},{5,17},{2,4},{20,16},{13,20},{31,32},{29,24},{3,24},{10,23},{9,16},{18,17},{21,26},{27,29},{31,32},{24,2},{15,26},{1,8},{14,20},{31,32},{21,14},{32,23},{31,25},{31,17},{15,13},{22,32},{27,21},{32,10},{26,28},{27,29},{12,29},{6,16},{14,19},{17,21},{23,27},{1,12},{14,26},{22,21},{0,12},{10,9},{13,18},{20,23},{27,28},{11,15},{32,26},{23,4},{27,32},{19,10},{20,24},{9,12},{1,12},{16,12},{6,14},{11,21},{6,4},{11,22},{31,27},{21,20},{17,30},{31,32},{3,17},{27,22},{21,28},{25,5},{29,27},{31,18},{31,30},{29,27},{12,21},{29,10},{3,18},{21,31},{8,15},{16,22},{16,21},{32,31},{31,8},{5,13},{11,19},{23,4},{23,10},{5,26},{25,7},{8,27},{32,9},{30,28},{13,23},{32,28},{16,21},{31,32},{25,16},{32,28},{23,26},{11,22},{20,21},{28,12},{15,12},{14,13},{5,18},{15,14},{7,27},{11,0},{15,18},{32,17},{21,7},{27,26},{27,12},{27,32},{31,32},{19,30},{26,28},{32,31},{31,9},{30,26},{30,28},{27,24},{31,32},{14,20},{22,5},{5,26},{24,28},{29,30},{15,31},{11,30},{32,26},{31,13},{14,27},{32,18},{19,0},{28,24},{26,32},{17,15},{28,8},{26,10},{26,24},{21,10},{1,31},{14,29},{32,29},{9,16},{31,28},{25,31},{22,29},{32,22},{4,0},{26,5},{30,32},{8,24},{30,17},{32,30},{21,16},{17,24},{30,26},{18,32},{27,26},{16,31},{25,7},{30,18},{0,25},{32,31},{4,26},{31,27},{20,32},{9,24},{1,31},{22,30},{27,30},{23,32},{29,31},{31,30},{30,19},{6,5},{31,30},{22,1},{29,27},{24,31},{23,22},{15,20},{21,15},{8,14},{1,10},{32,23},{27,14},{15,30},{30,32},{28,30},{9,16},{20,14},{20,21},{32,25},{28,20},{29,16},{7,1},{7,28},{10,12},{20,27},{24,26},{6,26},{23,17},{20,6},{14,7},{30,15},{32,27},{30,27},{27,30},{24,1},{31,30},{30,28},{27,22},{22,27},{14,13},{28,17},{31,30},{23,29},{17,24},{29,32},{19,21},{29,21},{25,28},{16,12},{30,26},{10,19},{30,0},{20,12},{3,9},{7,32},{12,21},{24,8}};
		
		Solution sl = new Solution();
		List<Boolean> actual = sl.checkIfPrerequisite(n, prerequisites, queries);
		System.out.println(actual);
		
	}
	
}

