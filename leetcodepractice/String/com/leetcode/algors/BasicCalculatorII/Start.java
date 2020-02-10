package com.leetcode.algors.BasicCalculatorII;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "2+4*5/10-1+12";
		Solution sl = new Solution();
		int result = sl.calculate(s);
		System.out.println(result);
	}
}
