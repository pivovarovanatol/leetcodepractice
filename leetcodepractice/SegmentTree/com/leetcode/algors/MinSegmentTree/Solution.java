package com.leetcode.algors.MinSegmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

// https://leetcode.com/problems/count-of-range-sum/


class Solution {
	int[] sg;
	
	public int getMinRange(int[] arr, int lo, int hi) {
		int min = Integer.MAX_VALUE;
		int n = arr.length;
		// build segment tree out of array.
		//int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int treeSize = (int) Math.pow(2, n); 
		treeSize = 2*n +1;
		sg = new int[treeSize];
		for (int i=0;i<treeSize;i++) {
			sg[i] = Integer.MAX_VALUE;
		}
		// query the tree within the range and return results
		
		buidMinSegmentTree(arr, 0, n-1, 0);
		
		for (int i : sg) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		
		return min;
	} 
    
	private int querySegmentTree(int start, int end, int lo, int hi, int index) {
	        // If segment of this node is a part of given range, then return 
	        // the sum of the segment 
	        if (lo <= start && hi >= end) 
	            return sg[end]; 
	  
	        // If segment of this node is outside the given range 
	        if (end < lo || start > hi) 
	            return Integer.MAX_VALUE; 
	  
	        // If a part of this segment overlaps with the given range 
	        int mid = getMid(start, end); 
	        return Math.min(querySegmentTree(start, mid, lo, hi, 2 * index + 1), 
	        		querySegmentTree(mid + 1, end, lo, hi, 2 * index + 2)); 
		
	}

	int getArraySize(int n) {
		int multi = 1;
		while (multi < n) {
			multi *=2;
		}
		
		return (2*multi);
	}
	
	int buidMinSegmentTree(int[] arr, int lo, int hi, int index) {
		     // If there is one element in array, store it in current node of 
		     // segment tree and return 
		     if (lo == hi) { 
		         sg[index] = arr[lo]; 
		         return arr[lo]; 
		     } 

		     // If there are more than one elements, then recur for left and 
		     // right subtrees and store the sum of values in this node 
		     int mid = getMid(lo, hi); 
		     sg[index] = Math.min(buidMinSegmentTree(arr, lo, mid, index * 2 + 1), 
		    		 buidMinSegmentTree(arr, mid + 1, hi, index * 2 + 2)); 
		     return sg[index]; 
	}
	
	 int getMid(int s, int e) { 
	     return s + (e - s) / 2; 
	 } 
	
}