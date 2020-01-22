package com.leetcode.algors.SearchInRotatedSortedArray;
// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
	
	// solved iteratively. 0ms(<100%) 42MB(<6%)
    public int search(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        
        // solving iteratively
        
        int start=0;
        int end=nums.length-1;
        int index = -1;
        int mid =0;
        
        while (end >= start){
            mid = (end+start)/2;
            if (nums[mid]==target){
                return mid;
            }
            // check if the interval is not shifted
            
            if (nums[start]<=nums[mid]){
                if (target<nums[mid] && target>=nums[start]){
                    end = mid-1;
                } else {
                    start=mid+1;
                }
            } else {
                 if(target>nums[mid] && target<=nums[end]){
                     start=mid+1;
                 } else {
                     end = mid-1;
                 }
            }
        }
        return index;
    }
    
}