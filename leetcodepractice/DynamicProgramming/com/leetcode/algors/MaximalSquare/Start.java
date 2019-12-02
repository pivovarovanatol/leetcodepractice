package com.leetcode.algors.MaximalSquare;
// https://leetcode.com/problems/maximal-square/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {1,2,3,1};
		//int[] arr = {1,2,3,1};
		char[][] arr = {
						{'1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '1'},
						{'1', '1', '1', '1', '0'}
					};

		// int n= arr.length;
		Solution sl = new Solution();
		int result = sl.maximalSquare(arr);
		System.out.println(result);
	}

}
