package com.leetcode.algors.SearchInsertPosition;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,4,6,8,10,12,14,16};
		
		Solution sl = new Solution();
		
		int result = 0;
		int target = 5;
		result = sl.searchInsert(arr, target);

		System.out.println(result);
		
	}

}
