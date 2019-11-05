package com.leetcode.algors.HouseRobber;
// https://leetcode.com/problems/house-robber/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {1,2,3,1};
		//int[] arr = {1,2,3,1};
		int[] arr = {2,7,9,3,1};

		// int n= arr.length;
		Solution sl = new Solution();
		int result = sl.rob(arr);
		System.out.println(result);
	}

}
