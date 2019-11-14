package com.leetcode.algors.twoSums;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,3};
		int target=6;
		Solution sl = new Solution();
		int[] result = new int[2];
		result = sl.twoSum(arr, target);
		System.out.println(result[0] + " " + result[1]);
	}

}
