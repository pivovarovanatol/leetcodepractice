package com.leetcode.algors.FirstBadVersion;
// https://leetcode.com/problems/first-bad-version/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Solution sl = new Solution();
		sl.badVersion = 100;
		sl.count = 0;
		int result = sl.firstBadVersion(250000);

		System.out.println(result);
	}
    
}

