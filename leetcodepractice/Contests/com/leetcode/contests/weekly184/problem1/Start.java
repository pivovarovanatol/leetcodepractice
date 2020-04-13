package com.leetcode.contests.weekly184.problem1;
// https://leetcode.com/contest/weekly-contest-184/problems/string-matching-in-an-array/

public class Start {

	public static void main(String[] args) {
			
		
		String[]  words = {"mass","as","hero","superhero"};
		for (String s : new Solution().stringMatching(words)) {
			System.out.println(s + ", ");
		}
		
	}
	
}

