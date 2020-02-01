package com.leetcode.algors.FourSum2;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int A[] = {1,2};
//		int B[] = {-2,-1};
//		int C[] = {-1,2};
//		int D[] = {0,2};
//		int target=2;
		
		int A[] = {0,1,-1};
		int B[] = {-1,1,0};
		int C[] = {0,0,1};
		int D[] = {-1,1,1};
		int target=17;
		
		Solution sl = new Solution();
		int result = sl.fourSumCount(A, B, C, D);
		
		System.out.println("Actual = "+result);
		System.out.println("Expected = "+result);
	}

}
