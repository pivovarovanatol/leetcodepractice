package com.leetcode.algors.twoSums2SortedArray;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,7,11,15};
		int target=9;
		Solution sl = new Solution();
		int[] result = new int[2];
		result = sl.twoSum(arr, target);
		System.out.println(result[0] + " " + result[1]);
	}

}
