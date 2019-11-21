package com.leetcode.algors.Permutations;
// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        int n= nums.length;
        
        // Try to solve it with recursion
        // permuteHelper(nums, n, result);
        
        permuteHelperIterative(nums, n, result);
        
        
        return result;
    }
    
    
    
    // iterative solution. 1ms (<97%) 37MB(<97%)
    void permuteHelperIterative(int[] nums, int n, List<List<Integer>> result) {
    	
    	int[] indexes = new int[n];
    	for (int i = 0; i < n; i++) {
    	    indexes[i] = 0;
    	}
    	 
    	//printArray(nums);
        List<Integer> arr = new ArrayList<>();
        for (int j=0;j<nums.length;j++){
            arr.add(nums[j]);
        }
        result.add(arr);
    	 
    	int i = 0;
    	while (i < n) {
    	    if (indexes[i] < i) {
    	        swap(nums, i % 2 == 0 ?  0: indexes[i], i);
    	        
    	        //printArray(nums);
                arr = new ArrayList<>();
                for (int j=0;j<nums.length;j++){
                    arr.add(nums[j]);
                }
                result.add(arr);
    	        
    	        indexes[i]++;
    	        i = 0;
    	    }
    	    else {
    	        indexes[i] = 0;
    	        i++;
    	    }
    	}    	
    	
    }
    
    // recursive solution. 0ms (<100%) 37.2MB(<97%)
    void permuteHelper(int[] nums, int n, List<List<Integer>> result){
        if (n == 1){
            // create a list and add to result list
            List<Integer> arr = new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                arr.add(nums[i]);
            }
            //printArray(nums);
            result.add(arr);
            return;
        } else {
        	
            for (int i=0;i<n-1;i++){
                permuteHelper(nums,n-1,result);
                
                if (n%2 == 0) {
                	swap(nums,i,n-1);
                } else {
                	swap(nums,0,n-1);
                }
            }
            permuteHelper(nums,n-1,result);	
        }
        
    }
    
    void swap(int[] nums, int first, int second){
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }
    
    
    void printArray(int[] arr){
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    
}

