package com.leetcode.algors.MinSegmentTree;
// https://leetcode.com/problems/sum-of-subarray-minimums/


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
		
		buidMinSegmentTree(arr, n);
		
		for (int i : sg) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		min = range_query(sg, lo, hi, n);
		
		return min;
	} 
    
    static int range_query(int[] segtree, int left, int right, int n) {
        // change the index to leaf node first 
        left += n; 
        right += n; 
  
        // initialize minimum to a very high value 
        int mi = (int) 1e9; 
  
        while (left < right)  
        { 
            // if left index in odd 
            if ((left & 1) == 1) 
            { 
                mi = Math.min(mi, segtree[left]); 
                // make left index even 
                left++; 
            } 
            // if right index in odd 
            if ((right & 1) == 1)  
            { 
                // make right index even 
                right--; 
                mi = Math.min(mi, segtree[right]); 
            } 
            // move to the next higher level 
            left /= 2; 
            right /= 2; 
        } 
        return mi; 
    } 
	
	void buidMinSegmentTree(int[] arr, int n) {
		for (int i=0;i<n;i++) {
			sg[n+i] = arr[i];
		}
		for (int i=n-1;i>=0;i--) {
			sg[i]=Math.min(sg[2*i], sg[2*i+1]);
		}
		return;
	}
	
}