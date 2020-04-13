package com.leetcode.contests.weekly184.problem2;
// https://leetcode.com/problems/queries-on-a-permutation-with-key/

public class Start {

	public static void main(String[] args) {
		
		int[] queries = {3,1,2,1};
		int m=5;
		
		for (int e : new Solution().processQueries(queries, m)) 
			System.out.print(e + ", ");
		
	}
	
}

