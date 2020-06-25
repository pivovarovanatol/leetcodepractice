package com.leetcode.algors.KthSmallestNumberInMultiplicationTable;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 20000;
		int m = 20000;
		int k = 390000000;

		Solution sl = new Solution();
		int result = sl.findKthNumber(m, n, k);
		System.out.println(result);

		
	}
	
	
    
}

