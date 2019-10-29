package com.leetcode.algors.RotateArray;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2};
		Solution sl = new Solution();
		sl.rotate(arr, 3);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}

/* 
 * 000001
 *   1111
 * 010000
 * 
 * 
 * */
