package com.leetcode.algors.Permutations2;
// https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums.length-1, nums, result);
            
        return result;
    }
    
    
    
    void permute(int start, int end, int[] nums, List<List<Integer>> result){
        
        if (start == end){
            printArray(nums);            
        }
        
        
        for (int i=start;i<=end;i++){
            swap(start, i, nums);
            permute(i+1, end, nums,result);
            swap(start, i, nums);
        }
        
    }
    

   void swap(int first, int second, int[] arr){
        int tmp = arr[second];
        arr[second] = arr[first];
        arr[first] = tmp;
    }

    void printArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
