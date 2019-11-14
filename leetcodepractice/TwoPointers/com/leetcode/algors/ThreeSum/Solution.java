package com.leetcode.algors.ThreeSum;
// https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	
	
	// Same as mine but better organized -> 28ms(<93%) 43MB(<100%)
	public List<List<Integer>> threeSum(int[] nums) {
	    List<List<Integer>> res=new ArrayList<>();
	    Arrays.sort(nums);
	    for(int i=0;i<nums.length-2;i++){
	        if(i!=0&&nums[i]==nums[i-1])continue;
	        int j=i+1;
	        int k=nums.length-1;
	        while(j<k){
	            if(nums[i]+nums[j]+nums[k]>0)k--;
	            else if(nums[i]+nums[j]+nums[k]<0)j++;
	            else{
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
	                res.add(tmp);
	                j++;k--;
	                while(j<k&&nums[j]==nums[j-1])j++;
	                while(k>j&&nums[k]==nums[k+1])k--;
	            }
	        }
	    }
	    return res;
	}
	
	
	// Naive iterative solution with sliding window and HashSet to track duplicates. 235ms(<20%) and 50MB(<15%)
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        
        for (int i=0;i<n;i++){
            int firstIndex = i;
            int secondIndex = -1;
            int thirdIndex = -1;
            int start = i+1;
            int end = n-1;
            
            int sum = 0-nums[firstIndex];
            int tmp=0;
            while (start < end){
                tmp = nums[start] + nums[end];
                //System.out.println("Sum is " + sum + ", " + start + " " + end);
                if (tmp == sum){
                    secondIndex = start;
                    thirdIndex = end;
                    //System.out.println("Found match at " + firstIndex + " " + secondIndex + " " + thirdIndex);
                    String key = nums[firstIndex] + " | " + nums[secondIndex] + " | " + nums[thirdIndex];
                    if (!set.contains(key)){
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums[firstIndex]);
                        tmpList.add(nums[secondIndex]);
                        tmpList.add(nums[thirdIndex]);
                        result.add(tmpList);
                        set.add(key);
                    }
                    start++;
                    end--;
                } else if (tmp < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return result;
    }
}
