package com.leetcode.algors.Permutations;

import java.util.List;

// https://leetcode.com/problems/permutations/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3};
		Solution sl = new Solution();
		List<List<Integer>> result = sl.permute(arr);
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
