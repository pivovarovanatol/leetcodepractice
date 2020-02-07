package com.leetcode.algors.CountSmallerNumbersAfterSelf;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/


import java.util.List;

public class Start {

	public static void main(String[] args) {
		
//		int[] nums = {5,2,6,1};
//		int[] expected = {2,1,1,0};
		
//		int[] nums = {2,0,1};
//		int[] expected = {2,0,0};

//		int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
//		int[] expected = {10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0};

		int[] nums = {10,4,7,10,5,1};
		int[] expected = {4,1,2,2,1,0};

		Solution sl = new Solution();
		List<Integer> actual = sl.countSmaller(nums);
		for (int e : actual) {
			System.out.print(e+" ");
		}
		System.out.println();
		
		for (int e : expected) {
			System.out.print(e+" ");
		}
		System.out.println();
		
	}


}
