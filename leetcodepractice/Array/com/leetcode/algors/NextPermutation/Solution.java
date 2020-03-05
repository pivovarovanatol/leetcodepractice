package com.leetcode.algors.NextPermutation;
// https://leetcode.com/problems/next-permutation/

import java.util.Arrays;

class Solution {
	
	// from discussions: same idea. instead of sorting the rest - just reverse the rest of the array. 0ms(<100%)  
	public void nextPermutation(int[] A) {
	    if(A == null || A.length <= 1) return;
	    int i = A.length - 2;
	    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
	    if(i >= 0) {                           // If not entirely descending
	        int j = A.length - 1;              // Start from the end
	        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
	        swap(A, i, j);                     // Switch i and j
	    }
	    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
	}

	public void swap(int[] A, int i, int j) {
	    int tmp = A[i];
	    A[i] = A[j];
	    A[j] = tmp;
	}

	public void reverse(int[] A, int i, int j) {
	    while(i < j) swap(A, i++, j--);
	}
	
    public void nextPermutation2(int[] nums) {
        // Idea: go from the back of the array with two pointers and compare 2 elements. If right is more than left -> permute and sort the rest of the array. 1ms(<43.7%) 39.4MB(<50%)
        int n = nums.length;
        int left = n-1;
        int right = n-1;
        boolean permuted = false;
        while (left >= 0){
        	int l = nums[left];
        	int r = nums[right];
            if (nums[left]<nums[right]){
                int tmp = nums[left];
                permuted = true;
                nums[left] = nums[right];
                nums[right] = tmp;
                sortRemainder(nums, left+1);
                break;
            }
            if (right<=left){
                left--;
                right = n-1;
            } else {
                right--;
            }
        }
        
        if (!permuted){
            Arrays.sort(nums);
        }
    }
    
    void sortRemainder(int[] nums, int start) {
    	// sorting using bubble sort
    	int end = nums.length-1;
    	while (start<=end) {
    		for (int i=start;i<=end;i++) {
    			if (nums[start]>nums[i]) {
    				int tmp = nums[start];
    				nums[start] = nums[i];
    				nums[i] = tmp;
    			}
    		}
			start++;
    	}
    	
    }
    
}

