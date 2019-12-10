package com.leetcode.algors.ValidSudoku;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[][] = {{'.'}};
		int target=6;
		Solution sl = new Solution();
		boolean result;
		result = sl.isValidSudoku(arr);
		System.out.println(result);
	}

}
