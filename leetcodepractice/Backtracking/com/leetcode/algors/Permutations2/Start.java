package com.leetcode.algors.Permutations2;

import java.util.List;

// https://leetcode.com/problems/permutations-ii/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,1,2};
		Solution sl = new Solution();
		List<List<Integer>> result = sl.permuteUnique(arr);
		System.out.println(result);
	}
}

/* 
 * 000001
 *   1111
 * 010000
 * 
 * 
 * */
