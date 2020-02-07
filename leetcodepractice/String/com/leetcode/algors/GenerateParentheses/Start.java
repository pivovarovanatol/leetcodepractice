package com.leetcode.algors.GenerateParentheses;
// https://leetcode.com/problems/generate-parentheses/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Tst");
		Solution sl = new Solution();
		List<String> actual = sl.generateParenthesis(3);
		
		for (String str : actual) {
			System.out.println(str);
		}
		
		
	}

}
