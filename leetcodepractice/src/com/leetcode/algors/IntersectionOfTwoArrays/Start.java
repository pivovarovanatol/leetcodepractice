package com.leetcode.algors.IntersectionOfTwoArrays;
//https://leetcode.com/problems/intersection-of-two-arrays/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {4,9,5};
		int[] arr2 = {9,4,9,8,4};
		
		Solution sl = new Solution();
		int result[] = sl.intersection(arr1, arr2);

		for (int i : result) {
			System.out.print(i + " ");
		}
		
	}
    
}

