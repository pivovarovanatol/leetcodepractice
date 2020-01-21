package com.leetcode.algors.RemoveDuplicatesFromSortedArray2;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
	// solved with two pointers. 1ms(<65%) 45MB(<6%)
    public int removeDuplicates(int[] nums) {
        
        int pointer1 = 1;
        int pointer2 = 1;
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        
        //int val=nums[0];
        int count=1;
        
        while (pointer2 < n){
            if (nums[pointer2] == nums[pointer2-1]){
                count++;
                if (count <= 2){
                    nums[pointer1] = nums[pointer2];
                    pointer1++;
                } 
                
            } else {
                nums[pointer1] = nums[pointer2];
                //val = nums[pointer2];
                count=1;
                pointer1++;
            }
            pointer2++;
        }
        
        return pointer1;
    }
}
