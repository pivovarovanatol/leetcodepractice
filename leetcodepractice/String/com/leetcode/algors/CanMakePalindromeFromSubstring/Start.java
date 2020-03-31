package com.leetcode.algors.CanMakePalindromeFromSubstring;
// https://leetcode.com/problems/can-make-palindrome-from-substring/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		
		String s = "abcda";
		int[][] queries = new int[5][3];
		// Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]
		// Output: [true,false,false,true,true]
		queries[0][0] = 3; queries[0][1] = 3; queries[0][2] = 0; 
		queries[1][0] = 1; queries[1][1] = 2; queries[1][2] = 0;
		queries[2][0] = 0; queries[2][1] = 3; queries[2][2] = 1;
		queries[3][0] = 0; queries[3][1] = 3; queries[3][2] = 2;
		queries[4][0] = 0; queries[4][1] = 4; queries[4][2] = 1;
		
		Solution sl = new Solution();
		List<Boolean> actual = sl.canMakePaliQueries(s, queries);
		List<Boolean> actual1 = sl.canMakePaliQueries3(s, queries);
		
		for (boolean str : actual) {
			System.out.print(str + ", ");
		}
		
		System.out.println("============================");
		

		
		for (boolean str : actual1) {
			System.out.print(str + ", ");
		}
				
	}

}
