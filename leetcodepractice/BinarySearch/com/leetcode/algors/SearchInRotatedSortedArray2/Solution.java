package com.leetcode.algors.SearchInRotatedSortedArray2;
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii//

class Solution {
    // solved iteratively. 0ms(<100%) 43MB(<7%)
    public boolean search(int[] nums, int target) {
         if (nums.length==0){
            return false;
        }

         // solving iteratively
        int start=0;
        int end=nums.length-1;
        boolean index = false;
        int mid =0;
        
        while (end >= start){
            mid = (end+start)/2;
            if (nums[mid]==target){
                return true;
            }
            // check if the interval is not shifted
            
            if (nums[start] == nums[end]){
                end--;
                continue;
            }
            
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


