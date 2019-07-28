package com.leetcode.algors.RemoveElement;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3,4,5,6,7,8,9,10};
		Solution sl = new Solution();
		
		int result = 0;
		result = sl.removeElement(nums, 5);
		System.out.println(result);
		
		for (int i=0;i<result;i++) {
			System.out.print(nums[i]);
		}
	}

}
