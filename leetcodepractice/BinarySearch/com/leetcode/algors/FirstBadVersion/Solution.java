package com.leetcode.algors.FirstBadVersion;
// https://leetcode.com/problems/first-bad-version/


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution{
    
    int badVersion;
    int count;
    // Iterative solution - 10ms (<99%) 32.9MB(<100%)
    public int firstBadVersion(int n) {
        int bad = helper(1, n);
        System.out.println(count);
        return bad;

    }
    private int helper(int lo, int hi){
        while(lo < hi){
            int md = lo+(hi-lo)/2;
            //System.out.println("Low: " + lo + " High: " + hi + " Mid: " + md + " Is Bad Version? " + isBadVersion(md));
            if(isBadVersion(md)){
                hi = md;
            }else{
                lo = md + 1;
            }
        }
        return hi;
    }

	
	
    // recursive solution - 11ms (<28.5%) 33MB(<100%)
    public int firstBadVersion2(int n) {
        return firstBadVersion2(n, 0, n);
    }
	
	private int firstBadVersion2(int n, int lo, int hi) {
		if(lo < hi) {
			int mid = lo + (hi-lo)/2;
			if(isBadVersion(mid)) {
				return firstBadVersion2(n, lo, mid-1);
			} else {
				return firstBadVersion2(n, mid+1, hi);
			}
		} else {
			return isBadVersion(lo) ? lo : lo+1;
		}
	}

	boolean isBadVersion(int n){
		count++;
		return (n >= this.badVersion);
	}
}

