package com.leetcode.algors.RemoveDuplicatesFromSortedArray;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,1,2,2,3,3,3,3, 4,4,4,5,6,6,6};
		
		Solution sl = new Solution();
		
		int result = 0;
		result = sl.removeDuplicates(arr);
		
		System.out.println(result);
		
		for (int i=0;i<result;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
