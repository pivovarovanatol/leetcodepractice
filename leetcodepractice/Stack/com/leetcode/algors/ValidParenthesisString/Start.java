package com.leetcode.algors.ValidParenthesisString;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*"; // false
		
		System.out.println(new Solution().checkValidString(s));
	}

}
