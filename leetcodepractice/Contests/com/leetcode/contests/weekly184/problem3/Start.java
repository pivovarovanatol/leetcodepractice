package com.leetcode.contests.weekly184.problem3;
// https://leetcode.com/problems/html-entity-parser/

public class Start {

	public static void main(String[] args) {
		String text = "&amp; is an HTML entity but &ambassador; is not.";
		System.out.print(new Solution().entityParser(text));
		
	}
	
}

