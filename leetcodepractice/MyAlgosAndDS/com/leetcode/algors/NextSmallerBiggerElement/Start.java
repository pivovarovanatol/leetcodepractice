package com.leetcode.algors.NextSmallerBiggerElement;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {4,2,3,1,5,2,-7,0,1,11,2};

		Solution sl = new Solution();
		int[] result = sl.prevSmallerElement(arr);
		for (int e : result) 
			System.out.print(e + " ");

		System.out.println();
		
		result = sl.prevBiggerElement(arr);
		for (int e : result) 
			System.out.print(e + " ");
	
	}
    
}

