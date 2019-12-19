package com.leetcode.algors.DegreeOfAnArray;
//https://leetcode.com/problems/degree-of-an-array/

import java.util.HashMap;
import java.util.Map;




class Solution {
    
    // From discussions: combine searching for highest degree and marking start/end for each value. 38ms(<15%) 41.2MB(<89%) 
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> start = new HashMap<>();
        int resFreq = 0;
        int resLen=0;

        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            start.putIfAbsent(nums[i],i);
            if(freq.get(nums[i]) == resFreq){
               if(i-start.get(nums[i])<resLen)
                  resLen =  i-start.get(nums[i]);
             }
            else if(freq.get(nums[i]) > resFreq){
               resLen =  i-start.get(nums[i]);
               resFreq = freq.get(nums[i]);
            }
        }
        return resLen+1;
    }
    
    
    
    // Solved with 2 scans -> first to get the max degree, second to get the boundaries for that. 81ms(<6%) 40MB(<90%)
    public int findShortestSubArray1(int[] nums) {
        
        int n = nums.length;
        if (n==0){
            return 0;
        }
        
        if (n==1){
            return 1;
        }
        
        int shortest = Integer.MAX_VALUE;    
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxDegree=0;
        
        // Get the degree
        for (int i=0;i<n;i++){
            int tmp = freq.containsKey(nums[i]) ? freq.get(nums[i]) : 0;
            tmp++;
            freq.put(nums[i],tmp);
            if (tmp > maxDegree){
                maxDegree = tmp;
            }
        }
        
        for (int key : freq.keySet()){
            int val = freq.get(key);
            
            if (val==maxDegree) {
                int tmp = getShortestSubArrayLength(nums, key);
                //System.out.println(key + " = " + val + " : " + tmp);
                shortest = tmp < shortest ? tmp : shortest;
            }
        }

        return shortest;
    }
    
    int getShortestSubArrayLength(int[] nums, int val){
        int start=0;
        int end = nums.length-1;
        
        while (start <= end){
            if (nums[start] == val && nums[end] == val){
                return (end - start + 1);
            }
            
            if (nums[start] != val){
                start++;
            }
            
            if (nums[end] != val){
                end--;
            }
            
        }
        
        return 0;
    }
    
}
