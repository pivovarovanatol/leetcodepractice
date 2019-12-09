package com.leetcode.algors.ProductOfArrayExceptSelf;
// https://leetcode.com/problems/product-of-array-except-self/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution sl = new Solution();
		int[] arr = {1,2,3,4};
		
		int[] result = sl.productExceptSelf(arr);
		
		for (int i : result) {
			System.out.print(i+" ");
		}
		
		//System.out.println(result);
	}
}
