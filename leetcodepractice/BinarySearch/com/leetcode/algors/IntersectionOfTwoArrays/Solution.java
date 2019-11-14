package com.leetcode.algors.IntersectionOfTwoArrays;
// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.Arrays;
import java.util.HashSet;



class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // sort both arrays O(nlogn)
        // Go over smallest array and for every element binary search it in the second array. Ignore duplicates.
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> result = new HashSet<>();
        
        if (nums1.length < nums2.length){
            // go over first array
            for (int i=0;i<nums1.length;i++){
                if (exists(nums2, nums1[i])) {
                    result.add(nums1[i]);
                }
            }
            
        } else {
            // go over second array
            for (int i=0;i<nums2.length;i++){
                if (exists(nums1, nums2[i])) {
                    result.add(nums2[i]);
                }
            }
            
        }
        
        int[] res = new int[result.size()];
        int i=0;
        
        for (int element : result){
            res[i] = element;
            i++;
        }
        
        return res;
        
    }
    
    boolean exists (int[] arr, int n){
        
        int start = 0;
        int end = arr.length;
        
        while (start < end){
            int mid = start + (end - start)/2;
            //System.out.println("Looking for: " + n + " " + start + " - " + end + " | " + mid);

            if (arr[mid] == n){
                //System.out.println("Found: " + n + " at position  " + mid);
                return true;
            }
            
            if (arr[mid]>n){
                end = mid;
            } else {
                start = mid +1;
            }
        }
        return false;
    }
    
}