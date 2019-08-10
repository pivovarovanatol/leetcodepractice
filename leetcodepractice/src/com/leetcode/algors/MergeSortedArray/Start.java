package com.leetcode.algors.MergeSortedArray;
// https://leetcode.com/problems/merge-sorted-array/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution sl = new Solution();
		int arr1[] = {0};
		int arr2[]={1};
		
		sl.merge(arr1,0,arr2,1);
		
		for (int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
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
