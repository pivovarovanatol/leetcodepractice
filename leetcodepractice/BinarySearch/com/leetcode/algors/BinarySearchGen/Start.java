package com.leetcode.algors.BinarySearchGen;

public class Start {

	public static void main(String[] args) {
		// Implementing standard binary search
		
		int[] array = {17,18,19,20,21,22,22,23,24,25, 26};
		int n = array.length;
		
		int value = 19;
		
		int closestValue = getClosestK(array, value);
		
		System.out.println("Closest value = " + closestValue);
	}
	
	
	public static int getClosestK(int[] a, int x) {

	    int low = 0;
	    int high = a.length - 1;

	    if (high < 0)
	        throw new IllegalArgumentException("The array cannot be empty");

	    while (low < high) {
	        int mid = (low + high) / 2;
	        int d1 = Math.abs(a[mid  ] - x);
	        int d2 = Math.abs(a[mid+1] - x);
	        if (d2 <= d1)
	        {
	            low = mid+1;
	        }
	        else
	        {
	            high = mid;
	        }
	    }
	    return a[high];
	}	

}
