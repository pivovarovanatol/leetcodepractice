package com.leetcode.algors.SingleNumber;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "A man, a plan, a canal: Panama";
		
		Solution sl = new Solution();
		int[] arr = {2,2,1};
		int result = sl.singleNumber(arr);
		System.out.println(result);
		
	}

}
