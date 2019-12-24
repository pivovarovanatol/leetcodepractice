package com.leetcode.algors.FindTheTownJudge;
//https://leetcode.com/problems/find-the-town-judge/

public class Start {

	public static void main(String[] args) {
		int[][] trust = {{1,2}};
		int N = 2;
		
		Solution sl = new Solution();
		int actual = sl.findJudge(N, trust);
		System.out.println(actual);
		
	}
	
}

