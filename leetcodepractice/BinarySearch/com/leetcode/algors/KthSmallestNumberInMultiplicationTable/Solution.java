package com.leetcode.algors.KthSmallestNumberInMultiplicationTable;
// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

class Solution {
    public int findKthNumber(int m, int n, int k) {
    	int l=1;
    	int r = m*n;
    	
    	for (int cnt = 0; l<r;cnt=0) {
    		int mid = (r+l)/2;
    		
    		for (int i=1, j=1;i<=m;i++, j=1) {
    			if (mid/i >= n) {
    				cnt += n;
    			}  else {
    				cnt += (mid/i);
    			}
    			if (cnt > k+1) break;
    		}
    		if (cnt<k) {
    			l = mid+1;
    		} else {
    			r = mid;
    		}
    	}
        return l;
    }
}