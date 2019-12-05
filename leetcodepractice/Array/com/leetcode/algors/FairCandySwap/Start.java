package com.leetcode.algors.FairCandySwap;
// https://leetcode.com/problems/fair-candy-swap/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {2};
		int[] arr2 = {1,3};

		Solution sl = new Solution();
		int[] result = sl.fairCandySwap(arr1, arr2);

		System.out.println(result[0] + " " + result[1]);
		System.out.print(" ");
	}
    
}

