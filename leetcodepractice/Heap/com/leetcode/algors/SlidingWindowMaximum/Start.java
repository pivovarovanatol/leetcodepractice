package com.leetcode.algors.SlidingWindowMaximum;
// https://leetcode.com/problems/sliding-window-maximum/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 3;
		int[] nums = {1,3,-1,-3,-1,-1,-1,5,3,6,7};
		Solution sl = new Solution();
		int res[] = sl.maxSlidingWindow(nums, k);

		for (int e : res) {
			System.out.print(e + " ");
		}
	}
    
}

